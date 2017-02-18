package com.example.widget;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/2/18.
 */
public class TimerService extends Service {
    private Timer timer;
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateViews();
            }
        }, 0, 1000);//每秒更新一次，延时是0
    }

    /**
     * 更新界面
     */
    private void updateViews(){
        String time=sdf.format(new Date());
        RemoteViews rv=new RemoteViews(getPackageName(),R.layout.widget);
        rv.setTextViewText(R.id.tv, time);
        AppWidgetManager manager=AppWidgetManager.getInstance(getApplicationContext());

        ComponentName cn=new ComponentName(getApplicationContext(),WidgetProvider.class);
        manager.updateAppWidget(cn,rv);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer=null;//销毁时停止计时器
    }
}
