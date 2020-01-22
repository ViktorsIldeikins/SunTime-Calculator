package com.daytime.suntimecalculator.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ApiResponse {

    private Results results;
    private String status;

    public ApiResponse() {
    }

    public ApiResponse(Results results, String status) {
        this.results = results;
        this.status = status;
    }

    public String getSunRiseTime() {
        return results.getSunrise();
    }

    public String getSunSetTime() {
        return results.getSunset();
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "results=" + results +
                ", status='" + status + '\'' +
                '}';
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Results {

    private String sunrise;
    private String sunset;

    public Results() {
    }

    public Results(String sunrise, String sunset) {
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "Results{" +
                "sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                '}';
    }
}