package com.daytime.suntimecalculator.dto;

import java.time.LocalTime;
import java.util.Date;

public class SunTimes {

    private LocalTime sunRise;
    private LocalTime sunSet;

    public SunTimes(LocalTime sunRise, LocalTime sunSet) {
        this.sunRise = sunRise;
        this.sunSet = sunSet;
    }

    public LocalTime getSunRise() {
        return sunRise;
    }

    public void setSunRise(LocalTime sunRise) {
        this.sunRise = sunRise;
    }

    public LocalTime getSunSet() {
        return sunSet;
    }

    public void setSunSet(LocalTime sunSet) {
        this.sunSet = sunSet;
    }

    @Override
    public String toString() {
        return "SunTimes{" +
                "sunRise=" + sunRise +
                ", sunSet=" + sunSet +
                '}';
    }
}
