package com.testing.atul.genghiskhan;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by Atul on 2/19/2018.
 */

public class FassyWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int i:appWidgetIds){
            Intent it = new Intent(context,MainActivity.class);
            PendingIntent pit = PendingIntent.getActivity(context,0,it,0);

            RemoteViews views= new RemoteViews(context.getPackageName(),R.layout.app_widget_layout);
            views.setOnClickPendingIntent(R.id.button,pit);
            appWidgetManager.updateAppWidget(i,views);
        }
    }
}
