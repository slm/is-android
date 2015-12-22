package is.check;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.inputmethod.InputMethodManager;

import is.BaseCheck;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Keyboard extends BaseCheck{


    public Keyboard(Context context) {
        super(context);
    }

    /**
     * Target Api CUPCAKE
     * @return
     */
    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    public boolean isKeyboardVisible(){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isAcceptingText()) {
            return true;
        } else {
           return false;
        }
    }

}
