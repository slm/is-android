package is.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Patterns;

import java.io.File;

import is.BaseCheck;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Basics extends BaseCheck {

    public Basics(Context context) {
        super(context);
    }

    /**
     *
     * @param target
     * @return
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    /**
     *
     * @param target
     * @return
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public boolean isValidPhone(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return Patterns.PHONE.matcher(target).matches();
        }
    }

    /**
     *
     * @param target
     * @return
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public boolean isValidDomainName(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return Patterns.DOMAIN_NAME.matcher(target).matches();
        }
    }

    /**
     *
     * @param target
     * @return
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public boolean isValidIPadress(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return Patterns.IP_ADDRESS.matcher(target).matches();
        }
    }

    /**
     *
     * @param target
     * @return
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public boolean isValidURL(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return Patterns.WEB_URL.matcher(target).matches();

        }
    }



    /**
     * thanks to https://code.google.com/p/gnuc-credit-card-checker/source/browse/trunk/CCCheckerPro/src/com/gnuc/java/ccc/Luhn.java
     * @param ccNumber
     * @return
     */
    public boolean isValidCreditCard(String ccNumber)
    {
        int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }


    /**
     * Check file extension
     * @param ext
     * @param file
     * @return
     */
    public boolean isFile(String ext,File file){
            String fullPath = file.getAbsolutePath();
            int dot = fullPath.lastIndexOf(".");
            String ext1 = fullPath.substring(dot + 1);
            if(ext1.equals(ext))
            {
                return true;
            }
        return false;
    }



}
