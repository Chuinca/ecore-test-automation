package com.ecore.ta.pages;

import com.ecore.ta.base.WebDriverBase;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class LoginPage extends WebDriverBase {

    @Autowired
    Environment env;
    @Value("${login.url}")
    private String loginUrl;

    @FindBy(name = "username")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    @FindBy(css = ".alert.alert-danger.mt-3")
    private WebElement failedLoginMessage;

    public void navigate(){
        getDriver().get(loginUrl);
        waitLoading();
    }

    @Override
    public void waitLoading() {
       waitVisibility(userName,password,loginButton);
    }

    public void loginAsUser(String userKey){
        String userId= (env.getProperty(userKey+".id"));
        String userPw= (env.getProperty(userKey+".pw"));
        log.info("loading user: "+ userId);
        userName.sendKeys(userId);
        password.sendKeys(userPw);
        loginButton.click();
    }


    public String failedLoginWarning() {
        waitVisibility(failedLoginMessage);

        return failedLoginMessage.getText();
    }
}
