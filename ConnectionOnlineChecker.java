import OnlineChecker;

public class ConnectionOnlineChecker implements OnlineChecker
{
	public ConnectionOnlineChecker(ConnectivityManager cm)
	{
		this.cm = cm;
	}

	@Override
	public bool isOnline()
	{
		if (cm != null && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected()) {
            return true;
        }

        if (Build.VERSION.SDK_INT >= 23 && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && !cConn) {
            return true;
        }

        return false;
	}

	@Override
	String getNetworkName();
	{
		return "U";
	}

	private ConnectivityManager cm;
}