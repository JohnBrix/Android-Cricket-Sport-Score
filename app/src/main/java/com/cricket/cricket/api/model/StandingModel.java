package com.cricket.cricket.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.xml.transform.Result;

public class StandingModel{

    @SerializedName("result")
    private Result result;

    public StandingModel(Result result) {
        super();
        this.result = result;
    }

    public static class Result {

        @SerializedName("total")
        private List<StandingModel.Result.Total> total;

        public Result(List<StandingModel.Result.Total> total) {
            super();
            this.total = total;
        }

        public static class Total {
            @SerializedName("standing_place")
            private String standingPlace;
            @SerializedName("standing_team")
            private String standingTeam;
            @SerializedName("standing_W")
            private String standingW;
            @SerializedName("standing_L")
            private String standingL;

            public Total(String standingPlace, String standingTeam, String standingW, String standingL) {
                super();
                this.standingPlace = standingPlace;
                this.standingTeam = standingTeam;
                this.standingW = standingW;
                this.standingL = standingL;
            }


            public String getStandingPlace() {
                return standingPlace;
            }

            public String getStandingTeam() {
                return standingTeam;
            }

            public String getStandingW() {
                return standingW;
            }

            public String getStandingL() {
                return standingL;
            }
        } // end of total

        public List<StandingModel.Result.Total> getTotal() {
            return total;
        }

    } // end of result

    public Result getResult() {
        return result;
    }
}
