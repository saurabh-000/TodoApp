package com.symb.task.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button button_create,button_list;
    //Button button_list=findViewById(R.id.btn_list);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button_create=(Button) findViewById(R.id.btn_create);
        button_list=(Button)findViewById(R.id.btn_list);
        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_create=new Intent(HomeActivity.this,CreateActivity.class);
                startActivity(intent_create);
            }
        });
        button_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_list=new Intent(HomeActivity.this,TodoList.class);
                startActivity(intent_list);
            }
        });
    }
}