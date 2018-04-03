package com.padtast.mydialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.padtast.mydialog.mydialog.MyDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 new MyDialog.Builder().setContext(MainActivity.this)
                                        .setMsgString("荒诞收看电视看电视")
                         .setStrategy(MyDialog.OKANDREMOVE)
                         .setOkButtonString("姜思达")
                         .setCancelButtonString("圣诞节绝对是")
                                        .build();
            }
        });
    }
}
