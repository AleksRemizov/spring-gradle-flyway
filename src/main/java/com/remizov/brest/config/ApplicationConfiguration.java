package com.remizov.brest.config;

import com.remizov.brest.conditional.CustomConditional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Slf4j
@Conditional(CustomConditional.class)
@Profile("dev")
@Configuration
public class ApplicationConfiguration {

    @PostConstruct
    public void init(){
        log.warn("App loaded!");
    }
}
