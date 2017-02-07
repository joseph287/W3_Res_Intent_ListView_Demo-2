package com.example.mymac.w3_res_intent_listview_demo;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mymac.w3_res_intent_listview_demo.Utils.Utils;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private EditText edtxt1, edtxt2, edtxt3;
    private ListView lv;
    private String[] my_courses_items;
    private View lastview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1_ma1);
        edtxt1=(EditText)findViewById(R.id.edtxt1_age_ma1);
        edtxt2=(EditText)findViewById(R.id.edtxt2_age_ma1);
        edtxt3=(EditText)findViewById(R.id.edtxt3_age_ma1);
        lv=(ListView)findViewById(R.id.lv_ma1);
        my_courses_items=getResources().getStringArray(R.array.my_courses_items);
        btn1.setOnClickListener(new MyLssnr());

        lastview = null;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, my_courses_items);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (lastview != null)
                    lastview.setBackgroundColor(Color.BLUE);
                view.setBackgroundColor(Color.LTGRAY);
                lastview = view;
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra(Utils.MSG_KEY_INTENT, "The course is " +my_courses_items[i]);
                startActivity(intent);
            }
        });
    }

    public void showMap(View view) {
        Intent newInt = new Intent(Intent.ACTION_VIEW);
        newInt.setData(Uri.parse("geo:0,0?q="  +edtxt3.getText()));
        startActivity(newInt);
    }

    class MyLssnr implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra(Utils.MSG_KEY_INTENT, "Your age is " +edtxt1.getText());
            intent.putExtra(Utils.MSG_KEY_2, "Your Name is " +edtxt2.getText());
            startActivity(intent);
        }
    }
}