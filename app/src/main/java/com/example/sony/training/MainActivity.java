package com.example.sony.training;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runnable = new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(Constants.SHARE_PREF_NAME, MODE_PRIVATE);
                boolean isLogin = sharedPreferences.getBoolean(Constants.SHARE_KEY_PREF_LOGIN,false);
                if (isLogin){
                    Intent intent = new Intent(MainActivity.this, LoginSuccesActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        handler = new Handler();

    }

    @Override
    protected void onStart() {
        super.onStart();
        handler.postDelayed(runnable, 2000);
    }
}