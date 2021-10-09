package com.example.slideconflictdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TestViewpager testViewpager;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        LayoutInflater inflater = getLayoutInflater();
        testViewpager = findViewById(R.id.testViewpager);

        for (int i = 0; i < 3; i++) {
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.content_layout,testViewpager,false);
            TextView tv = layout.findViewById(R.id.tvTitle);
            tv.setText("page" + (i+1));
            layout.setBackgroundColor(Color.rgb(255 / (i + 1), 255 / (i + 1), 0));
            createList(layout);
//            testViewpager.addView(layout);
        }
    }
    private void createList(ViewGroup layout){
        listView = layout.findViewById(R.id.listItem);
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add("name" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.content_list_item,R.id.tvName,datas);
        listView.setAdapter(adapter);
    }

}