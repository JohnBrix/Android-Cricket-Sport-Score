package com.cricket.cricket.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeagueModel {
    @SerializedName("result")
    private List<LeagueModel.result> result = null;

    public static class result {

        @SerializedName("league_key")
        private String leagueKey;
        @SerializedName("league_name")
        private String leagueName;
        @SerializedName("country_key")
        private String countryKey;
        @SerializedName("country_name")
        private String countryName;

        public result(String leagueKey, String leagueName, String countryKey, String countryName) {
            this.leagueKey = leagueKey;
            this.leagueName = leagueName;
            this.countryKey = countryKey;
            this.countryName = countryName;
        }

        public String getLeagueKey() {
            return leagueKey;
        }

        public void setLeagueKey(String leagueKey) {
            this.leagueKey = leagueKey;
        }

        public String getLeagueName() {
            return leagueName;
        }

        public void setLeagueName(String leagueName) {
            this.leagueName = leagueName;
        }

        public String getCountryKey() {
            return countryKey;
        }

        public void setCountryKey(String countryKey) {
            this.countryKey = countryKey;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }
    }
    public List<result> getResult() {
        return result;
    }
    public void setResult(List<result> result) {
        this.result = result;

    }
}
