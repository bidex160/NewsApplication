package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                EducationFragment educationFragment = new EducationFragment();
                return educationFragment;

            case 1:
              TechnologyFragment technologyFragment = new TechnologyFragment();
              return technologyFragment;
            case 2:
                EntertainmentFragemnt entertainmentFragemnt =  new EntertainmentFragemnt();
                return entertainmentFragemnt;
            case 3:
                HealthFragment healthFragment = new HealthFragment();
                return healthFragment;
            case 4:
                SportsFragment sportsFragment = new SportsFragment();
                return sportsFragment;
            case 5:
                SportsFragment sports = new SportsFragment();
                return sports;
            default:
                break;


        }
        return null;
    }

    @Override
    public int getCount() {

        return 6;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Education";
            case 1:
                return "Technology";
            case 2:
                return "Entertainment";
            case 3:
                return "Health";
            case 4:
                return "Sports";
            case 5:
                return "new";
                default:
                   return null;
        }

    }
}
