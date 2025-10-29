package com.example.WeatherApplication.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    private Main main;
    private List<Weather> weather;
    private String name;

    // Getters and Setters
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ---------- Inner Class Main ----------
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Main {
        private double temp;

        // Getters and Setters
        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }
    }

    // ---------- Inner Class Weather ----------
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weather {
        private String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
