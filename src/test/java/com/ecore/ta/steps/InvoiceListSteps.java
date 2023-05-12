package com.ecore.ta.steps;

import com.ecore.ta.pages.InvoiceListPage;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class InvoiceListSteps {

    @Autowired
    private InvoiceListPage invoiceListPage;

    @When("User click on {string} Invoice information")
    public void userClickOnInvoiceInformation(String hotelName) {
        invoiceListPage.waitLoading();
        invoiceListPage.clickOnInvoiceDetails(hotelName);
    }
}
