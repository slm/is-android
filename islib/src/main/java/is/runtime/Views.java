package is.runtime;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import is.BaseCheck;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Views extends BaseCheck {

    public Views(Context context) {
        super(context);
    }


    /**
     * @param fragment
     * @return
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public boolean isVisible(android.app.Fragment fragment){
        return  fragment.isVisible();
    }

    /**
     * @param fragment
     * @return
     */
    public boolean isVisible(Fragment fragment){
        return  fragment.isVisible();
    }

    /**
     *
     * @param view
     * @return
     */
    public boolean isVisible(View view){
        return view.getVisibility()==View.VISIBLE;
    }

    /**
     *
     * @param view
     * @return
     */
    public static boolean isEmpty(TextView view){
        return view.getText().length()>0;
    }



    /**
     * @param view
     * @return
     */
    public boolean isGone(View view){
        return view.getVisibility()==View.GONE;
    }

    /**
     * @param v1
     * @param v2
     * @return
     */
    public boolean equalsViews(View v1,View v2){
        if(v1.getId()==v2.getId()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @param fragment
     * @return boolean
     */
    public static boolean isFragmentAttached(Fragment fragment) {
        return fragment.getActivity() != null;
    }



}
