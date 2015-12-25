package is.base;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v7.appcompat.BuildConfig;

import is.BaseCheck;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Applications extends BaseCheck {


    public Applications(Context context) {
        super(context);
    }

    /**
     *
     * @param packagename
     * @return
     */
    public boolean isPackageInstalled(String packagename) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /**
     *
     * @return application version number
     */

    public String getApplicationVersionNumber() {
        String versionName = null;

        try {
            versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return versionName;
    }

    /**
     *
     *
     * @return application version code
     */
    public int getApplicationVersionCode() {

        int versionCode = 0;

        try {
            versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return versionCode;
    }

    /**
     * @return boolean
     */
    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

}
