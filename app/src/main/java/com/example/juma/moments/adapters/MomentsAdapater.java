package com.example.juma.moments.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.juma.moments.R;
import com.example.juma.moments.activities.DetailMomentActivity;
import com.example.juma.moments.models.Moment;

import java.util.List;

/**
 * Created by JuMa on 16/05/2017.
 */

public class MomentsAdapater extends RecyclerView.Adapter<MomentsAdapater.ViewHolder> {

    private List<Moment> moments;
    @Override
    public MomentsAdapater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
            .from(parent.getContext())
        .inflate(R.layout.card_moments, parent, false));
    }

    @Override
    public void onBindViewHolder(MomentsAdapater.ViewHolder holder, final int position) {
        holder.titleMomentTextView.setText(moments.get(position).getTitle());
        holder.locationMomentTextView.setText(moments.get(position).getLocation());
        holder.descriptionMomentTextView.setText(moments.get(position).getDescription());
        holder.createdMomentTextView.setText(moments.get(position).getCreated_AtAsString());
        holder.updateMomentTextView.setText(moments.get(position).getUpdate_AtAsString());
        holder.durationMomentTextView.setText(moments.get(position).getDurationAsString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itemIntent = new Intent(v.getContext(), DetailMomentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Title", moments.get(position).getTitle());
                bundle.putString("Location", moments.get(position).getLocation());
                bundle.putString("Description", moments.get(position).getDescription());
                bundle.putString("Create", moments.get(position).getContextAsString());
                bundle.putString("Update", moments.get(position).getUpdate_AtAsString());
                bundle.putString("Duration", moments.get(position).getDurationAsString());
                itemIntent.putExtras(bundle);
                v.getContext().startActivity(itemIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moments.size();
    }

    public List<Moment> getMoments() {
        return moments;
    }

    public void setMoments(List<Moment> moments) {
        this.moments = moments;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleMomentTextView;
        TextView locationMomentTextView;
        TextView descriptionMomentTextView;
        TextView createdMomentTextView;
        TextView updateMomentTextView;
        TextView durationMomentTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            titleMomentTextView = (TextView) itemView.findViewById(R.id.titleMomentTextView);
            locationMomentTextView = (TextView) itemView.findViewById(R.id.locationMomentTextView);
            descriptionMomentTextView = (TextView) itemView.findViewById(R.id.descriptionMomentTextView);
            createdMomentTextView = (TextView) itemView.findViewById(R.id.createdMomentTextView);
            updateMomentTextView = (TextView) itemView.findViewById(R.id.updateMomentTextView);
            durationMomentTextView = (TextView) itemView.findViewById(R.id.durationMomentTextView);
        }
    }
}
