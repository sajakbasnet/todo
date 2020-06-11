package com.example.todouser.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.todouser.adapter.PageAdapter;
import com.example.todouser.R;
import com.google.android.material.tabs.TabLayout;

public class MyFragment extends Fragment {
    View myFragment;

    ViewPager viewPager;
    TabLayout tabLayout;

    public MyFragment() {
    }
    public  static MyFragment getInstance(){return new MyFragment();}

    @Override
    public void onCreate(Bundle instance) {
        super.onCreate(instance);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_main, container, false);

        viewPager = myFragment.findViewById(R.id.viewPager);
        tabLayout = myFragment.findViewById(R.id.tabLayout);

        return myFragment;

    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
       PageAdapter adapter = new PageAdapter(getChildFragmentManager());
     //  adapter.addFragment(new ListFragment() , "All");
       adapter.addFragment(new priority1fragment(),"Priority High");
        adapter.addFragment(new priority2fragment(),"Priority Medium");
        adapter.addFragment(new priority3fragment(),"Priority Low");


       viewPager.setAdapter(adapter);
    }


}