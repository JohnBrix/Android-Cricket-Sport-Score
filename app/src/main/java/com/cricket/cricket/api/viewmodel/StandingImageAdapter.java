package com.cricket.cricket.api.viewmodel;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cricket.cricket.api.R;
import com.cricket.cricket.api.controller.StandingImageController;
import com.cricket.cricket.api.model.LiveScoreModel;

import com.squareup.picasso.Picasso;

import java.util.List;

public class StandingImageAdapter extends RecyclerView.Adapter<StandingImageAdapter.ViewHolder> {
    private List<LiveScoreModel.result> liveScoreUtils;

    //for live
    public StandingImageAdapter(StandingImageController context, List liveScoreUtils) {
        this.liveScoreUtils = liveScoreUtils;
    }

    public StandingImageAdapter() {
        //clone
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LAGI DITO SI ACTIVTY MAIN O YUNG LAMAN NG UI MO WALA DPT DUN RECYCLVER VIEW
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_live_score, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final LiveScoreModel.result liveScoreList = liveScoreUtils.get(position);

        holder.teamHome.setText(liveScoreList.getEventHomeTeam());
        holder.teamAway.setText(liveScoreList.getEventAwayTeam());

        if (liveScoreList.getEventHomeTeamLogo() == null) {
            holder.teamHomeLogo.setImageResource(R.drawable.ic_broken_image);
        } else {
            Picasso.get().load(liveScoreList.getEventHomeTeamLogo()).into(holder.teamHomeLogo);
        }

        if (liveScoreList.getEventAwayTeamLogo() == null) {
            holder.teamAwayLogo.setImageResource(R.drawable.ic_broken_image);
        } else {
            Picasso.get().load(liveScoreList.getEventAwayTeamLogo()).into(holder.teamAwayLogo);
        }


        holder.teamHomeScore.setText(liveScoreList.getEventHomeFinalResult());
        holder.teamAwayScore.setText(liveScoreList.getEventAwayFinalResult());

        holder.eventStartAndEnded.setText("Start Date: " + liveScoreList.getEventDateStart() + "\t End Date: " + liveScoreList.getEventDateStop());

//        holder.backDashboard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(v.getContext(), DashboardController.class); //Open new Activity
//                v.getContext().startActivity(myIntent);
//            }
//        });
    }

    //dito na gusto mo declare mga animation at pagttwag intent
    @Override
    public int getItemCount() {
        return liveScoreUtils.size();
    }

    //global


    public class ViewHolder extends RecyclerView.ViewHolder {
        //VARIABLE PARA MABASA
        TextView teamHome;
        TextView teamAway;
        ImageView teamHomeLogo;
        ImageView teamAwayLogo;
        TextView teamHomeScore;
        TextView teamAwayScore;
        TextView eventStartAndEnded;
        ImageView backDashboard;


        public ViewHolder(View itemView) {
            super(itemView);

            teamHome = itemView.findViewById(R.id.team_home);
            teamAway = itemView.findViewById(R.id.team_away);
            teamHomeLogo = itemView.findViewById(R.id.team_home_logo);
            teamAwayLogo = itemView.findViewById(R.id.team_away_logo);
            teamHomeScore = itemView.findViewById(R.id.team_home_score);
            teamAwayScore = itemView.findViewById(R.id.team_away_score);

            eventStartAndEnded = itemView.findViewById(R.id.start_end_date_concat);

            backDashboard = itemView.findViewById(R.id.back_to_dashboard_livescore);
//            yearSeason = itemView.findViewById(R.id.year_seasons);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}