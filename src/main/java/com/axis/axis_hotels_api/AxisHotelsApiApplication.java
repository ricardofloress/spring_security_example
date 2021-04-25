package com.axis.axis_hotels_api;


import com.axis.axis_hotels_api.auth.ApplicationUserDao;
import com.axis.axis_hotels_api.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = ApplicationUserDao.class)
public class AxisHotelsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AxisHotelsApiApplication.class, args);
    }

}
