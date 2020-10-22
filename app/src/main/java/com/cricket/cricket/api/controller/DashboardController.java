package com.cricket.cricket.api.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.cricket.cricket.api.R;
import com.cricket.cricket.api.model.TrendingModel;
import com.cricket.cricket.api.service.CricketService;
import com.cricket.cricket.api.viewmodel.TrendingAdapter;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardController extends AppCompatActivity {
    ImageView openLeagues;
    TextView latestNews;
    RecyclerView.LayoutManager dashBoardLayout;
    List<TrendingModel.result> resultModels;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    CountDownTimer countTimer;
    ArrayList<String> trendingList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //LAGING NAKA RECYCLER VIEW TO AT NAKA CONTEXT
        setContentView(R.layout.datalist_trending); //datalist_trending dpt to palitan mo muna dashboard main para maitesta

         progressBar = (ProgressBar)findViewById(R.id.spin_kit3);
        Sprite chasingDots = new DoubleBounce();
        progressBar.setIndeterminateDrawable(chasingDots);

        countTimer = new CountDownTimer(2600,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Loading data...", Toast.LENGTH_SHORT).show();


            }
        }.start();

        openLeagues = findViewById(R.id.open_leagues);
        latestNews = findViewById(R.id.latest_news);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_data_only);//display
        getNews();



    }

    public void getNews(){
     dashBoardLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(dashBoardLayout);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CricketService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //create api interface
        CricketService cricketService = retrofit.create(CricketService.class);

        //object calling
        Call<TrendingModel> call = cricketService.getTrending();


        call.enqueue(new Callback<TrendingModel>() {
            @Override
            public void onResponse(Call<TrendingModel> call, Response<TrendingModel> response) {
                TrendingModel news = response.body();
                List<TrendingModel.result> resultListed = news.getResult();
                resultModels = new ArrayList<>();

                //trending use
                for (int i = 5; i < resultListed.size(); i++) {
                    resultModels.add(new TrendingModel.result(
                            resultListed.get(i).getEventDateStart(),
                            resultListed.get(i).getEventDateStop(),
                            resultListed.get(i).getEventStatusInfo(),
                            resultListed.get(i).getLeagueSeason()
                    ));
                    for (int j = 0; j < resultListed.size(); j++) {
                        trendingList.add(resultListed.get(j).getEventStatusInfo() + " "
                                + resultListed.get(j).getLeagueSeason() + " . Event Start at " +
                                resultListed.get(j).getEventDateStart() + " Event Ended at " +
                                resultListed.get(j).getEventDateStop());
                    }
                }


                TrendingAdapter mAdapter = new TrendingAdapter(DashboardController.this, resultModels, trendingList);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<TrendingModel> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("Error mo hahaha");
                Toast.makeText(getApplicationContext(),"Please connect to the internet", Toast.LENGTH_SHORT).show();

                countTimer = new CountDownTimer(2290,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);

                    }
                }.start();



            }

        });

    }




}