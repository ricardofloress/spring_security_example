package com.axis.axis_hotels_api;

import com.axis.axis_hotels_api.auth.ApplicationUserDao;
import com.axis.axis_hotels_api.models.User;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class Startup implements ApplicationListener<ContextRefreshedEvent> {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApplicationUserDao applicationUserDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        logger.info("\n\n\nStartUp\n\n\n");

        User ricardo = new User("Ricardo", passwordEncoder.encode("pass"),"ROLE_USER,ROLE_ADMIN");
        User Ralph = new User("Ralph", passwordEncoder.encode("pass"),"ROLE_USER");

        applicationUserDao.save(ricardo);
        applicationUserDao.save(Ralph);

    }
}
