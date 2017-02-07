package com.example.mymac.w3_res_intent_listview_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mymac.w3_res_intent_listview_demo.Utils.Utils;

public class Main2Activity extends AppCompatActivity {

    private TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1 = (TextView) findViewById(R.id.tv1_ma2);
        tv1.setText(getIntent().getStringExtra(Utils.MSG_KEY_INTENT));
        tv2 = (TextView) findViewById(R.id.tv2_ma2);
        tv2.setText(getIntent().getStringExtra(Utils.MSG_KEY_2));

    }
}