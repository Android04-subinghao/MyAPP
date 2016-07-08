package com.example.listviewdemo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class diolog extends AppCompatActivity implements Runnable{
    Button mButton;
    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;
    ProgressDialog builder;
    final String[] mItems={"item1","item2","item3","item4","item5","item6"};

    int   mSingleChoiceID = -1;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diolog);
        mButton= (Button) findViewById(R.id.button4);
        mButton1= (Button) findViewById(R.id.button5);
        mButton2= (Button) findViewById(R.id.button6);
        mButton3= (Button) findViewById(R.id.button7);
        mButton4= (Button) findViewById(R.id.button8);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfo();
            }
        });
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgress();
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressBar();
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCancel();
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showList();
            }
        });
    }
    public void showInfo(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("单选对话框");
        builder.setSingleChoiceItems(mItems, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mSingleChoiceID =which;
                showDialog("你选择的是:"+which+mItems[which]);
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (mSingleChoiceID>0){
                    showDialog("你选择的是："+mSingleChoiceID);
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
    }
    private void showDialog(String str) {
        new AlertDialog.Builder(this)
                .setMessage(str)
                .show();
    }
    public void showProgress(){
        builder=new ProgressDialog(this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("进度条");
        builder.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        builder.setMax(100);
        builder.setProgress(100);
        builder.setButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
        new Thread(this).start();
    }

    @Override
    public void run() {
        int count=0;
        while (count<60){
            try {
                Thread.sleep(1000);
                count++;
                builder.incrementProgressBy(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void showProgressBar(){
        mProgressDialog=new ProgressDialog(this);
        mProgressDialog.setTitle("读取ing");
        mProgressDialog.setMessage("正在缓冲，请稍等。。。。");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();
    }
    public void showCancel(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("你确定要离开吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //这里添加点击确定后的逻辑
                showDialog("你选择了确定");
                Toast.makeText(diolog.this,"离开", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //这里添加点击确定后的逻辑
                showDialog("你选择了取消");
                Toast.makeText(diolog.this,"取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void showList(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("列表选择框");
        builder.setItems(mItems, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //点击后弹出窗口选择了第几项
                showDialog("你选择的id为" + which + " , " + mItems[which]);
            }
        });
        builder.show();
    }
}
