package com.cricket.cricket.api.service;

import com.cricket.cricket.api.model.H2HModel;
import com.cricket.cricket.api.model.LeagueModel;
import com.cricket.cricket.api.model.EventModel;
import com.cricket.cricket.api.model.LiveScoreModel;
import com.cricket.cricket.api.model.StandingModel;
import com.cricket.cricket.api.model.TrendingModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CricketService {

    String BASE_URL = "https://api.api-cricket.com/";

    @GET("?method=get_leagues&APIkey=b8f331d10b12a679dc03ffe489a47b6bdee8d3bce4b6483d1db15966b502baa5")
    Call<LeagueModel> getCountries();

    @GET("?method=get_events&APIkey=b8f331d10b12a679dc03ffe489a47b6bdee8d3bce4b6483d1db15966b502baa5&date_start=2019-07-24&date_stop=2019-07-24")
    Call<EventModel> getEvent();

    @GET("?method=get_events&APIkey=b8f331d10b12a679dc03ffe489a47b6bdee8d3bce4b6483d1db15966b502baa5&date_start=2019-07-24&date_stop=2019-07-24")
    Call<TrendingModel> getTrending();

    //fixtures ito kaya di live score dahil wala ka maishshow walng laban pa now

    //replace new to ?method=get_livescore&APIkey=b8f331d10b12a679dc03ffe489a47b6bdee8d3bce4b6483d1db15966b502baa5
    @GET("?method=get_events&APIkey=b8f331d10b12a679dc03ffe489a47b6bdee8d3bce4b6483d1db15966b502baa5&date_start=2019-07-24&date_stop=2019-07-24")
    Call<LiveScoreModel> getStandingImageVs();

    //fixture to ?method=get_events&APIkey=b8f331d10b12a679dc03ffe489a47b6bdee8d3bce4b6483d1db15966b502baa5&date_start=2019-07-24&date_stop=2019-07-24
    @GET("?method=get_livescore&APIkey=b8f331d10b12a679dc03ffe489a47b6bdee8d3bce4b6483d1db15966b502baa5")
    Call <LiveScoreModel> getLiveScore();

    @GET("?method=get_standings&league_key=9869&APIkey=b8f331d10b12a679dc03ffe489a47b6bdee8d3bce4b6483d1db15966b502baa5")
    Call <StandingModel> getStanding();

    @GET("?method=get_H2H&APIkey=b8f331d10b12a679dc03ffe489a47b6bdee8d3bce4b6483d1db15966b502baa5&first_team_key=30&second_team_key=5")
    Call<H2HModel> getHeadToHead();
 }
