package com.testing.atul.genghiskhan;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;

/**
 * Created by Atul on 2/25/2018.
 */

class ListProvider implements RemoteViewsService.RemoteViewsFactory {
    private ArrayList<String> items = new ArrayList<>();
    private Context context;

    ListProvider(Context context, Intent intent) {
        this.context=context;
        DBHelper helper=new DBHelper(context,"feeds",null,1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM drums",null);
        Log.d("gun","gunner");
        c.moveToFirst();
        do{
            items.add(c.getString(1));
            Log.d("gun",c.getString(1));
        }while (c.moveToNext());
        c.close();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        final RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.list_boxy);
        rv.setTextViewText(R.id.list_box1, items.get(position));
        return rv;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}
