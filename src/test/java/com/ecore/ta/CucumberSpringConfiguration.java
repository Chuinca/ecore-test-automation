package com.ecore.ta;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CucumberContextConfiguration
@EnableConfigurationProperties
public class CucumberSpringConfiguration {
}


