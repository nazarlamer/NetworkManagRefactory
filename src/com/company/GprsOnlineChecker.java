package com.company;

public class GprsOnlineChecker implements OnlineChecker
{
	public GprsOnlineChecker(ConnectivityManager cm)
	{
		this.cm = cm;
	}

	@Override
	public boolean isOnline()
	{
		NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected())
            return true;
        return false;
	}

	@Override
	public String getNetworkName()
	{
		return "G";
	}

	private ConnectivityManager cm;
}