package com.cjj.jjsearchviewanim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cjj.sva.JJSearchView;

public class MainActivity extends AppCompatActivity {
    JJSearchView mJJSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJJSearchView = (JJSearchView) findViewById(R.id.jjsv);
    }

    public void start(View v){
        mJJSearchView.startAnim();
    }

    public void stop(View v){
        mJJSearchView.stopAnim();
    }
}
