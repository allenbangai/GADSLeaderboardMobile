package com.example.gadsleaderboardmobile.Adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gadsleaderboardmobile.ui.LearningLeaders;
import com.example.gadsleaderboardmobile.ui.SkillIQLeaders;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private int numberOfTabs;

    /**
     * Constructor for {@link FragmentPagerAdapter}.
     * <p>
     * If {@link #BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT} is passed in, then only the current
     * Fragment is in the {@link Lifecycle.State#RESUMED} state. All other fragments are capped at
     * {@link Lifecycle.State#STARTED}. If {@link #BEHAVIOR_SET_USER_VISIBLE_HINT} is passed, all
     * fragments are in the {@link Lifecycle.State#RESUMED} state and there will be callbacks to
     * {@link Fragment#setUserVisibleHint(boolean)}.
     *
     * @param fm       fragment manager that will interact with this adapter
     * @param behavior determines if only current fragments are in a resumed state
     */
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numberOfTabs = behavior;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        LearningLeaders leaders = new LearningLeaders();

        switch (position){
            case 2:
                return  new SkillIQLeaders();
            default:
                return new LearningLeaders();
        }
        //Bundle bundle = new Bundle();
        //bundle.putString("message", "Fragment :" +position);
        //leaders.setArguments(bundle);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
