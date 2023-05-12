package com.ecore.ta.steps;

import com.ecore.ta.pages.InvoiceDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;


public class InvoiceDetailsSteps {

    @Autowired
    private InvoiceDetailsPage invoiceDetailsPage;


    @When("User open Invoice Details tab")
    public void openInvoiceDetailsTab() {
        invoiceDetailsPage.switchTab();
        invoiceDetailsPage.waitLoading();
    }

    @Then("The Hotel Name is {string}")
    public void theHotelNameIs(String hotelName) {
        Assertions.assertEquals(hotelName,invoiceDetailsPage.getHotelName());
    }

    @Then("The Invoice Date is {string}")
    public void theInvoiceDateIs(String invoiceDate) {
        Assertions.assertEquals(invoiceDate,invoiceDetailsPage.getInvoiceDate());
    }

    @Then("The Due Date is {string}")
    public void theDueDateIs(String dueDate) {
        Assertions.assertEquals(dueDate,invoiceDetailsPage.getDueDate());
    }

    @Then("The Invoice Number is {string}")
    public void theInvoiceNumberIs(String invoiceNumber) {
        Assertions.assertEquals(invoiceNumber,invoiceDetailsPage.getInvoiceNumber());
    }

    @Then("The BookingCode is {string}")
    public void theBookingCodeIs(String bookingCode) {
        Assertions.assertEquals(bookingCode,invoiceDetailsPage.getBookingCode());
    }

    @Then("The Customer Details is {string}")
    public void theCustomerDetailsIs(String customerDetails) {
        Assertions.assertEquals(customerDetails,invoiceDetailsPage.getCustomerDetails());
    }

    @Then("The Room is {string}")
    public void theRoomIs(String room) {
        Assertions.assertEquals(room,invoiceDetailsPage.getRoom());
    }

    @Then("The Check-in is {string}")
    public void theCheckInIs(String checkIn) {
        Assertions.assertEquals(checkIn,invoiceDetailsPage.getCheckIn());
    }

    @Then("The Check-out is {string}")
    public void theCheckOutIs(String checkOut) {
        Assertions.assertEquals(checkOut,invoiceDetailsPage.getCheckOut());
    }

    @Then("The Total Stay Count is {string}")
    public void theTotalStayCountIs(String totalStayCount) {
        Assertions.assertEquals(totalStayCount,invoiceDetailsPage.getTotalStayCount());
    }

    @Then("The Total Stay Amount is {string}")
    public void theTotalStayAmountIs(String totalStayAmount) {
        Assertions.assertEquals(totalStayAmount,invoiceDetailsPage.getTotalStayAmount());
    }

    @Then("The Deposit Now is {string}")
    public void theDepositNowIs(String depositNow) {
        Assertions.assertEquals(depositNow,invoiceDetailsPage.getDepositNow());
    }

    @Then("The Tax&VAT is {string}")
    public void theTaxVATIs(String taxAndVAT) {
        Assertions.assertEquals(taxAndVAT,invoiceDetailsPage.getTaxAndVAT());
    }

    @Then("The Total Amount is {string}")
    public void theTotalAmountIs(String totalAmount) {
        Assertions.assertEquals(totalAmount,invoiceDetailsPage.getTotalAmount());
    }

    @And("User Close Invoice Details tab")
    public void userCloseInvoiceDetailsTab() {
        invoiceDetailsPage.closeTab();
    }
}
