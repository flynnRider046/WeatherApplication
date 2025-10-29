package com.example.WeatherApplication.service;

import com.example.WeatherApplication.dto.WeatherDTO;
import com.example.WeatherApplication.response.WeatherResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherService {

    @Value("${weather.api.url}")
    private String apiURL;

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse getWeatherByCity(String city) {
        String url = String.format("%s?q=%s&appid=%s&units=metric", apiURL, city.trim(), apiKey);

        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

        if (response == null || response.getMain() == null || response.getWeather() == null) {
            throw new RuntimeException("Failed to fetch weather data");
        }

        return response;
    }


}
