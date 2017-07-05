package com.example.juma.moments.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.juma.moments.MomentsApp;
import com.example.juma.moments.R;
import com.example.juma.moments.adapters.MomentsAdapater;
import com.example.juma.moments.models.Moment;

import java.util.List;

public class MomentsActivity extends AppCompatActivity {

    RecyclerView momentsRecyclerView;
    List<Moment> moments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getData();

        momentsRecyclerView = (RecyclerView) findViewById(R.id.momentsRecyclerView);
        momentsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        MomentsAdapater momentsAdapater = new MomentsAdapater();
        momentsAdapater.setMoments(moments);

        momentsRecyclerView.setAdapter(momentsAdapater);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), AddMomentActivity.class));
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void updateData(){
        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        updateData();
    }

    private void getData(){
        moments = MomentsApp.getInstance().getMoments();
    }

}
