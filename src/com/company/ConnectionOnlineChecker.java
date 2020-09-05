package com.company;

public class ConnectionOnlineChecker implements OnlineChecker
{
	public ConnectionOnlineChecker(ConnectivityManager cm)
	{
		this.cm = cm;
	}

	@Override
	public boolean isOnline()
	{
		if (cm != null && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected()) {
            return true;
        }

        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable()) {
            return true;
        }

        return false;
	}

	@Override
	public String getNetworkName()
	{
		return "U";
	}

	private ConnectivityManager cm;
}