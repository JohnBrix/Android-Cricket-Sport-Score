package com.cricket.cricket.api.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.cricket.cricket.api.service.CricketService;
import com.cricket.cricket.api.viewmodel.StandingImageAdapter;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ThreeBounce;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StandingImageController extends AppCompatActivity {
    RecyclerView recycleViewHome;
    RecyclerView away;
    RecyclerView.LayoutManager homeLayout;
    RecyclerView.LayoutManager awayLayout;
    List<LiveScoreModel.result> liveScoreModel;
    ProgressBar progressBar;
    CountDownTimer countTimer;
    ImageView backDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalist_standing_image);

        recycleViewHome = findViewById(R.id.datalist_home);
        away = findViewById(R.id.datalist_away);
        backDashboard = findViewById(R.id.back_to_dashboard_livescore);


        progressBar = (ProgressBar) findViewById(R.id.spin_kit_livescore);
        Sprite chasingDots = new ThreeBounce();
        progressBar.setIndeterminateDrawable(chasingDots);
        countTimer = new CountDownTimer(2600, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                progressBar.setVisibility(View.GONE);
//                Toast.makeText(getApplicationContext(),"Please Wait...", Toast.LENGTH_SHORT).show();


            }
        }.start();
        getStandingVs();
        backToDashboard();

    }


    public void backToDashboard() {
        backDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), DashboardController.class); //Open new Activity
                v.getContext().startActivity(myIntent);
                finish();
            }
        });
    }

    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Please use the proper back button! ", Toast.LENGTH_SHORT).show();
    }

    public void getStandingVs() {
//        progressBar();
        //layout
        homeLayout = new GridLayoutManager(StandingImageController.this, 1, GridLayoutManager.VERTICAL, false);
        recycleViewHome.setLayoutManager(homeLayout);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CricketService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //create api interface
        CricketService cricketService = retrofit.create(CricketService.class);

        //object calling
        Call<LiveScoreModel> call = cricketService.getStandingImageVs();


        call.enqueue(new Callback<LiveScoreModel>() {
            @Override
            public void onResponse(Call<LiveScoreModel> call, Response<LiveScoreModel> response) {
                LiveScoreModel liveScoreList = response.body();

                List<LiveScoreModel.result> liveScoreListResult = liveScoreList.getResult();

                liveScoreModel = new ArrayList<>();
                for (int i = 0; i < liveScoreListResult.size(); i++) {

                    liveScoreModel.add(new LiveScoreModel.result(
                            liveScoreListResult.get(i).getEventHomeTeam(),
                            liveScoreListResult.get(i).getEventAwayTeam(),
                            liveScoreListResult.get(i).getEventHomeFinalResult(),
                            liveScoreListResult.get(i).getEventAwayFinalResult(),
                            liveScoreListResult.get(i).getEventHomeTeamLogo(),
                            liveScoreListResult.get(i).getEventAwayTeamLogo(),
                            liveScoreListResult.get(i).getEventDateStart(),
                            liveScoreListResult.get(i).getEventDateStop()

                    ));


                }
//                //live score updaterd data  //GAWA KA NG UMA UPDATE NA SCORE WITHOUT REFRESH ACTIVITY
//                BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
//                    @Override
//                    public void onReceive(Context context, Intent intent) {
//                        // Get extra data included in the Intent
//                        String message = intent.getStringExtra("message");
//                        Log.d("receiver", "Got message: " + message);
//                    }
//                };
                StandingImageAdapter mAdapter = new StandingImageAdapter(StandingImageController.this, liveScoreModel);
                recycleViewHome.setAdapter(mAdapter);

            }


            @Override
            public void onFailure(Call<LiveScoreModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }
}
