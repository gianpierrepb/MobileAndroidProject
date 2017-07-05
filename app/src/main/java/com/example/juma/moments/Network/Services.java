package com.example.juma.moments.Network;

import com.example.juma.moments.models.Moment;
import com.example.juma.moments.models.User;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;


import java.util.List;

/**
 * Created by JonathaN on 05/07/2017.
 */



public class Services {


    static  String urlService ="";
    public String TAG="";
    public Services() {

    }
    public List<Moment> moments;


    private void SampleConection() {

        AndroidNetworking.get(urlService)
                .setTag(TAG)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if ("error".equalsIgnoreCase(response.getString("status"))) {
                                Log.d(TAG, response.getString("message"));
                                return;
                            }
                            Log.d(TAG, "About to get Sources");
                            moments = Moment.build(response.getJSONArray("sources"));
                            Log.d(TAG, "Found " + String.valueOf(moments.size()) + " sources");
                            //sourcesAdapter.setSources(moments).notifyDataSetChanged();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(TAG, anError.getLocalizedMessage());
                    }
                });
    }
    /// functions users

    public User loginUser(User _user){

        return null;

    }

    public User updateUser(User _user){
        return null;
    }

    public User saveUser(User _user){
        return null;
    }
    /// functions moments

    public List<Moment> getMomentsbyUser(){


        return null;
    }

    public Moment updateMoment(Moment monent){

        return null;
    }


    public Boolean deleteMoment(){

        return false;
    }

}
