package com.example.android.quizpuns;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

public class Frame2 extends Other {

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

    //onclick



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        setRequestedOrientation(SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame2);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setOffscreenPageLimit(5); //how much page save
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if(position==4){

                    EditText etext1 = (EditText)findViewById(R.id.editFirstQ);
                    EditText etext2 = (EditText)findViewById(R.id.editSecondQ);

                    if((etext1.getText().toString()).equals("glasses")){
                        firstGood=1;
                        firstBad=0;
                    } else {
                        firstGood=0;
                        firstBad=1;
                    }

                    if((etext2.getText().toString()).equals("swing")){
                        secondGood=1;
                        secondBad=0;
                    } else {
                        secondGood=0;
                        secondBad=1;
                    }

                    Count();

                    TextView text1 = (TextView)findViewById(R.id.hints);
                    TextView text2 = (TextView)findViewById(R.id.scores);
                    TextView text3 = (TextView)findViewById(R.id.goods);
                    TextView text4 = (TextView)findViewById(R.id.bads);

                    text1.setText(textHint.toString());
                    text2.setText(textScore.toString());
                    text3.setText(textGood.toString());
                    text4.setText(textBad.toString());


                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });





    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_frame2, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {



            if(getArguments().getInt(ARG_SECTION_NUMBER)==1) {


                View rootView = inflater.inflate(R.layout.activity_first_question, container, false);
                return rootView;
            }

            if(getArguments().getInt(ARG_SECTION_NUMBER)==2) {


                View rootView = inflater.inflate(R.layout.activity_second_question, container, false);
                return rootView;
            }

            if(getArguments().getInt(ARG_SECTION_NUMBER)==3) {


                View rootView = inflater.inflate(R.layout.activity_third_question, container, false);
                return rootView;
            }

            if(getArguments().getInt(ARG_SECTION_NUMBER)==4) {


                View rootView = inflater.inflate(R.layout.activity_fourth_question, container, false);
                return rootView;
            }

            if(getArguments().getInt(ARG_SECTION_NUMBER)==5) {


                View rootView = inflater.inflate(R.layout.activity_summary, container, false);
                return rootView;
            }

            else {
                View rootView = inflater.inflate(R.layout.fragment_frame2, container, false);
                TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
                return rootView;
            }
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Strona 1";
                case 1:
                    return "Strona 2";
                case 2:
                    return "Strona 3";
                case 3:
                    return "Strona 4";
                case 4:

                    return "Strona 5";
            }
            return null;
        }
    }



}
