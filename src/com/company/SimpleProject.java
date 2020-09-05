package com.company;

public class SimpleProject {

    public static void main(String[] args) {
        NetworkManager manager = new NetworkManager();

        ConnectivityManager cm = new ConnectivityManager();
        manager.addOnlineChecker(new WiFiOnlineChecker(cm));
        manager.addOnlineChecker(new GprsOnlineChecker(cm));
        manager.addOnlineChecker(new ConnectionOnlineChecker(cm));

        manager.isOnline();
    }
}