package com.example.WeatherApplication.contoller;

import com.example.WeatherApplication.dto.WeatherDTO;
import com.example.WeatherApplication.response.WeatherResponse;
import com.example.WeatherApplication.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<WeatherResponse> getWeather(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getWeatherByCity(city));

    }
}
