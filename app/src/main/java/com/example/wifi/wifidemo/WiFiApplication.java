package com.example.wifi.wifidemo;

import android.app.Application;

/**
 * Created by kwong on 2018/6/26.
 */

public class WiFiApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        WiFiHandler.instance().init(this);
    }
}
