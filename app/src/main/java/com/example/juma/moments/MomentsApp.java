package com.example.juma.moments;

import android.app.Application;

import com.example.juma.moments.models.DataService;
import com.example.juma.moments.models.Moment;

import java.util.List;

/**
 * Created by JuMa on 16/05/2017.
 */

public class MomentsApp extends Application {

    private DataService service = new DataService();
    private static MomentsApp instance;

    public MomentsApp(){
        super();
        instance = this;
    }

    public static MomentsApp getInstance(){
        return instance;
    }

    public List<Moment> getMoments(){
        return service.getMoments();
    }

    public boolean addMoment(Moment moment){
        return service.addMoment(moment);
    }

}


