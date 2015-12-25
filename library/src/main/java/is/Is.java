package is;

import android.content.Context;

import is.base.Applications;
import is.base.Basics;
import is.base.Dates;
import is.base.Keyboard;
import is.base.Locations;
import is.base.Screen;
import is.base.Files;
import is.base.Phones;
import is.base.Network;
import is.base.Services;
import is.base.Views;
import is.base.Root;
import is.base.Sounds;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Is {

    private static Context ctx;

    public static Applications application;
    public static Basics basic;
    public static Keyboard keyboard;
    public static Locations location;
    public static Screen screen;
    public static Files file;
    public static Phones phone;
    public static Network network;
    public static Services service;
    public static Views view;
    public static Root root;
    public static Sounds sound;
    public static Dates date;


    public static void init(Context context){
        ctx = context;
        application = new Applications(context);
        basic = new Basics(context);
        location = new Locations(context);
        screen = new Screen(context);
        file = new Files(context);
        phone = new Phones(context);
        network = new Network(context);
        service = new Services(context);
        view  = new Views(context);
        root = new Root(context);
        sound = new Sounds(context);
        date = new Dates();
    }

}
