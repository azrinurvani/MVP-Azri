package com.mobile.azrinurvani.mpvazri.Model;

import android.text.TextUtils;
import android.util.Patterns;


public class User implements IUser {
    private String email,password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPasssword() {
        return password;
    }

    @Override
    public int isValidData() {
//       0. Cek email is empty
//        1. Cek email is matches pattern
//          2. Cek password length >6

        if (TextUtils.isEmpty(getEmail()))
            return 0;
        else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if (getPasssword().length()<=6)
            return 2;
        else
            return -1;
    }
}
