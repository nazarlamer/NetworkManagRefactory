package com.example.user.test6.classes;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AskmemNetworkManager {
    private static Context cnt;

    public static boolean isOnline() {
        return isOnlineClass();
    }

    private static boolean isOnlineClass() {
        try {
            cnt.getApplicationContext();
            
			ConnectivityManager cm = (ConnectivityManager) cnt.getSystemService(Context.CONNECTIVITY_SERVICE);
            boolean cWifi = false;
            boolean cGprs = false;
            boolean cWifi1 = false;
            boolean cConn = false;
            
			NETWWIFI = false;
            NETWWIFIName = "";

            if (cm != null && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected()) {
                cConn = true;
                tnetwork_c = "U";
            }

            if (Build.VERSION.SDK_INT >= 23 && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && !cConn) {
                cConn = true;
                tnetwork_c = "A";
            }

            NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (wifiInfo != null && wifiInfo.isConnected()) {
                
                tnetwork_c = "W";
                cWifi = true;

                WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfoS = wifiManager.getConnectionInfo();
                NETWWIFI = true;
                NETWWIFIName = wifiInfoS.getMacAddress().toString() + "$$$$$" + wifiInfoS.getSSID().toString();
            }

            wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (wifiInfo != null && wifiInfo.isConnected()) {
                tnetwork_c = "G";
                cGprs = true;
            }

            wifiInfo = cm.getActiveNetworkInfo();
            if (wifiInfo != null && wifiInfo.isConnected()) {
                if (!cWifi && !cGprs)
                    tnetwork_c = "W";
                cWifi1 = true;
            }

            if (cWifi || cGprs || cWifi1 || cConn) {
                try {
                    tnetwork_c = tnetwork_c + "-" + getNetworkClass();

                    HttpURLConnection urlc = (HttpURLConnection) (new URL("http://www.lviv.ua")).openConnection();
                    urlc.setRequestProperty("Connection", "close");
                    urlc.setConnectTimeout(4000);
                    urlc.setReadTimeout(4000);
                    urlc.connect();
                    if (urlc.getResponseCode() == 200) {
                        return true;
                    }
                } catch (MalformedURLException e1) {
                    return false;
                } catch (IOException e) {
                    return false;
                }
            }
        }catch (IllegalArgumentException e) {
            RecordLog("ServiceGPS.isOnline IllegalArgumentException", "Помилка "+e.toString());
        }catch (Exception e) {
            RecordLog("AskmemNetworkManager.isOnline Exception", "Помилка "+e.toString());
        }
        return false;
    }
}
