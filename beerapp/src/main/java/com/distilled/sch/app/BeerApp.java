package com.distilled.sch.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Beer App
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.distilled.sch.app", "com.distilled.sch.entities"})
@EntityScan("com.distilled.sch.entities")
@ComponentScan(basePackages = {"com.distilled.sch", "com.distilled.sch.entities"})
public class BeerApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(BeerApp.class, args);
    }
}
