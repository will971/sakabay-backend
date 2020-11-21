package com.mowil.ats.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = { "com.mowil.ats.*" })
@PropertySource("classpath:test.properties")
public class PropsConfiguration {
    @Autowired
    public Environment env;

}
