package com.example.juma.moments.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juma.moments.MomentsApp;
import com.example.juma.moments.R;
import com.example.juma.moments.activities.AddMomentActivity;
import com.example.juma.moments.adapters.MomentsAdapater;
import com.example.juma.moments.models.Moment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NearFragment extends Fragment {

    RecyclerView momentsRecyclerView;
    MomentsAdapater momentsAdapater;
    List<Moment> moments;
    RecyclerView.LayoutManager momentsLayoutManager;
    public NearFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_near, container, false);
        getData();

        momentsRecyclerView = (RecyclerView) view.findViewById(R.id.momentsRecyclerView);


        momentsAdapater = new MomentsAdapater();
        momentsAdapater.setMoments(moments);
        momentsRecyclerView.setAdapter(momentsAdapater);

        momentsLayoutManager = new LinearLayoutManager(view.getContext());
        momentsRecyclerView.setLayoutManager(momentsLayoutManager);



        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), AddMomentActivity.class));

            }
        });
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
    //   updateData();
    }

   // private void updateData(){
     //   SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
    //}

    private void getData(){
        moments = MomentsApp.getInstance().getMoments();
    }

}
