package com.life.shelter.homeless.devimpact;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        textView = (TextView) findViewById(R.id.text_progress);
        progressBar.setMax(100);
        progressBar.setScaleY(3f);
        progressAnimation();





        Thread timer =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    finish();
                }
            }
        }) ;
        timer.start();
    }

    public void progressAnimation(){
        ProgressBarAnimation animation = new ProgressBarAnimation(this,progressBar,textView,0f,100f);
        animation.setDuration(5000);
        progressBar.setAnimation(animation);
        
    }


}
