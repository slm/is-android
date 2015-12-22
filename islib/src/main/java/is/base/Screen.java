package is.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.provider.Settings;
import android.view.Display;

import is.BaseCheck;
import is.hardware.Phones;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Screen extends BaseCheck {


    public Screen(Context context) {
        super(context);
    }

    /**
     *
     * @return
     */
    public boolean isScreenLandscape(){
        return getScreenOrientation() == Configuration.ORIENTATION_LANDSCAPE;
    }

    /**
     * @return
     */
    public boolean isScreenPortrait(){
        return getScreenOrientation() == Configuration.ORIENTATION_PORTRAIT;
    }

    /**
     * @return
     */
    public boolean isScreenSquare(){
        return getScreenOrientation() == Configuration.ORIENTATION_SQUARE;
    }

    /**
     * @return
     */
    public int getScreenOrientation(){
        return context.getResources().getConfiguration().orientation;
    }

    /**
     * @param context Activity
     * @return int[]{width,height}
     */
    public int[] getScreenSizes(Activity context){
        Display display = context.getWindowManager().getDefaultDisplay();
        if(Phones.checkBuildNumber(13)){
            Point size = new Point();
            display.getSize(size);
            return new int[]{size.x,size.y};
        }else{
            return new int[]{display.getWidth(), display.getHeight()};
        }
    }


    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px      A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A int value to represent dp equivalent to px value
     */
    public static int getDip(int px, Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px * scale + 0.5f);
    }

    /**
     * @return SCREEN_BRIGHTNESS_MODE def value  SCREEN_BRIGHTNESS_MODE_AUTOMATIC
     */
    public int getScreenBrightnessModeState() {
        return Settings.System.getInt(context.getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS_MODE,
                Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC);
    }

    /**
     * @return isScreenBrightnessModeAuto
     */
    public boolean isScreenBrightnessModeAuto() {
        return getScreenBrightnessModeState() == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC ? true
                : false;
    }

    /**
     * @return int screen brightness
     */
    public int getScreenBrightness() {
        return Settings.System.getInt(context.getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS, 255);
    }




}
