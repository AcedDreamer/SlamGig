package com.slamgig.android.ui.profile;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.slamgig.android.ui.profile.fragments.SetAvatarUsernameFragment;
import com.slamgig.android.ui.profile.fragments.SetEntertainerTypeFragment;
import com.slamgig.android.ui.profile.fragments.SetEntertainmentTypeFragment;
import com.slamgig.android.ui.profile.fragments.SetUserTypeFragment;

/**
 * Created by adaobifrank on 8/14/17.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    int FRAGMENTS_COUNT;

    public MyFragmentPagerAdapter(FragmentManager fm,int fragmentsCount) {

        super(fm);
        FRAGMENTS_COUNT = fragmentsCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch(position) {
            case 0: return new SetUserTypeFragment();
            case 1: return new SetEntertainerTypeFragment();
            case 2: return new SetEntertainmentTypeFragment();
            case 3: return new SetAvatarUsernameFragment();
            default: return new SetUserTypeFragment();
        }
    }

    @Override
    public int getCount() {
        return FRAGMENTS_COUNT;
    }
}
