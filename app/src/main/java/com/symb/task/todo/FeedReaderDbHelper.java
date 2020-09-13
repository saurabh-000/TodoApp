package com.symb.task.todo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.symb.task.todo.FeedReaderContract.FeedEntry.SQL_CREATE_ENTRIES;
import static com.symb.task.todo.FeedReaderContract.FeedEntry.SQL_DELETE_ENTRIES;

public class FeedReaderDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=11;
    public static final String DATABASE_NAME="FeedReader.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL(SQL_DELETE_ENTRIES);
       onCreate(db);
    }
}
