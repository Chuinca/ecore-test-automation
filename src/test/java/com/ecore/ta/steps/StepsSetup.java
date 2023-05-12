package com.ecore.ta.steps;

import com.ecore.ta.webdriver.WebDriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class StepsSetup {

    /**
     * Creating Web Driver before all running stories/features
     */
    @BeforeAll
    public static void beforeAll(){
        WebDriverFactory.createDriver();

    }

    /**
     * Delete the Web Driver instance after all running stories/feature
     */
    @AfterAll
    public static void afterAll(){
        WebDriverFactory.cleanUpDriver();
    }
}
