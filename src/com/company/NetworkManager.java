package com.company;

import java.util.ArrayList;

public class NetworkManager {

    private ArrayList<OnlineChecker> onlineCheckers = new ArrayList<OnlineChecker>();

	public void addOnlineChecker(OnlineChecker checker)
    {
        onlineCheckers.add(checker);
    }

    public boolean isOnline() {
        return isOnlineImpl();
    }

    private boolean isOnlineImpl() {
        try {
            boolean isOnline = false;
            String networkName = "NG";
            for (OnlineChecker checker : onlineCheckers)
            {
                if (checker.isOnline())
                {
                    isOnline = true;
                    networkName = checker.getNetworkName();
                    break;
                }
            }

            if (isOnline) {
                System.out.println("Online " + networkName);
                return true;
            }
            else
            {
                System.out.println("Offline ");
                return false;
            }
        }catch (Exception e) {
            System.out.println("NetworkManager.isOnlineImpl Exception" + e.toString());
        }
        return false;
    }
}
