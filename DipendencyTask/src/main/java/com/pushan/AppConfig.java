package com.pushan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Bike bike() {
        return new Bike(1, "Yamaha", "Black");
    }

    @Bean
    public Car car() {
        return new Car(101, "BMW", "White");
    }

    @Bean
    public PojoClass pojoClass() {
        return new PojoClass(bike(), car());
    }
}
