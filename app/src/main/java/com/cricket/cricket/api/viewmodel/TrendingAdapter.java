package com.cricket.cricket.api.viewmodel;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cricket.cricket.api.R;
import com.cricket.cricket.api.controller.DashboardController;
import com.cricket.cricket.api.controller.H2HController;
import com.cricket.cricket.api.controller.LeaguesController;
import com.cricket.cricket.api.controller.LiveScoreController;
import com.cricket.cricket.api.controller.StandingImageController;
import com.cricket.cricket.api.model.TrendingModel;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.getkeepsafe.taptargetview.TapTargetView;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.content.Context.MODE_PRIVATE;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {
    private List<TrendingModel.result> countryUtils;
    ArrayList<String> randomTrendList = new ArrayList<>();
    Context context;
    public TrendingAdapter(DashboardController context, List countryUtils, ArrayList trendinglist) {
        this.context = context;
        this.countryUtils = countryUtils;
        this.randomTrendList = trendinglist;
}

    public TrendingAdapter() {
        //clone
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LAGI DITO SI ACTIVTY MAIN O YUNG LAMAN NG UI MO WALA DPT DUN RECYCLVER VIEW
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final TrendingModel.result newsList = countryUtils.get(position);

        Random random = new Random();
        final int randomNumber = random.nextInt(randomTrendList.size());



        holder.latestNews.setText(randomTrendList.get(randomNumber));

        holder.openLeagues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), LeaguesController.class); //Open new Activity
                v.getContext().startActivity(myIntent);


            }
        });
        holder.openLiveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), LiveScoreController.class); //Open new Activity
                v.getContext().startActivity(myIntent);

            }
        });
        holder.openStanding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), StandingImageController.class); //Open new Activity
                v.getContext().startActivity(myIntent);

            }
        });
        holder.openH2H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), H2HController.class); //Open new Activity
                v.getContext().startActivity(myIntent);

            }
        });

        holder.trendingClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }

    //dito na gusto mo declare mga animation at pagttwag intent
    @Override
    public int getItemCount() {
        return countryUtils.size();
    }

    //global


    public class ViewHolder extends RecyclerView.ViewHolder {
        //VARIABLE PARA MABASA
        public TextView latestNews;
        public ImageView openLeagues;
        public ImageView openLiveScore;
        public CountDownTimer countTimer;
        public ImageView openStanding;
        public ImageView openH2H;
        public TextView trendingClick;


        public ViewHolder(View itemView) {
            super(itemView);



            latestNews = itemView.findViewById(R.id.latest_news);
            openLeagues = itemView.findViewById(R.id.open_leagues);
            openLiveScore = itemView.findViewById(R.id.open_liveScore);
            openStanding = itemView.findViewById(R.id.open_standing);
            openH2H = itemView.findViewById(R.id.open_h2h);
            trendingClick = itemView.findViewById(R.id.textTrending);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }

    }
}