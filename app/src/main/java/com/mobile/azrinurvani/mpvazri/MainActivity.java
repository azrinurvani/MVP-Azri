package com.mobile.azrinurvani.mpvazri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobile.azrinurvani.mpvazri.Presenter.ILoginPresenter;
import com.mobile.azrinurvani.mpvazri.Presenter.LoginPresenter;
import com.mobile.azrinurvani.mpvazri.View.ILoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView{
    EditText editEmail,editPassword;
    Button btnLogin;

    ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = (EditText)findViewById(R.id.editEmail);
        editPassword = (EditText)findViewById(R.id.editPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        loginPresenter = new LoginPresenter(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(editEmail.getText().toString(),editPassword.getText().toString());
            }
        });
    }


    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(this,message, Toast.LENGTH_SHORT).show();
    }
}
