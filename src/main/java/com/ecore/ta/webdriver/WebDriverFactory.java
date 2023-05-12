package com.ecore.ta.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;


import java.time.Duration;

@Component
@Slf4j
public class WebDriverFactory {

    private static WebDriver webDriver;

    private static WebDriverWait webDriverWait;

    /**
     * Retrive WebDriver instance
     */
    public WebDriver getDriver(){
        if(webDriver != null){
            return webDriver;
        } else {
            log.error("NULL Webdriver");
            throw new RuntimeException("NULL Webdriver");
        }
    }

    /**
     * Create a WebDriverWait instance
     */
    public WebDriverWait getWebDriverWait(){
        if (webDriverWait == null){
            this.webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        }

        return webDriverWait;
    }

    /**
     * Destroy WebDriver instance
     */
    public static void cleanUpDriver(){
      if (webDriver ==null)
          throw new IllegalStateException("Web driver is not initialized.");

      webDriver.quit();
      webDriver = null;
      webDriverWait = null;
    }

    /**
     * Create a WebDriver (chrome only) instance
     */
    public static void createDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        log.info("Starting ChromeDriver...");

        webDriver=new ChromeDriver(chromeOptions);
    }

}
