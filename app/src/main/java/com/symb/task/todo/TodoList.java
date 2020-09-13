package com.symb.task.todo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import java.util.ArrayList;
import java.util.List;
public class TodoList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        recyclerView=(RecyclerView)findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        FeedReaderDbHelper dbHelper=new FeedReaderDbHelper(getBaseContext());
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor=db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                null,null,null,null,null,null
        );
        ArrayList<Todo> itemIds=new ArrayList<Todo>();
        while(cursor.moveToNext()){
            String itemId=cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME));
            String date=cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_DATE));
            itemIds.add(new Todo(itemId,date));
        }
        cursor.close();
        mAdapter=new MyAdapter(itemIds);
        recyclerView.setAdapter(mAdapter);
        for(int i=0;i<itemIds.size();i++)
        {
            Todo td=itemIds.get(i);
            System.out.println(td.desc);
            System.out.println(td.date);
        }
    }
}