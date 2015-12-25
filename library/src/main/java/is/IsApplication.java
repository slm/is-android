package is;

import android.app.Application;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class IsApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Is.init(this);
    }

}
