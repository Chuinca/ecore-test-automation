package com.ecore.ta.steps;

import com.ecore.ta.components.HeaderComponent;
import com.ecore.ta.pages.InvoiceListPage;
import com.ecore.ta.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginSteps {
    @Autowired
    private LoginPage loginPage;

    @Autowired
    private InvoiceListPage invoiceListPage;

    @Autowired
    private HeaderComponent headerComponent;


    @Given("User navigate to the application Login Page")
    public void navigateToLoginPage(){
        loginPage.navigate();
    }

    @When("User {string} enter username and password")
    public void doLogin(String user){
        loginPage.loginAsUser(user);
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        Assertions.assertTrue(invoiceListPage.pageIsLoaded(),"Invoice List page content did not load properly.");
        Assertions.assertTrue(headerComponent.headerIsLoaded(), "Header did not load properly.");
    }

    @Then("User should NOT be able to login")
    public void userShouldNOTBeAbleToLogin() {
        Assertions.assertEquals("Wrong username or password.",loginPage.failedLoginWarning());
    }

    @Then("User logout from the system")
    public void userLogoutFromTheSystem() {
        headerComponent.clickLogout();
        loginPage.waitLoading();
    }
}
