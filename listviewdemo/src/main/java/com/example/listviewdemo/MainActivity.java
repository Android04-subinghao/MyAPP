package com.example.listviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    Button mButton;
    Button mButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=(TextView) findViewById(R.id.textView);
        mTextView.setText(String.format("Task id:%d\nActivity id:%s",getTaskId(),toString()));
        mButton=(Button) findViewById(R.id.button);
        mButton1=(Button) findViewById(R.id.button3);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(MainActivity.this,MainActivity.class);
                startActivity(it);
            }
        });
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(MainActivity.this,Second.class);
                startActivity(it);
            }
        });
    }
}
