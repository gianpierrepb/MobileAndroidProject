package com.example.juma.moments.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JuMa on 16/05/2017.
 */

public class Moment {
    private String title;
    private String location;
    private String description;
    private Date created_At;
    private Date update_At;
    private Date duration;

    public Moment(String title, String location, String description, Date created_At, Date update_At, Date duration) {
        this.title = title;
        this.location = location;
        this.description = description;
        this.created_At = created_At;
        this.update_At = update_At;
        this.duration = duration;
    }

    public Moment() {
    }


    public String getTitle() {
        return title;
    }

    public Moment setTitle(String title) {
        this.title = title;
        return this;
    }




    public String getLocation() {
        return location;
    }

    public Moment setLocation(String location) {
        this.location = location;
        return this;
    }




    public String getDescription() {
        return description;
    }

    public Moment setDescription(String description) {
        this.description = description;
        return this;
    }




    public Date getCreated_At() {
        return created_At;
    }

    public String getCreated_AtAsString(){
        return (new SimpleDateFormat("EEEE, MMMM d yyyy")).format(created_At);
    }

    public Moment setCreated_At(Date created_At) {
        this.created_At = created_At;
        return this;
    }




    public Date getUpdate_At() {
        return update_At;
    }

    public String getUpdate_AtAsString(){
        return (new SimpleDateFormat("EEEE, MMMM d yyyy")).format(update_At);
    }

    public Moment setUpdate_At(Date update_At) {
        this.update_At = update_At;
        return this;
    }




    public Date getDuration() {
        return duration;
    }

    public String getDurationAsString(){
        return (new SimpleDateFormat("HH:MM:SS")).format(duration);
    }

    public Moment setDuration(Date duration) {
        this.duration = duration;
        return this;
    }



    public String getContextAsString(){
        return "On" + getCreated_AtAsString() + (location.isEmpty() ? "" : " at " + location);
    }
    public static Moment build(JSONObject jsonMoment) {
        if(jsonMoment == null) return null;
        Moment moment = new Moment();
        try {
            Map<String, String> urlsToLogos = new HashMap<>();
            List<String> sortBysAvailable = new ArrayList<>();
            for(int i = 0; i < jsonMoment.getJSONArray("sortBysAvailable").length(); i++)
                sortBysAvailable.add(jsonMoment.getJSONArray("sortBysAvailable").getString(i));
            moment.setDescription(jsonMoment.getString("description"))
                    .setLocation(jsonMoment.getString("location"))
                    .setTitle(jsonMoment.getString("title"));
                   // .setDuration(Date.parse("duration"));

        } catch(Exception e) {
            e.printStackTrace();

        }
        return moment;
    }

    public static List<Moment> build(JSONArray jsonMoments) {
        if(jsonMoments == null) return null;

        int length = jsonMoments.length();
        List<Moment> sources = new ArrayList<>();
        for (int i = 0; i < length; i++)
            try {
                sources.add(Moment.build(jsonMoments.getJSONObject(i)));
            } catch(Exception e) {
                e.printStackTrace();
            }
        return sources;
    }
}
