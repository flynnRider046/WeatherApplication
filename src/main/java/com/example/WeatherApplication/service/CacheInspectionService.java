package com.example.WeatherApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CacheInspectionService {
    @Autowired
    private CacheManager cacheManager;

    public void printCacheContents(String cacheName){
        //we are fetching cache from the cache manager using the cacheName
        Cache cache = cacheManager.getCache(cacheName);
        if(cache != null){
            System.out.println("Cache Contents:");
            /*
            Objects.requirenonnull is used to check if the object
            contains content. If the object is empty it throws
            NullPointerException
             */
            System.out.println(Objects.requireNonNull(cache.getNativeCache()).toString());
        } else {
            System.out.println("No such cache: " + cacheName);
        }
    }
}
