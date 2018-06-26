package com.example.wifi.wifidemo;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.Vector;

public class Courier {

    private static Handler mainHandler;
    private static Vector<Message> abandonMessage = new Vector<>();

    public static void setMainHander(Handler hander) {
        mainHandler = hander;
    }

    public static void send(Message message) {
        Log.d("WIFIX","send message :" + message.what);
        if (null != mainHandler) {
            mainHandler.sendMessage(message);
        } else {
            abandonMessage.add(message);
        }
    }

    public static void send(int what) {
        Message message = Message.obtain();
        message.what = what;
        send(message);
    }

    public static void send(int what,Object obj) {
        Message message = Message.obtain();
        message.what = what;
        message.obj = obj;
        send(message);
    }

    public static void recycle() {
        mainHandler.removeCallbacksAndMessages(null);
        mainHandler = null;
        abandonMessage.clear();
    }
}