package is;

import android.content.Context;

import is.check.Applications;
import is.check.Basics;
import is.check.Keyboard;
import is.check.Locations;
import is.check.Screen;
import is.check.Space;
import is.hardware.Phones;
import is.network.Network;
import is.runtime.Services;
import is.runtime.Views;
import is.security.Root;
import is.sound.Sounds;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Is {

    Is getIs(Context context){
        return new Is(context);
    }

    Applications applications;
    Basics basics;
    Keyboard keyboard;
    Locations locations;
    Screen screen;
    Space space;
    Phones phones;
    Network network;
    Services services;
    Views views;
    Root root;
    Sounds sounds;

    public Is(Context context){
        applications = new Applications(context);
        basics = new Basics(context);
        locations = new Locations(context);
        screen = new Screen(context);
        space = new Space(context);
        phones = new Phones(context);
        network = new Network(context);
        services = new Services(context);
        views = new Views(context);
        root = new Root(context);
        sounds = new Sounds(context);
    }

    public Applications getApplications() {
        return applications;
    }

    public Basics getBasics() {
        return basics;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Locations getLocations() {
        return locations;
    }

    public Screen getScreen() {
        return screen;
    }

    public Space getSpace() {
        return space;
    }

    public Phones getPhones() {
        return phones;
    }

    public Network getNetwork() {
        return network;
    }

    public Services getServices() {
        return services;
    }

    public Views getViews() {
        return views;
    }

    public Root getRoot() {
        return root;
    }

    public Sounds getSounds() {
        return sounds;
    }

}
