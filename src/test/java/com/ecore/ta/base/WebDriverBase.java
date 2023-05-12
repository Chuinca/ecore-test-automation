package com.ecore.ta.base;

import com.ecore.ta.webdriver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class WebDriverBase {

    @Autowired
    private WebDriverFactory webDriverFactory;

    protected WebDriver getDriver(){
        return this.webDriverFactory.getDriver();
    }

    protected WebDriverWait getWebDriverWait(){
        return this.webDriverFactory.getWebDriverWait();
    }
    @PostConstruct
    protected void init(){
        PageFactory.initElements(getDriver(), this);
    }

    protected void waitVisibility(WebElement... webElements){
        getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    protected void waitVisibility(By by){
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public abstract void waitLoading();

}
