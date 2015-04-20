package com.andromedalabs.ottoexample.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andromedalabs.ottoexample.R;
import com.andromedalabs.ottoexample.adapter.BusAdapter;
import com.andromedalabs.ottoexample.events.FragmentChangeEvent;

import java.util.Random;


/**
 * Created by adnan on 4/20/15.
 */
public class MyFragment extends Fragment {

    private static String TITLE = "TITLE";
    private String mTitle;

    public static MyFragment newInstance(String title){
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE,title);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle = getArguments().getString(TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dummy_fragment,container,false);

        TextView mTextView = (TextView) rootView.findViewById(R.id.title);
        mTextView.setText(mTitle);


        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String randomNumber = String.valueOf((new Random()).nextInt(100));
                BusAdapter.post(new FragmentChangeEvent(randomNumber));
            }
        });
        return rootView;
    }
}
