package com.example.WeatherApplication.service;

import com.example.WeatherApplication.repository.UserDetailsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {


    Logger logger = LogManager.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Load By UserName: Execution started");
        return userDetailsRepository.findByUserName(username).orElseThrow(() ->
                new UsernameNotFoundException("Username not Found"));
    }
}
