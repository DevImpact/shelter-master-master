package com.life.shelter.homeless.devimpact;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

public class About extends AppCompatActivity {


    ImageView face, twitter, insagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        face = (ImageView) findViewById(R.id.fb);
        twitter =(ImageView) findViewById(R.id.twitt);
        insagram =(ImageView) findViewById(R.id.insta);

        face.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "facebook", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), WebActivity.class);
                String url = "hhttps://www.facebook.com/shelter.new.life/";
                intent.putExtra("url", url);
                startActivity(intent);

            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.ttwiterr, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), WebActivity.class);
                String url = "https://twitter.com/Shelter_life_";
                intent.putExtra("url", url);
                startActivity(intent);


            }
        });
        insagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.our_web_site, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), WebActivity.class);
                String url = "http://www.shelter.gq";
                intent.putExtra("url", url);
                startActivity(intent);


            }
        });
    }
}


