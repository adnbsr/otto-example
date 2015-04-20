package com.andromedalabs.ottoexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.andromedalabs.ottoexample.adapter.BusAdapter;
import com.andromedalabs.ottoexample.events.FragmentChangeEvent;
import com.andromedalabs.ottoexample.fragments.MyFragment;
import com.squareup.otto.Subscribe;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.container, MyFragment.newInstance("Click")).commit();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        BusAdapter.unregister(this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusAdapter.register(this);
    }

    @Subscribe
    public void onFragmentChange(FragmentChangeEvent event){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, MyFragment.newInstance(event.getTitle())).commit();
    }
}
