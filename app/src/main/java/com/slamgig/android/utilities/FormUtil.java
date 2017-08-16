package com.slamgig.android.utilities;

/**
 * Created by adaobifrank on 8/4/17.
 */

public class FormUtil {

    public static boolean isEmailValid(String email) {
        return email.contains("@");
    }

    public static boolean isPasswordValid(String password) {
        return password.length() > 4;
    }
}
