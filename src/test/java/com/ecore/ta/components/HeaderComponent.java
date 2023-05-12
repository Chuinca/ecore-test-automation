package com.ecore.ta.components;

import com.ecore.ta.base.WebDriverBase;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HeaderComponent extends WebDriverBase {


    @FindBy(xpath = "//*[@class='btn btn-outline-info my-2 my-sm-0']")
    private WebElement logoutButton;

    @Override
    public void waitLoading() {
        waitVisibility(By.cssSelector(".navbar.navbar-dark.bg-dark"));
        waitVisibility(By.cssSelector(".btn.btn-outline-info.my-2.my-sm-0"));
    }

    public boolean headerIsLoaded(){
        try {
            this.waitLoading();
        } catch (Exception e){
            log.error("Failed to load de page. ", e);
            return false;
        }
        return true;
    }

    public void clickLogout(){
        waitVisibility(logoutButton);
        logoutButton.click();
    }
}
