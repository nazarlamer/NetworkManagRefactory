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
    private List<OnlineChecker> onlineCkeckers;

    // Перед викликом isOnline я повинен в клієнтському коді додати чекери ??
	// немає сенсу цього робити з клієнтського коду так як я повинен перевірити всі можливі чекери !?
	public void addOnlineChecker(OnlineChecker cheker)
    {
        onlineCkeckers.insert(checker);
    }

    public static boolean isOnline() {
        return isOnlineClass();
    }

    private static boolean isOnlineClass() {
        try {

            boolean isOnline = false;
            for (OnlineChecker checker in onlineCkeckers)
            {
                String tnetwork_c = "NG";
                if (cheker.isOnline)
                {
                    isOnline = true;
                    tnetwork_c = checker.getNetworkName();
                    break;
                }
            }

            if (isOnline) {
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
