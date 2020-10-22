package com.cricket.cricket.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LiveScoreModel {



    @SerializedName("result")
    private List<LiveScoreModel.result> result = null;

    public static class result {
        @SerializedName("event_key")
        private String eventKey;
        @SerializedName("event_date_start")
        private String eventDateStart;
        @SerializedName("event_date_stop")
        private String eventDateStop;
        @SerializedName("event_time")
        private String eventTime;
        @SerializedName("event_home_team")
        private String eventHomeTeam;
        @SerializedName("home_team_key")
        private String homeTeamKey;
        @SerializedName("event_away_team")
        private String eventAwayTeam;
        @SerializedName("away_team_key")
        private String awayTeamKey;
        @SerializedName("event_service_home")
        private String eventServiceHome;
        @SerializedName("event_service_away")
        private String eventServiceAway;
        @SerializedName("event_home_final_result")
        private String eventHomeFinalResult;
        @SerializedName("event_away_final_result")
        private String eventAwayFinalResult;
        @SerializedName("event_home_rr")
        private String eventHomeRr;
        @SerializedName("event_away_rr")
        private String eventAwayRr;
        @SerializedName("event_status")
        private String eventStatus;
        @SerializedName("event_status_info")
        private String eventStatusInfo;
        @SerializedName("country_name")
        private String countryName;
        @SerializedName("league_name")
        private String leagueName;
        @SerializedName("league_key")
        private String leagueKey;
        @SerializedName("league_round")
        private String leagueRound;
        @SerializedName("league_season")
        private String leagueSeason;
        @SerializedName("event_live")
        private String eventLive;
        @SerializedName("event_home_team_logo")
        private String eventHomeTeamLogo;
        @SerializedName("event_away_team_logo")
        private String eventAwayTeamLogo;

        public result(String eventHomeTeam, String eventAwayTeam, String eventHomeFinalResult,
                      String eventAwayFinalResult,
                      String eventHomeTeamLogo, String eventAwayTeamLogo,String eventDateStart, String eventDateStop  ) {
            this.eventHomeTeam = eventHomeTeam;
            this.eventAwayTeam = eventAwayTeam;
            this.eventHomeFinalResult = eventHomeFinalResult;
            this.eventAwayFinalResult = eventAwayFinalResult;
            this.eventHomeTeamLogo = eventHomeTeamLogo;
            this.eventAwayTeamLogo = eventAwayTeamLogo;
            this.eventDateStart = eventDateStart;
            this.eventDateStop = eventDateStop;
        }

        public String getEventKey() {
            return eventKey;
        }

        public void setEventKey(String eventKey) {
            this.eventKey = eventKey;
        }

        public String getEventDateStart() {
            return eventDateStart;
        }

        public void setEventDateStart(String eventDateStart) {
            this.eventDateStart = eventDateStart;
        }

        public String getEventDateStop() {
            return eventDateStop;
        }

        public void setEventDateStop(String eventDateStop) {
            this.eventDateStop = eventDateStop;
        }

        public String getEventTime() {
            return eventTime;
        }

        public void setEventTime(String eventTime) {
            this.eventTime = eventTime;
        }

        public String getEventHomeTeam() {
            return eventHomeTeam;
        }

        public void setEventHomeTeam(String eventHomeTeam) {
            this.eventHomeTeam = eventHomeTeam;
        }

        public String getHomeTeamKey() {
            return homeTeamKey;
        }

        public void setHomeTeamKey(String homeTeamKey) {
            this.homeTeamKey = homeTeamKey;
        }

        public String getEventAwayTeam() {
            return eventAwayTeam;
        }

        public void setEventAwayTeam(String eventAwayTeam) {
            this.eventAwayTeam = eventAwayTeam;
        }

        public String getAwayTeamKey() {
            return awayTeamKey;
        }

        public void setAwayTeamKey(String awayTeamKey) {
            this.awayTeamKey = awayTeamKey;
        }

        public String getEventServiceHome() {
            return eventServiceHome;
        }

        public void setEventServiceHome(String eventServiceHome) {
            this.eventServiceHome = eventServiceHome;
        }

        public String getEventServiceAway() {
            return eventServiceAway;
        }

        public void setEventServiceAway(String eventServiceAway) {
            this.eventServiceAway = eventServiceAway;
        }

        public String getEventHomeFinalResult() {
            return eventHomeFinalResult;
        }

        public void setEventHomeFinalResult(String eventHomeFinalResult) {
            this.eventHomeFinalResult = eventHomeFinalResult;
        }

        public String getEventAwayFinalResult() {
            return eventAwayFinalResult;
        }

        public void setEventAwayFinalResult(String eventAwayFinalResult) {
            this.eventAwayFinalResult = eventAwayFinalResult;
        }

        public String getEventHomeRr() {
            return eventHomeRr;
        }

        public void setEventHomeRr(String eventHomeRr) {
            this.eventHomeRr = eventHomeRr;
        }

        public String getEventAwayRr() {
            return eventAwayRr;
        }

        public void setEventAwayRr(String eventAwayRr) {
            this.eventAwayRr = eventAwayRr;
        }

        public String getEventStatus() {
            return eventStatus;
        }

        public void setEventStatus(String eventStatus) {
            this.eventStatus = eventStatus;
        }

        public String getEventStatusInfo() {
            return eventStatusInfo;
        }

        public void setEventStatusInfo(String eventStatusInfo) {
            this.eventStatusInfo = eventStatusInfo;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getLeagueName() {
            return leagueName;
        }

        public void setLeagueName(String leagueName) {
            this.leagueName = leagueName;
        }

        public String getLeagueKey() {
            return leagueKey;
        }

        public void setLeagueKey(String leagueKey) {
            this.leagueKey = leagueKey;
        }

        public String getLeagueRound() {
            return leagueRound;
        }

        public void setLeagueRound(String leagueRound) {
            this.leagueRound = leagueRound;
        }

        public String getLeagueSeason() {
            return leagueSeason;
        }

        public void setLeagueSeason(String leagueSeason) {
            this.leagueSeason = leagueSeason;
        }

        public String getEventLive() {
            return eventLive;
        }

        public void setEventLive(String eventLive) {
            this.eventLive = eventLive;
        }

        public String getEventHomeTeamLogo() {
            return eventHomeTeamLogo;
        }

        public void setEventHomeTeamLogo(String eventHomeTeamLogo) {
            this.eventHomeTeamLogo = eventHomeTeamLogo;
        }

        public String getEventAwayTeamLogo() {
            return eventAwayTeamLogo;
        }

        public void setEventAwayTeamLogo(String eventAwayTeamLogo) {
            this.eventAwayTeamLogo = eventAwayTeamLogo;
        }




    }
    //end of statement

    public List<LiveScoreModel.result> getResult() {
        return result;
    }

    public void setResult(List<LiveScoreModel.result> result) {
        this.result = result;
    }
}
