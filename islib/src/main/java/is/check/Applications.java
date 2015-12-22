package is.check;

import android.content.Context;
import android.content.pm.PackageManager;

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
}
