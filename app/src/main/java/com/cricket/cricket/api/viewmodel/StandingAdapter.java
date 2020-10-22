package com.cricket.cricket.api.viewmodel;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cricket.cricket.api.R;
import com.cricket.cricket.api.controller.StandingController;
import com.cricket.cricket.api.model.StandingModel;


import java.util.List;

public class StandingAdapter extends RecyclerView.Adapter<StandingAdapter.ViewHolder> {
     List<StandingModel.Result.Total> standingUtils;


    public StandingAdapter(StandingController context, List standingUtils) {
        this.standingUtils = standingUtils;
    }

    public StandingAdapter() {
        //clone
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LAGI DITO SI ACTIVTY MAIN O YUNG LAMAN NG UI MO WALA DPT DUN RECYCLVER VIEW
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_standing, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
         StandingModel.Result.Total standingListed = standingUtils.get(position);
        System.out.println("listed: "+standingUtils);

        holder.standingPlace.setText(standingListed.getStandingPlace() );
        holder.standingTeam.setText(standingListed.getStandingTeam() );
        holder.standingWinLose.setText(standingListed.getStandingW() +"&"+ standingListed.getStandingL() );







    }

    //dito na gusto mo declare mga animation at pagttwag intent
    @Override
    public int getItemCount() {
        return standingUtils.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        //VARIABLE PARA MABASA
        TextView standingPlace;
        TextView standingTeam;
        TextView standingWinLose;



        public ViewHolder(View itemView) {
            super(itemView);

            standingPlace = itemView.findViewById(R.id.standing_place);
            standingTeam = itemView.findViewById(R.id.standing_team);
            standingWinLose = itemView.findViewById(R.id.standing_WL);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}