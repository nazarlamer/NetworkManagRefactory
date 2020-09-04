public interface OnlineCheckerInterface
{
	abstract boolean isOnline();
	abstract String getNetworkName();
	
    public static void PrintName() {
        System.out.println("THIS OnlineCheckerInterface");
    }
}