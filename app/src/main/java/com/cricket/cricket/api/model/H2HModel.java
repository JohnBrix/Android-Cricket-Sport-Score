package com.cricket.cricket.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.xml.transform.Result;

public class H2HModel {

    @SerializedName("result")
    private Result result;

    public H2HModel(Result result) {
        super();
        this.result = result;
    }

    //end of statement

    //Result class
    public static class Result {

        @SerializedName("H2H")
        private List<H2HModel.Result.H2H> h2h;

        public Result(List<H2HModel.Result.H2H> h2h) {
            super();
            this.h2h = h2h;
    }

        public static class H2H {
        // insde of these are data

            @SerializedName("event_date_start")
            private String eventDateStart;
            @SerializedName("event_date_stop")
            private String eventDateStop;
            @SerializedName("event_home_team")
            private String eventHomeTeam;
            @SerializedName("event_away_team")
            private String eventAwayTeam;
            @SerializedName("event_home_final_result")
            private String eventHomeFinalResult;
            @SerializedName("event_away_final_result")
            private String eventAwayFinalResult;
            @SerializedName("event_status_info")
            private String eventStatusInfo;
            @SerializedName("league_name")
            private String leagueName;

            public H2H(String eventDateStart, String eventDateStop, String eventHomeTeam, String eventAwayTeam, String eventHomeFinalResult, String eventAwayFinalResult, String eventStatusInfo, String leagueName) {
                this.eventDateStart = eventDateStart;
                this.eventDateStop = eventDateStop;
                this.eventHomeTeam = eventHomeTeam;
                this.eventAwayTeam = eventAwayTeam;
                this.eventHomeFinalResult = eventHomeFinalResult;
                this.eventAwayFinalResult = eventAwayFinalResult;
                this.eventStatusInfo = eventStatusInfo;
                this.leagueName = leagueName;
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

            public String getEventHomeTeam() {
                return eventHomeTeam;
            }

            public void setEventHomeTeam(String eventHomeTeam) {
                this.eventHomeTeam = eventHomeTeam;
            }

            public String getEventAwayTeam() {
                return eventAwayTeam;
            }

            public void setEventAwayTeam(String eventAwayTeam) {
                this.eventAwayTeam = eventAwayTeam;
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

            public String getEventStatusInfo() {
                return eventStatusInfo;
            }

            public void setEventStatusInfo(String eventStatusInfo) {
                this.eventStatusInfo = eventStatusInfo;
            }

            public String getLeagueName() {
                return leagueName;
            }

            public void setLeagueName(String leagueName) {
                this.leagueName = leagueName;
            }

        } // end of h2h
        public List<H2HModel.Result.H2H> getH2h() {
            return h2h;
        }
} //end of result class
    public H2HModel.Result getResult() {
        return result;
    }
}
