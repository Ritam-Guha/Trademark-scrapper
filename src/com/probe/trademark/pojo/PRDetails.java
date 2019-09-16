package com.probe.trademark.pojo;

import com.probe.helper.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PRDetails {

    private WebDriver webDriver;
    private String details;

    public PRDetails(WebDriver webDriver) {
        this.webDriver = webDriver;
        setData();
    }

    private void setData()  {
        SeleniumHelper.findElementById(webDriver,"btnpr").click();
        String Xpath = "//*[@id=\"pnlPopup\"]/div/table[2]/tbody/tr[2]/td";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            details = element.getText();
        }
        SeleniumHelper.findElementByXpath(webDriver,"//*[@id=\"btnHide\"]").click();
    }

    public String getData()    {   return this.details;    }
}
