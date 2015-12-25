package is.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.BatteryManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

import java.lang.reflect.Method;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Phones extends BaseCheck{


    public Phones(Context context) {
        super(context);
    }

    /**
     * Check phone brand
     * @param brandName
     * @return
     */
    public boolean isBrand(String brandName){
        return  android.os.Build.MANUFACTURER.contains(brandName);
    }

    /**
     * thanks to http://stackoverflow.com/a/9624844/4630627
     * Checks if the device is a tablet or a phone
     *
     * @param activityContext
     *            The Activity Context.
     * @return Returns true if the device is a Tablet
     */
    public boolean isTabletDevice(Context activityContext) {
        // Verifies if the Generalized Size of the device is XLARGE to be
        // considered a Tablet
        boolean xlarge = ((activityContext.getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_XLARGE);

        // If XLarge, checks if the Generalized Density is at least MDPI
        // (160dpi)
        if (xlarge) {
            DisplayMetrics metrics = new DisplayMetrics();
            Activity activity = (Activity) activityContext;
            activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);

            // MDPI=160, DEFAULT=160, DENSITY_HIGH=240, DENSITY_MEDIUM=160,
            // DENSITY_TV=213, DENSITY_XHIGH=320
            if (metrics.densityDpi == DisplayMetrics.DENSITY_DEFAULT
                    || metrics.densityDpi == DisplayMetrics.DENSITY_HIGH
                    || metrics.densityDpi == DisplayMetrics.DENSITY_MEDIUM
                    || metrics.densityDpi == DisplayMetrics.DENSITY_TV
                    || metrics.densityDpi == DisplayMetrics.DENSITY_XHIGH) {

                // Yes, this is a tablet!
                return true;
            }
        }
        // No, this is not a tablet!
        return false;
    }

    /**
     * thanks to http://stackoverflow.com/a/26584929/4630627
     * @return isPlugged
     */
    public boolean isPlugged() {
        boolean isPlugged= false;
        Intent intent = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        isPlugged = plugged == BatteryManager.BATTERY_PLUGGED_AC || plugged == BatteryManager.BATTERY_PLUGGED_USB;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            isPlugged = isPlugged || plugged == BatteryManager.BATTERY_PLUGGED_WIRELESS;
        }
        return isPlugged;
    }

    /**
     *
     * @return isDisabled
     * @throws Exception
     */
    public boolean isLockScreenDisabled() throws Exception {
        String LOCKSCREEN_UTILS = "com.android.internal.widget.LockPatternUtils";

        Class<?> lockUtilsClass = Class.forName(LOCKSCREEN_UTILS);
        // "this" is a Context, in my case an Activity
        Object lockUtils = lockUtilsClass.getConstructor(Context.class).newInstance(context);
        Method method = lockUtilsClass.getMethod("isLockScreenDisabled");
        boolean isDisabled = Boolean.valueOf(String.valueOf(method.invoke(lockUtils)));
        return isDisabled;

    }

    public static boolean checkBuildNumber(int number){
        return android.os.Build.VERSION.SDK_INT >= number;
    }

    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    public String getDeviceId(){
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null) {

            String androidId = Settings.Secure.getString(contentResolver,
                    Settings.Secure.ANDROID_ID);
            return androidId;
        }else{
            return null;
        }

    }

    /**
     *
     * @return OS Version
     */
    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     *
     * @return device IMEI as string
     */
    public static String getDeviceImei(Context ctx) {
        TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

    /**
     * @return getBluetoothState
     * @throws Exception
     */
    @TargetApi(Build.VERSION_CODES.ECLAIR)
    public static int getBluetoothState() throws Exception {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter
                .getDefaultAdapter();
        if (bluetoothAdapter == null) {
            throw new Exception("bluetooth device not found!");
        } else {
            return bluetoothAdapter.getState();
        }
    }

    /**
     * @return isBluetoothOpen
     * @throws Exception
     */
    public static boolean isBluetoothOpen() throws Exception {
        int bluetoothStateCode = getBluetoothState();
        return bluetoothStateCode == BluetoothAdapter.STATE_ON
                || bluetoothStateCode == BluetoothAdapter.STATE_TURNING_ON ? true
                : false;
    }


    /**
     * WRITE_APN_SETTING
     * @return int
     */
    public int getAirplaneModeState() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return Settings.System.getInt(context.getContentResolver(),
                    Settings.System.AIRPLANE_MODE_ON, 0);
        } else {
            return Settings.Global.getInt(context.getContentResolver(),
                    Settings.Global.AIRPLANE_MODE_ON, 0);
        }
    }

    /**
     * @return true or false
     */
    public boolean isAirplaneModeOpen() {
        return getAirplaneModeState() == 1 ? true : false;
    }

    /**
     * @return long max memory
     */
    public long getMaxMemory() {

        return Runtime.getRuntime().maxMemory() / 1024;
    }




}
