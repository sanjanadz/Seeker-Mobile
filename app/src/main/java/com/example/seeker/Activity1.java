package com.example.seeker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        SharedPreferences preferences = getSharedPreferences("fjjufjdf", MODE_PRIVATE);
        String FirstTime = preferences.getString("FirstTimeInstallr", "");

        //if app was open first time
        if (FirstTime.equals("Yes")){
            Intent intent = new Intent(Activity1.this, Activity2.class);
            startActivity(intent);
            finish();

        }
        else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("FirstTimeInstallr", "Yes");


//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Intent i = new Intent (MainActivity.this, SecondActivity.class);
//                    startActivity (i);
//                    finish();
//
//                }
//            },3000);
            editor.apply();

        }

    }

    public void next(View view) {
        Intent intent = new Intent(Activity1.this, Activity2.class);
        startActivity(intent);


    }
}
