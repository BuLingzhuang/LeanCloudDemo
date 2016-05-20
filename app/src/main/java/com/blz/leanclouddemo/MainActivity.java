package com.blz.leanclouddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.avos.avoscloud.AVObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSubmit(View view) {
        AVObject blzObject = new AVObject("MusicEntity");
        blzObject.put("author",);
        blzObject.saveInBackground();
    }
}
