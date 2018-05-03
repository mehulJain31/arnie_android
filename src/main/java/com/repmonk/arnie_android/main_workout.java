package com.repmonk.arnie_android;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class main_workout extends AppCompatActivity
{
    String uniqueid;
    ArrayList<String> mainstr = new ArrayList<String>();

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    public static String name;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   Intent intent= getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView t1=  (TextView)findViewById(R.id.id);
        //TextView t2=  (TextView)findViewById(R.id.uniqueid);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        String uniqueid= intent.getStringExtra("username");
        t1.setText(uniqueid);
        name=uniqueid;



        uniqueid= intent.getStringExtra("number1");
        //t2.setText(uniqueid);



        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);


        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter
    {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            switch (position)
            {
                case 0:
                    chest chest=new chest();
                    //chest chest= new chest();
                    return chest;

                case 1:
                     shoulder shoulder= new shoulder();
                    return shoulder;

                case 2:
                    arms arms = new arms();
                    return arms;

                case 3:
                     legs legs = new legs();
                    return legs;

                case 4:
                    back back= new back();
                    return back;

                case 5:
                    abs abs= new abs();
                    return abs;

                default:
                    return null;
            }

        }

        @Override
        public int getCount()
        {
            // Show 6 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            switch (position)
            {
                case 0:
                    return "Chest";

                case 1:
                    return "Shoulder";

                case 2:
                    return "Arms";

                case 3:
                    return "Legs";

                case 4:
                    return "Back";

                case 5:
                    return "Abs";

            }
            return  null;
        }
    }
}
