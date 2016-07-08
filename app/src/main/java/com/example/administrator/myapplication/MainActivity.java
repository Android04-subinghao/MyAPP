package com.example.administrator.myapplication;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity implements View.OnClickListener, Runnable {

    TextView mTv;
    Button mButton;
    ImageButton mImageButton;
    ProgressBar mProgressBar;
    int count = 60;
    MyHandler m;
    TextView mTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.textView);
        mButton = (Button) findViewById(R.id.button);
        mImageButton = (ImageButton) findViewById(R.id.imageButton);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mTv.setOnClickListener(this);
        mButton.setOnClickListener(this);
        mImageButton.setOnClickListener(this);
        mProgressBar.setMax(60);
        mProgressBar.setProgress(60);
        m = new MyHandler();
        new Thread(this).start();


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            mTv.setText("下班了");//设置文本框内容
            Toast.makeText(MainActivity.this, "点击了开始", Toast.LENGTH_SHORT).show();//吐司通知
        }
        if (v.getId() == R.id.imageButton) {
            mTv.setText("安卓机器人");//设置文本框内容
            Toast.makeText(MainActivity.this, "点击了图片", Toast.LENGTH_SHORT).show();//吐司通知
        }
    }
//    public void showDiolog(){
//        AlertDialog.Builder builder=new AlertDialog.Builder(this);
//        builder.setTitle("sisisi");
//        builder.setMessage("sisakjjkkj");
//        String[] str={"1","2"};
//        builder.setItems(str, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "你好", Toast.LENGTH_SHORT).show();
//            }
//        });
//        builder.show();
//    }

    @Override
    public void run() {
        while (count >= 0) {
            m.sendEmptyMessage(0);
            try {
                Thread.sleep(1000);
                count--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        mClient.connect();
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app URL is correct.
//                Uri.parse("android-app://com.example.administrator.myapplication/http/host/path")
//        );
//        AppIndex.AppIndexApi.start(mClient, viewAction);
//    }

//    @Override
//    public void onStop() {
//        super.onStop();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app URL is correct.
//                Uri.parse("android-app://com.example.administrator.myapplication/http/host/path")
//        );
//        AppIndex.AppIndexApi.end(mClient, viewAction);
//        mClient.disconnect();
//    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (count == 0) {
                    mTv.setText("时间用尽");
                }
                mProgressBar.setProgress(count);
            }
        }


    }

}
