package is.network;


import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;

import is.BaseCheck;

public class Network extends BaseCheck {


    public Network(Context context) {
        super(context);
    }

    /**
     *  If you want to use this method, you must got permission that <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
     * @return boolean
     */
    public boolean isNetworkEnabled(){
        ConnectivityManager connectivityMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        // Check if wifi or mobile network is available or not. If any of them is
        // available or connected then it will return true, otherwise false;
        if (wifi != null) {
            if (wifi.isConnected()) {
                return true;
            }
        }
        if (mobile != null) {
            if (mobile.isConnected()) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method use only API 21 >=
     * @return isMobileDataEnabled boolean
     * @throws Exception
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public boolean isMobileDataEnabled() {
        return Settings.Global.getInt(context.getContentResolver(), "mobile_data", 0) == 1;

    }

    /**
     * <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
     * ASSOCIATED - Association completed.
     * ASSOCIATING - Trying to associate with an access point.
     * COMPLETED - All authentication completed.
     * DISCONNECTED - This state indicates that client is not associated, but is likely to start looking for an access point.
     * DORMANT - An Android-added state that is reported when a client issues an explicit DISCONNECT command.
     * FOUR_WAY_HANDSHAKE - WPA 4-Way Key Handshake in progress.
     * GROUP_HANDSHAKE - WPA Group Key Handshake in progress.
     * INACTIVE - Inactive state.
     * INVALID - A pseudo-state that should normally never be seen. SCANNING - Scanning for a network.
     * UNINITIALIZED - No connection.
     * thanks to http://stackoverflow.com/a/12560395/4630627
     * @return
     */
    public NetworkInfo.State getWifiState(){
        ConnectivityManager cm =    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return  cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
    }







}
