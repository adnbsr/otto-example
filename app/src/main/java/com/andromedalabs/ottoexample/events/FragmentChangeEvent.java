package com.andromedalabs.ottoexample.events;

/**
 * Created by adnan on 4/20/15.
 */
public class FragmentChangeEvent {

    private String title;

    public FragmentChangeEvent(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
