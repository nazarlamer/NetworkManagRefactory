package com.company;

public class ConnectivityManager {

    public static int TYPE_WIFI = 10;
    public static int TYPE_MOBILE = 11;

    private static int ACTIVE = 42;

    NetworkInfo getNetworkInfo(int networkType) {
        return new NetworkInfo(networkType);
    }

    NetworkInfo getActiveNetworkInfo() {
        return new NetworkInfo(ACTIVE);
    }
}
