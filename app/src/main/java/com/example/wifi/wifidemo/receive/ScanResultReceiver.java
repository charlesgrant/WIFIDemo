package com.example.wifi.wifidemo.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.example.wifi.wifidemo.Courier;
import com.example.wifi.wifidemo.WiFiHandler;
import com.example.wifi.wifidemo.constact.Global;
import com.example.wifi.wifidemo.entity.AccessPoint;

import java.util.List;

public class ScanResultReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("WIFIX",intent.getAction());
        if (intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
            boolean isScanned = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, true);
            if (isScanned) {
                List<AccessPoint> aps = WiFiHandler.instance().getScanAp();
                if (aps != null) {
                    Courier.send(Global.AP_AVAILABLE, WiFiHandler.mergeRelativeAPs(aps));
                }
            }
        }
    }
}