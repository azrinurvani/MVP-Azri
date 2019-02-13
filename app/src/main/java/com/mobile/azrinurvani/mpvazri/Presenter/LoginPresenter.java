package com.mobile.azrinurvani.mpvazri.Presenter;

import com.mobile.azrinurvani.mpvazri.Model.User;
import com.mobile.azrinurvani.mpvazri.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.loginView = iLoginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email,password);
        int loginCode = user.isValidData();

        if(loginCode == 0){
            loginView.onLoginError("You must enter your email");
        }else if(loginCode==1){
            loginView.onLoginError("You must enter your password");
        }else if(loginCode==2){
            loginView.onLoginError("Your password must be greater than 6 ");
        }else
            loginView.onLoginSuccess("Login Success");
    }
}
