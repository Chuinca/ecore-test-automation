package com.ecore.ta.pages;

import com.ecore.ta.base.WebDriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class InvoiceDetailsPage extends WebDriverBase {

    @FindBy(css = "h4.mt-5")
    WebElement hotelName;

    @FindBy(xpath = "//span[text()='Invoice Date:']/..")
    WebElement invoiceDate;

    @FindBy(xpath = "//span[text()='Due Date:']/..")
    WebElement dueDate;

    @FindBy(css = "h6.mt-2")
    WebElement invoiceNumber;

    @FindBy(xpath = "//td[text()='Booking Code']/following-sibling::td")
    WebElement bookingCode;

    @FindBy(xpath = "//h5[text()='Customer Details']/following-sibling::div")
    WebElement customerDetails;

    @FindBy(xpath = "//td[text()='Room']/following-sibling::td")
    WebElement room;

    @FindBy(xpath = "//td[text()='Check-In']/following-sibling::td")
    WebElement checkIn;

    @FindBy(xpath = "//td[text()='Check-Out']/following-sibling::td")
    WebElement checkOut;

    @FindBy(xpath = "//td[text()='Total Stay Count']/following-sibling::td")
    WebElement totalStayCount;

    @FindBy(xpath = "//td[text()='Total Stay Amount']/following-sibling::td")
    WebElement totalStayAmount;

    @FindBy(xpath = "//h5[text()='Billing Details']/following-sibling::table/tbody/tr/td[1]")
    WebElement depositNow;

    @FindBy(xpath = "//h5[text()='Billing Details']/following-sibling::table/tbody/tr/td[2]")
    WebElement taxAndVAT;

    @FindBy(xpath = "//h5[text()='Billing Details']/following-sibling::table/tbody/tr/td[3]")
    WebElement totalAmount;


    @Override
    public void waitLoading() {
        waitVisibility(By.xpath("//h2[text()='Invoice Details']"));
        waitVisibility(By.xpath("//h5[text()='Customer Details']"));
    }

    public void switchTab(){
        getDriver().getWindowHandles().forEach(tab->getDriver().switchTo().window(tab));

    }

    public void closeTab(){
        getDriver().close();
        switchTab();
    }

    public String getHotelName() {
       return hotelName.getText();
    }

    public String getInvoiceDate() {
        return fixDate(invoiceDate.getText());
    }

    public String getDueDate() {
        return fixDate(dueDate.getText());
    }

    public String getInvoiceNumber() {
        return fixedInvoiceNumber();
    }

    public String getBookingCode() {
        return bookingCode.getText();
    }

    public String getCustomerDetails() {
        return customerDetails.getText().replace("\n", " - ");
    }

    public String getRoom() {
        return room.getText();
    }

    public String getCheckIn() {
        return checkIn.getText();
    }

    public String getCheckOut() {
        return checkOut.getText();
    }

    public String getTotalStayCount() {
        return totalStayCount.getText();
    }

    public String getTotalStayAmount() {
        return totalStayAmount.getText();
    }

    public String getDepositNow() {
        return depositNow.getText();
    }

    public String getTaxAndVAT() {
        return taxAndVAT.getText();
    }

    public String getTotalAmount() {
        return totalAmount.getText();
    }

    private String fixedInvoiceNumber() {
        String invoiceInString= invoiceNumber.getText();
        int startSubstring=invoiceInString.lastIndexOf("#")+1;
        int endSubstring= startSubstring+3;

        String substring=invoiceInString.substring(startSubstring,endSubstring);
        return substring;
    }

    private String fixDate(String date){


        int startSubstring= date.lastIndexOf(":")+2;

        String substring= date.substring(startSubstring,date.length());
        return substring;
    }
}
