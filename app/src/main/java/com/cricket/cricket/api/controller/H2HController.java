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
import com.cricket.cricket.api.model.H2HModel;
import com.cricket.cricket.api.service.CricketService;
import com.cricket.cricket.api.viewmodel.H2HAdapter;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ThreeBounce;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class H2HController extends AppCompatActivity {
    ProgressBar progressBar;
    CountDownTimer countTimer;
    ImageView backDashboard;
    RecyclerView recycleViewH2H;
    RecyclerView.LayoutManager H2HLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalist_h2h);
        backDashboard = findViewById(R.id.back_to_dashboard_h2h);
        recycleViewH2H = findViewById(R.id.datalist_h2h_recycler_view);
        progressBar = (ProgressBar)findViewById(R.id.spin_kit_h2h);
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

        getH2h();
        backToDashboard();
    }
    public void backToDashboard(){
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

    public void getH2h(){
        H2HLayout = new LinearLayoutManager(this);
        recycleViewH2H.setLayoutManager(H2HLayout);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CricketService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CricketService cricketApi = retrofit.create(CricketService.class);

        Call<H2HModel> call = cricketApi.getHeadToHead();

        call.enqueue(new Callback<H2HModel>() {
            @Override
            public void onResponse(Call<H2HModel> call, Response<H2HModel> response) {
                H2HModel a = response.body();
                List<H2HModel.Result.H2H> b = a.getResult().getH2h();
//                List<StandingModel.Result.Total> total = new ArrayList<>();

                List<H2HModel.Result.H2H> totalListed;
                totalListed = new ArrayList<>();

                for (int i = 0; i < b.size(); i++) {
                    totalListed.add(new H2HModel.Result.H2H(
                            b.get(i).getEventDateStart(),
                            b.get(i).getEventDateStop(),
                            b.get(i).getEventHomeTeam(),
                            b.get(i).getEventAwayTeam(),
                            b.get(i).getEventHomeFinalResult(),
                            b.get(i).getEventAwayFinalResult(),
                            b.get(i).getEventStatusInfo(),
                            b.get(i).getLeagueName()
                    ));
                }

                H2HAdapter mAdapter = new H2HAdapter(H2HController.this, totalListed);
                recycleViewH2H.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<H2HModel> call, Throwable t) {

                System.out.println("debug tnga"+t.toString());
            }

        });
    }

}