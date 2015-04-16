package com.rvcode.examples.csvmessageconverter;

import com.rvcode.examples.csvmessageconverter.controllers.CountriesController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author Volodymyr Rudyi (vladimir.rudoy@gmail.com)
 */
@SpringBootApplication
public class SpringBootApp {
    public static void main(String []args){
        SpringApplication.run(SpringBootApp.class);
    }
}
