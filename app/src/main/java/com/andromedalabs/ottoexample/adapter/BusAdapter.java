package com.andromedalabs.ottoexample.adapter;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by adnan on 4/20/15.
 */
public class BusAdapter {

    private static final Bus sBus = new Bus(ThreadEnforcer.ANY);

    public static void register(Object object) {
        sBus.register(object);
    }

    public static void unregister(Object object) {
        sBus.unregister(object);
    }

    public static void post(Object event) {
        sBus.post(event);
    }
}
