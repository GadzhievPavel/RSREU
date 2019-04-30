package com.example.rsreu.data.json_parser.api.source.subsource;

public class Settings {
   // @SerializedName("startDate")
    private String startDate;
   // @SerializedName("endDate")
    private String endDate;
   // @SerializedName("isNumerator")
    String isNumerator;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String isNumerator() {
        return isNumerator;
    }

    public void setNumerator(String numerator) {
        isNumerator = numerator;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


}
