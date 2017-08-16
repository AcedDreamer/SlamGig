package com.slamgig.android.utilities;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by adaobifrank on 8/7/17.
 */

public class SharedPreferenceManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "slam-gig-welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_PROFILE_SETUP = "IsProfileSetup";

    public SharedPreferenceManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public void setIsProfileSetup(boolean isProfileSetup) {
        editor.putBoolean(IS_PROFILE_SETUP, isProfileSetup);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
    public boolean isProfileSetUp() { return pref.getBoolean(IS_PROFILE_SETUP, true); }
}
