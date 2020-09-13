package com.symb.task.todo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CreateActivity extends AppCompatActivity{
    private Button save_button;
    private EditText descEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        descEditText=(EditText)findViewById(R.id.createInput);
        save_button=(Button)findViewById(R.id.btn_save);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=descEditText.getText().toString();
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                Calendar c=Calendar.getInstance();
                String date=sdf.format(c.getTime());
                FeedReaderDbHelper dbHelper=new FeedReaderDbHelper(getBaseContext());
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put(FeedReaderContract.FeedEntry.COLUMN_NAME,data);
                values.put(FeedReaderContract.FeedEntry.COLUMN_DATE,date);
                long newRowId=db.insert(FeedReaderContract.FeedEntry.TABLE_NAME,null,values);
                finish();
            }
        });

    }
}