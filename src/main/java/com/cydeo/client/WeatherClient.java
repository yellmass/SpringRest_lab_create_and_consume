package com.cydeo.client;

import com.cydeo.dto.weatherApi.WeatherApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(url = "https://api.openweathermap.org", name = "WEATHER-CLIENT")
public interface WeatherClient {

    @GetMapping("/data/2.5/weather?units=imperial&")
    WeatherApi getWeatherData(@RequestParam(value = "q") String city,
                              @RequestParam(value = "appid") String apiKey);
}
