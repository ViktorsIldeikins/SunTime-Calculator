package com.daytime.suntimecalculator;

import com.daytime.suntimecalculator.dto.SunTimes;
import com.daytime.suntimecalculator.service.ApiCommunicator;
import com.daytime.suntimecalculator.service.TimeLocalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SunTimeController {

    private ApiCommunicator communicator;
    private TimeLocalizer localizer;

    @Autowired
    public SunTimeController(ApiCommunicator communicator, TimeLocalizer localizer) {
        this.communicator = communicator;
        this.localizer = localizer;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/sunset-sunrise/today")
    public SunTimes getTimeForToday(@RequestParam String latitude, @RequestParam String longitude) {
        System.out.println("Received request");
        SunTimes sunTimes = communicator.requestTimes(latitude, longitude);
        return localizer.localizeTime(sunTimes);
    }
}
