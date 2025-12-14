package com.example.WeatherApplication.contoller;

import com.example.WeatherApplication.response.WeatherResponse;
import com.example.WeatherApplication.service.CacheInspectionService;
import com.example.WeatherApplication.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    private final CacheInspectionService cacheInspectionService;

    public WeatherController(WeatherService weatherService, CacheInspectionService cacheInspectionService) {
        this.weatherService = weatherService;
        this.cacheInspectionService = cacheInspectionService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<WeatherResponse> getWeather(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getWeatherByCity(city));
    }

    @GetMapping("/cacheData")
    public void getCacheData() {
        cacheInspectionService.printCacheContents("weather");

    }
}
