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
import android.widget.TextView;
import android.widget.Toast;

import com.cricket.cricket.api.R;
import com.cricket.cricket.api.model.LeagueModel;
import com.cricket.cricket.api.service.CricketService;
import com.cricket.cricket.api.viewmodel.LeagueAdapter;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ThreeBounce;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeaguesController extends AppCompatActivity {
    List<LeagueModel.result> resultModels;
    RecyclerView recyclerView;
    TextView keyname;
    TextView countryName;
    RecyclerView.LayoutManager dashBoardLayout;

    ImageView backToDashboard;
    ProgressBar progressBar;
    CountDownTimer countTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalist_leagues);
        backToDashboard = findViewById(R.id.back_to_dashboard);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_data_only_leagues);//display
        keyname = (TextView) findViewById(R.id.league_name);//display
        countryName = (TextView) findViewById(R.id.country_name_display);//display

        progressBar = findViewById(R.id.spin_kit_leagues);
        Sprite chasingDots = new ThreeBounce(); //STYLE OF LOADING SCREEN
        progressBar.setIndeterminateDrawable(chasingDots);

        countTimer = new CountDownTimer(2290,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                    progressBar.setVisibility(View.GONE);
            }
        }.start();

        getCountry(); //getLeagues
        openIntent();


    }
    public void openIntent(){
        backToDashboard.setOnClickListener(new View.OnClickListener() {
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

        public void getCountry(){
        dashBoardLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(dashBoardLayout);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CricketService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //create api interface
        CricketService cricketService = retrofit.create(CricketService.class);

        //object calling
        Call<LeagueModel> call = cricketService.getCountries();


        call.enqueue(new Callback<LeagueModel>() {
            @Override
            public void onResponse(Call<LeagueModel> call, Response<LeagueModel> response) {
                LeagueModel countryList = response.body();
                List<LeagueModel.result> resultListed = countryList.getResult();
                resultModels = new ArrayList<>();


                    for (int i = 0; i < resultListed.size(); i++) {
                        resultModels.add(new LeagueModel.result(
                                resultListed.get(i).getCountryKey(),
                                resultListed.get(i).getCountryName(),
                                resultListed.get(i).getLeagueName(),
                                resultListed.get(i).getLeagueKey()

                        ));
                    }



//                System.out.println("your search:"+ resultModels.size());
                LeagueAdapter mAdapter = new LeagueAdapter(LeaguesController.this, resultModels);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<LeagueModel> call, Throwable t) { Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("Error");
            }

        });
    }
}