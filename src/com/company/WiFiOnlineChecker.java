import OnlineChecker;

public class WiFiOnlineChecker implements OnlineChecker
{
	public WiFiOnlineChecker(ConnectivityManager cm)
	{
		this.cm = cm;
	}

	@Override
	public bool isOnline()
	{
		NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true
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
	String getNetworkName();
	{
		return "W";
	}

	private ConnectivityManager cm;
}