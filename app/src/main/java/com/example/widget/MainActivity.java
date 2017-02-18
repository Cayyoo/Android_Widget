package com.example.widget;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * 案例：时钟Widget
 *
 * 注意：Widget仅支持部分布局、组件。组件宽高也不能设置过大，否则也会不显示。
 *
 * Widget开发只用到了TimerService和WidgetProvider这两个类，重点是掌握Widget开发步骤
 */

/**
 * Widget开发步骤：
 * 1、新建widget布局,widget.xml
 * 2、新建widget配置文件，本例中是xml文件夹下的widget_config.xml
 * 3、编写TimerService.java和WidgetProvider.java两个类
 * 4、在AndroidManifest.xml中注册TimerService和WidgetProvider并配置相关参数
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


}
