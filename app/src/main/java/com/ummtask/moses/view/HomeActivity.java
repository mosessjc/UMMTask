package com.ummtask.moses.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ummtask.moses.R;
import com.ummtask.moses.view.fragments.VEntertainmentFragment;
import com.ummtask.moses.view.fragments.VFavouritesFragment;
import com.ummtask.moses.view.fragments.VFoodAndDiningFragment;
import com.ummtask.moses.view.fragments.VJobOpeningsFragment;
import com.ummtask.moses.view.fragments.VShoppingFragment;
import com.ummtask.moses.view.fragments.VSportsAndFitnessFragment;
import com.ummtask.moses.view.fragments.VTrendingFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    ViewPagerAdapter adapter;
    Typeface tabhostTypeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_home);
        setUpViews();
    }

    public void setUpViews() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View view = mInflater.inflate(R.layout.custom_actionbar, null);

        actionBar.setCustomView(view);

        Toolbar toolbar=(Toolbar)actionBar.getCustomView().getParent();
        toolbar.setContentInsetsAbsolute(0, 0);
        toolbar.getContentInsetEnd();
        toolbar.setPadding(0, 0, 0, 0);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ButterKnife.bind(this);

        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
        tabhostTypeface = Typeface.createFromAsset(getAssets(), "font/verdana.ttf");

        ViewGroup viewGroup = (ViewGroup) tabLayout.getChildAt(0);
        for (int j = 0; j < tabLayout.getTabCount(); j++) {
            ViewGroup group = (ViewGroup) viewGroup.getChildAt(j);
            int tabChildsCount = group.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = group.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(tabhostTypeface);
                    ((TextView) tabViewChild).setScaleY(-1);
                }
            }
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new VTrendingFragment(), "Trending");
        adapter.addFragment(new VFavouritesFragment(), "Favourites");
        adapter.addFragment(new VEntertainmentFragment(), "Entertainment");
        adapter.addFragment(new VFoodAndDiningFragment(), "Food And Dining");
        adapter.addFragment(new VShoppingFragment(), "Shopping");
        adapter.addFragment(new VSportsAndFitnessFragment(), "Sports And Fitness");
        adapter.addFragment(new VJobOpeningsFragment(), "Job Openings");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}