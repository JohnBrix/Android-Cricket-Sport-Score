package com.cricket.cricket.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrendingModel {



    @SerializedName("result")
    private List<TrendingModel.result> result = null;

    public static class result {
        @SerializedName("event_date_start")
        private String eventDateStart;
        @SerializedName("event_date_stop")
        private String eventDateStop;
        @SerializedName("event_status_info")
        private String eventStatusInfo;
        @SerializedName("league_season")
        private String leagueSeason;
        public result(String eventDateStart, String eventDateStop, String eventStatusInfo, String leagueSeason) {
            this.eventDateStart = eventDateStart;
            this.eventDateStop = eventDateStop;
            this.eventStatusInfo = eventStatusInfo;
            this.leagueSeason = leagueSeason;
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

        public String getEventStatusInfo() {
            return eventStatusInfo;
        }

        public void setEventStatusInfo(String eventStatusInfo) {
            this.eventStatusInfo = eventStatusInfo;
        }

        public String getLeagueSeason() {
            return leagueSeason;
        }

        public void setLeagueSeason(String leagueSeason) {
            this.leagueSeason = leagueSeason;
        }
    }
    //end of statement
    public List<TrendingModel.result> getResult() {
        return result;
    }

    public void setResult(List<TrendingModel.result> result) {
        this.result = result;
    }
}
