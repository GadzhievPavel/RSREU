package com.example.rsreu.data.json_parser.api.source;

import com.example.rsreu.data.json_parser.api.source.subsource.Times;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TimeList {
    @SerializedName("times")
    private List<Times> times;

    public List<Times> getTimes() {
        return times;
    }

    public void setTimes(List<Times> times) {
        this.times = times;
    }
}
