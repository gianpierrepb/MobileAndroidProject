package com.example.juma.moments.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.juma.moments.R;

public class DetailMomentActivity extends AppCompatActivity {

    TextView titleMomentDetailTextView, locationMomentDetailTextView, descriptionMomentDetailTextView, createdMomentDetailTextView, updateMomentDetailTextView, durationMomentDetailTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_moment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();


        titleMomentDetailTextView = (TextView) findViewById(R.id.titleMomentDetailTextView);
        locationMomentDetailTextView = (TextView) findViewById(R.id.locationMomentDetailTextView);
        descriptionMomentDetailTextView = (TextView) findViewById(R.id.descriptionMomentDetailTextView);
        createdMomentDetailTextView = (TextView) findViewById(R.id.createdMomentDetailTextView);
        updateMomentDetailTextView = (TextView) findViewById(R.id.updateMomentDetailTextView);
        durationMomentDetailTextView = (TextView) findViewById(R.id.durationMomentDetailTextView);

        titleMomentDetailTextView.setText(bundle.getString("Title"));
        locationMomentDetailTextView.setText(bundle.getString("Location"));
        descriptionMomentDetailTextView.setText(bundle.getString("Description"));
        createdMomentDetailTextView.setText(bundle.getString("Create"));
        updateMomentDetailTextView.setText(bundle.getString("Update"));
        durationMomentDetailTextView.setText(bundle.getString("Duration"));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
