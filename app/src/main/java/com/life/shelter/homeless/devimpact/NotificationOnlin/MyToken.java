package com.life.shelter.homeless.devimpact.NotificationOnlin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.iid.FirebaseInstanceId;
import com.life.shelter.homeless.devimpact.R;

public class MyToken extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_token);
        System.out.println("MY Token :"+ FirebaseInstanceId.getInstance().getToken());
    }
}
