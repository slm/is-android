package is;

import android.app.Application;

import is.check.Applications;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class IsApplication extends Application {

    Is ıs;

    @Override
    public void onCreate() {
        super.onCreate();
        ıs = new Is(this);
    }

    /**
     * you can call Is object from Activity  ((IsApplication) getApplicaton()).getIs();
     * @return Is
     */
    public Is getIs() {
        return ıs;
    }

}
