package com.cricket.cricket.api.controller;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cricket.cricket.api.R;
import com.cricket.cricket.api.model.LiveScoreModel;
import com.cricket.cricket.api.model.StandingModel;
import com.cricket.cricket.api.service.CricketService;

//import com.cricket.cricket.api.viewmodel.StandingAdapter;
import com.cricket.cricket.api.viewmodel.StandingAdapter;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ThreeBounce;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StandingController extends AppCompatActivity {
    RecyclerView recycleViewStanding;
    RecyclerView.LayoutManager standingLayout;
    ProgressBar progressBar;
    CountDownTimer countTimer;
    ImageView backDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalist_standing);

        recycleViewStanding = findViewById(R.id.datalist_standin_recycler_view);
        backDashboard = findViewById(R.id.back_to_dashboard_standing); //back to dash

        progressBar = (ProgressBar)findViewById(R.id.spin_kit_standing);
        Sprite chasingDots = new ThreeBounce();
        progressBar.setIndeterminateDrawable(chasingDots);
        countTimer = new CountDownTimer(2600,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                progressBar.setVisibility(View.GONE);
//                Toast.makeText(getApplicationContext(),"Please Wait...", Toast.LENGTH_SHORT).show();


            }
        }.start();

        getStanding();

        openIntent();
    }
    public void openIntent(){
        backDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), DashboardController.class);
                v.getContext().startActivity(myIntent);
                finish();
            }
        });
    }
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please use the proper back button! ", Toast.LENGTH_SHORT).show();
    }
    RecyclerView recycleViewHome;
    RecyclerView away;
    RecyclerView.LayoutManager homeLayout;
    RecyclerView.LayoutManager awayLayout;
    List<LiveScoreModel.result> liveScoreModel;

    public void getStanding(){
        standingLayout = new LinearLayoutManager(this);
        recycleViewStanding.setLayoutManager(standingLayout);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CricketService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CricketService cricketApi = retrofit.create(CricketService.class);

        Call<StandingModel> call = cricketApi.getStanding();


        call.enqueue(new Callback<StandingModel>() {
            @Override
            public void onResponse(Call<StandingModel> call, Response<StandingModel> response) {
                StandingModel a = response.body();
                List<StandingModel.Result.Total> b = a.getResult().getTotal();
//                List<StandingModel.Result.Total> total = new ArrayList<>();

                List<StandingModel.Result.Total> totalListed;
                totalListed = new ArrayList<>();

                for (int i = 0; i < b.size(); i++) {
                    totalListed.add(new StandingModel.Result.Total(
                            b.get(i).getStandingPlace(),
                            b.get(i).getStandingTeam(),
                            b.get(i).getStandingW(),
                            b.get(i).getStandingL()
                    ));
                }

                StandingAdapter mAdapter = new StandingAdapter(StandingController.this, totalListed);
                recycleViewStanding.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<StandingModel> call, Throwable t) {

                System.out.println("debug tnga"+t.toString());
            }

        });

    }
}