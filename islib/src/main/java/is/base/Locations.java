package is.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

import is.BaseCheck;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Locations extends BaseCheck{


    public Locations(Context context) {
        super(context);
    }

    /**
     * thanks to http://stackoverflow.com/a/22980843/4630627

     * @return
     */
    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    public boolean isLocationEnabled() {
        int locationMode = 0;
        String locationProviders;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);

            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }

            return locationMode != Settings.Secure.LOCATION_MODE_OFF;

        }else{
            locationProviders = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            return !TextUtils.isEmpty(locationProviders);
        }


    }
}
