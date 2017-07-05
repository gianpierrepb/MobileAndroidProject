package com.example.juma.moments.models;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.juma.moments.MomentsApp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JuMa on 16/05/2017.
 */

public class DataService {

    List<Moment> moments;
    public DataService(){
        moments = new ArrayList<>();
        moments.add(new Moment("Dog found", "Parque Kenedy", "I found an abandoned dog and was very cold", new Date(), new Date(), new Date()));
        moments.add(new Moment("Cat found", "Plaza San Miguel", "I found an abandoned cat and was very cold", new Date(), new Date(), new Date()));
        moments.add(new Moment("Celphone found", "Parque de las Aguas", "I found a wallet and was broken", new Date(), new Date(), new Date()));
        moments.add(new Moment("Wallet found", "Parque Kenedy", "I found a wallet and was full", new Date(), new Date(), new Date()));
    }

    public List<Moment> getMoments() {
        return moments;
    }

    private void updatePreferences(){
        SharedPreferences.Editor e = MomentsApp.getInstance()
                .getSharedPreferences("preferences", Context.MODE_APPEND).edit();
        e.commit();
    }

    public boolean addMoment(Moment moment){
        moments.add(moment);
        updatePreferences();
        return true;
    }
}
