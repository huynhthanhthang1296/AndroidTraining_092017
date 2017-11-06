package com.example.sony.training;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButton;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSharedPreferences = getApplicationContext().getSharedPreferences(Constants.SHARE_PREF_NAME, Context.MODE_PRIVATE);

        mButton = (Button) findViewById(R.id.btn);

        mButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putBoolean(Constants.SHARE_KEY_PREF_LOGIN, true);
                editor.commit();

                finish();
                Intent intent = new Intent(LoginActivity.this, LoginSuccesActivity.class);
                startActivity(intent);
                break;
        }
    }
}
