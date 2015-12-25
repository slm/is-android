package is.base;

import android.content.Context;

import java.io.File;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Root extends BaseCheck {


    public Root(Context context) {
        super(context);
    }

    /**
     * thanks to https://github.com/Stericson/RootTools
     * @return boolean
     */
    public boolean isRooted() {
        return findBinary("su");
    }

    /**
     * thanks to https://github.com/Stericson/RootTools
     * @param binaryName
     * @return
     */
    private static boolean findBinary(String binaryName) {
        boolean found = false;
        if (!found) {
            String[] places = { "/sbin/", "/system/bin/", "/system/xbin/",
                    "/data/local/xbin/", "/data/local/bin/",
                    "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/" };
            for (String where : places) {
                if (new File(where + binaryName).exists()) {
                    found = true;

                    break;
                }
            }
        }
        return found;
    }


}
