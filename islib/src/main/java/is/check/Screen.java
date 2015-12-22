package is.check;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
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
}
