package com.example.fahmiramadhani.rundays;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RaceAdapter extends RecyclerView.Adapter<RaceAdapter.MyViewHolder> {

    private List<Race> raceList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView raceTitle, raceLocation, raceCategory, raceDate;

        public MyViewHolder(View view) {
            super(view);
            raceTitle = (TextView) view.findViewById(R.id.raceTitle);
            raceLocation = (TextView) view.findViewById(R.id.raceLocation);
            raceCategory = (TextView) view.findViewById(R.id.raceCategory);
            raceDate = (TextView) view.findViewById(R.id.raceDate);
        }
    }


    public RaceAdapter(List<Race> raceList) {
        this.raceList = raceList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Race race = raceList.get(position);
        holder.raceTitle.setText(race.getRaceTitle());
        holder.raceLocation.setText(race.getRaceLocation());
        holder.raceCategory.setText(race.getRaceCategory());
        holder.raceDate.setText(race.getRaceDate());
    }

    @Override
    public int getItemCount() {
        return raceList.size();
    }
}
