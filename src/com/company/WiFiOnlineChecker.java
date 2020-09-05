package com.company;

public class WiFiOnlineChecker implements OnlineChecker
{
	public WiFiOnlineChecker(ConnectivityManager cm)
	{
		this.cm = cm;
	}

	@Override
	public boolean isOnline()
	{
		NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        else {
        	wifiInfo = cm.getActiveNetworkInfo();
            if (wifiInfo != null && wifiInfo.isConnected()) {
                return true;
            }
        }
        return false;
	}

	@Override
	public String getNetworkName() {
		return "W";
	}

	private ConnectivityManager cm;
}