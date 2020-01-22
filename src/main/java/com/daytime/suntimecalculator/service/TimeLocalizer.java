package com.daytime.suntimecalculator.service;

import com.daytime.suntimecalculator.dto.SunTimes;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class TimeLocalizer {

    public static final int HOURS_TO_ADD = 2;

    public SunTimes localizeTime(SunTimes unlocalizedTime) {
        LocalTime localSunRise = unlocalizedTime.getSunRise().plusHours(HOURS_TO_ADD);
        LocalTime localSunSet = unlocalizedTime.getSunSet().plusHours(HOURS_TO_ADD);
        return new SunTimes(localSunRise, localSunSet);
    }

}
