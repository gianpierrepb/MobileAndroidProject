package com.example.juma.moments.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.juma.moments.MomentsApp;
import com.example.juma.moments.R;
import com.example.juma.moments.models.Moment;

import java.util.Date;

public class AddMomentActivity extends AppCompatActivity {

    TextView titleMomentTextInputEditText;
    TextView locationMomentTextInputEditText;
    TextView descriptionMomentTextInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_moment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titleMomentTextInputEditText = (TextInputEditText) findViewById(R.id.titleMomentTextInputEditText);
        locationMomentTextInputEditText = (TextInputEditText) findViewById(R.id.locationMomentTextInputEditText);
        descriptionMomentTextInputEditText = (TextInputEditText) findViewById(R.id.descriptionMomentTextInputEditText);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Moment moment = new Moment();
                moment.setTitle(titleMomentTextInputEditText.getText().toString())
                        .setLocation(locationMomentTextInputEditText.getText().toString())
                        .setDescription(descriptionMomentTextInputEditText.getText().toString())
                        .setCreated_At(new Date())
                        .setUpdate_At(new Date())
                        .setDuration(new Date());
                MomentsApp.getInstance().addMoment(moment);
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.stay,R.anim.left_out);
    }
}
