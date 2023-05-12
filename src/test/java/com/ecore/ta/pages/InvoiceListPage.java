package com.ecore.ta.pages;

import com.ecore.ta.base.WebDriverBase;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class InvoiceListPage extends WebDriverBase {

    @Override
    public void waitLoading() {
        waitVisibility(By.cssSelector(".row.mt-3.text-light.bg-dark"));

    }

    public boolean pageIsLoaded(){
        try {
            this.waitLoading();
        } catch (Exception e){
            log.error("Failed to load de page. ", e);
            return false;
        }
        return true;
    }

    public void clickOnInvoiceDetails(String hotelName){
        WebElement detailLink= searchForHotelLink(hotelName);
        detailLink.click();

    }


    private WebElement searchForHotelLink(String hotelName){
        List<WebElement> hotelNames = getDriver().findElements(By.xpath("(//div[@class= 'row']//*[2][@class='col border p-2'])"));
        int nOfRows= hotelNames.size();


        for(int i=0;i<=nOfRows;i++){
            if (hotelNames.get(i).getText().equalsIgnoreCase(hotelName)){
                return getDriver().findElement(By.xpath("(//div[@class= 'row']//*[5][@class='col border p-2'])["+ i+1 +"]/a"));
            }
        }
        log.info("Not able to find Hotel at Invoice List.");
        return null;
    }
}
