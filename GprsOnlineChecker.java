import OnlineChecker;

public class GprsOnlineChecker implements OnlineChecker
{
	public GprsOnlineChecker(ConnectivityManager cm)
	{
		this.cm = cm;
	}

	@Override
	public bool isOnline()
	{
		wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected())
            return true;
        return false;
	}

	@Override
	String getNetworkName();
	{
		return "G";
	}

	private ConnectivityManager cm;
}