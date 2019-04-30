package com.example.rsreu.data.json_parser.api.source;


import com.example.rsreu.data.json_parser.api.source.subsource.Denominator;
import com.example.rsreu.data.json_parser.api.source.subsource.Numerator;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupTime {
    @SerializedName("numerator")
    private List<Numerator> numerators;

    @SerializedName("denominator")
    private List<Denominator> denominators;

    public List<Numerator> getNumerators() {
        return numerators;
    }

    public void setNumerators(List<Numerator> numerators) {
        this.numerators = numerators;
    }

    public List<Denominator> getDenominators() {
        return denominators;
    }

    public void setDenominators(List<Denominator> denominators) {
        this.denominators = denominators;
    }

}
