package com.daytime.suntimecalculator.service;

import com.daytime.suntimecalculator.dto.ApiResponse;
import com.daytime.suntimecalculator.dto.SunTimes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class ApiCommunicator {

    private static final String BASE_URL = "https://api.sunrise-sunset.org/json";
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("h:mm:ss a");

    public SunTimes requestTimes(String latitude, String longitude) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("lat", latitude)
                .queryParam("lng", longitude);
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity(uri.toUriString(), ApiResponse.class);
        ApiResponse responseBody = response.getBody();

        LocalTime sunRise = LocalTime.parse(responseBody.getSunRiseTime(), TIME_FORMATTER);
        LocalTime sunSet = LocalTime.parse(responseBody.getSunSetTime(), TIME_FORMATTER);
        return new SunTimes(sunRise, sunSet);
    }
}
