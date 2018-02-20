package com.testing.atul.genghiskhan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Atul on 2/19/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String dbName = "Feeds.db";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ FeedContract.FeedEntry.TABLE_NAME+" ("+
                FeedContract.FeedEntry._ID+" INTEGER PRIMARY KEY,"+
                FeedContract.FeedEntry.COL_NAME+ "TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS drums");
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldV, int newV){
        onUpgrade(db,oldV,newV);
    }

}
