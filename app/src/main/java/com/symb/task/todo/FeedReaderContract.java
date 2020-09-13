package com.symb.task.todo;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    private FeedReaderContract(){}
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME="tb_todo";
        public static final String COLUMN_NAME="description";
        public static final String COLUMN_DATE="date";
        public static final String _ID="_id";
        public static final String SQL_CREATE_ENTRIES="CREATE TABLE " + FeedEntry.TABLE_NAME + " (" + FeedEntry._ID + " INTEGER PRIMARY KEY," + FeedEntry.COLUMN_NAME + " TEXT ," +FeedEntry.COLUMN_DATE + " date)";
        public static final String SQL_DELETE_ENTRIES ="DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
    }
}
