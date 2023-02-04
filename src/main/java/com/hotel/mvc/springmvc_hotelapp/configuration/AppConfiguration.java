package com.hotel.mvc.springmvc_hotelapp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration        //To register this class as java config file
@ComponentScan(basePackages = "com.hotel.mvc")
public class AppConfiguration {

}
