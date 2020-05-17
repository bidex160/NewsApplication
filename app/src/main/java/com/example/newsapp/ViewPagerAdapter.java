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
                LivesScoresFragment livesScoresFragment = new LivesScoresFragment();
                return livesScoresFragment;
            case 1:
                EducationFragment educationFragment = new EducationFragment();
                return educationFragment;

            case 2:
              TechnologyFragment technologyFragment = new TechnologyFragment();
              return technologyFragment;
            case 3:
                EntertainmentFragemnt entertainmentFragemnt =  new EntertainmentFragemnt();
                return entertainmentFragemnt;
            case 4:
                HealthFragment healthFragment = new HealthFragment();
                return healthFragment;
            case 5:
                SportsFragment sportsFragment = new SportsFragment();
                return sportsFragment;
            case 6:
                SportsFragment sports = new SportsFragment();
                return sports;
            default:
                break;


        }
        return null;
    }

    @Override
    public int getCount() {

        return 7;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Live Update";

            case 1:
                return "Education";
            case 2:
                return "Technology";
            case 3:
                return "Entertainment";
            case 4:
                return "Health";
            case 5:
                return "Sports";
            case 6:
                return "new";
                default:
                   return null;
        }

    }
}
