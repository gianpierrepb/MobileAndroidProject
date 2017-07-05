package com.example.juma.moments.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.juma.moments.R;

public class WelcomeMomentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_moments);
        Button btn_moments = (Button) findViewById(R.id.btn_moments);
        btn_moments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),MomentsActivity.class));
            }
        });
    }
}
