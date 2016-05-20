package com.blz.leanclouddemo;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by BuLingzhuang
 * on 2016/5/20
 * E-mail bulingzhuang@foxmail.com
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this,"QE1TkxBWnS9dVlc4VJ34v3DP-gzGzoHsz","wDJOMOgfK5mY1BqnCstWcYcy");
    }
}
