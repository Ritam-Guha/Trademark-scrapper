package com.probe.trademark.pojo;

import com.probe.helper.SeleniumHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainPage {
    private WebDriver webDriver;
    private Date asOnDate;
    private String applicationStatus;
    private String applicationNo;
    private String tradeMarkClass;
    private Date applicationDate;
    private String office;
    private String state;
    private String country;
    private String filingMode;
    private String tmAppliedFor;
    private String tmCategory;
    private String tmType;
    private String userDetail;
    private String certificateDetail;
    private String validRenewedUpTo;
    private String proprietorName;
    private String proprietorAddress;
    private String email;
    private String agentName;
    private String agentAddress;
    private String goodsServiceDetails;
    private String publicationDetails;
    private Date wipoNotificationDate;
    private String conditions;
    private String internationalRegNo;
    private byte[] trademarkLogo;
    private byte[] mainPageResponse;

    public MainPage(WebDriver webDriver) throws ParseException, IOException {
        this.webDriver = webDriver;
        setAsOnDate();
        setStatus();
        setApplicationNo();
        setTradeMarkClass();
        setApplicationDate();
        setOffice();
        setState();
        setCountry();
        setFilingMode();
        setTmAppliedFor();
        setTmCategory();
        setTmType();
        setUserDetail();
        setCertificateDetail();
        setValidRenewedUpTo();
        setProprietorName();
        setProprietorAddress();
        setEmail();
        setAgentName();
        setAgentAddress();
        setGoodsServiceDetails();
        setPublicationDetails();
        setWipoNotificationDate();
        setConditions();
        setInternationalRegNo();
        setTradeMarkLogo();
        setMainPageResponse();
    }


    public Date getAsOnDate()   {return asOnDate;}

    private void setAsOnDate() throws ParseException {
        String Xpath = "//*[@id=\"lblappdetail\"]/table[2]/tbody/tr[contains(.,'As on Date')]/td[1]/b/font";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            String tillDate = element.getText();
            this.asOnDate = new SimpleDateFormat("dd/MM/yyyy").parse(tillDate);
        }
    }


    public String getStatus()   {return  applicationStatus;}

    private void setStatus()    {
        String Xpath = "//*[@id=\"lblappdetail\"]/table[2]/tbody/tr[contains(.,'Status')]/td[1]/font[2]/b";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null) {
            this.applicationStatus = element.getText();
        }
    }

    public String getApplicationNo() {return this.applicationNo;}

    private void setApplicationNo() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'TM Application No.')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.applicationNo = element.getText();
        }
    }

    public String getTradeMarkClass() {return this.tradeMarkClass;}

    private void setTradeMarkClass() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Class')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.tradeMarkClass = element.getText();
        }
    }

    public Date getApplicationDate() {return this.applicationDate;}

    private void setApplicationDate() throws ParseException {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Date of Application')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            String appDate = element.getText();
            this.applicationDate = new SimpleDateFormat("dd/MM/yyyy").parse(appDate);
        }
    }

    public String getOffice() {return office;}

    private void setOffice() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Appropriate Office')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if (element != null) {
            this.office = element.getText();
        }
    }

    public String getState() {return state;}

    private void setState() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Country')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.state = element.getText();
        }
    }

    public String getCountry() {return country;}

    private void setCountry() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'State')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if (element != null) {
            this.country = element.getText();
        }
    }

    public String getFilingMode() {return filingMode;}

    private void setFilingMode() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Filing Mode')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.filingMode = element.getText();
        }
    }

    public String getTmAppliedFor() {return tmAppliedFor;}

    private void setTmAppliedFor() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'TM Applied For')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.tmAppliedFor = element.getText();
        }
    }

    public String getTmCategory() {return tmCategory;}

    private void setTmCategory() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'TM Category')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null) {
            this.tmCategory = element.getText();
        }
    }

    public String getTmType() {return tmType;}

    private void setTmType() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Trade Mark Type')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.tmType = element.getText();
        }
    }

    public String getUserDetail() {return userDetail;}

    private void setUserDetail() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'User Detail')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.userDetail = element.getText();
        }
    }

    public String getCertificateDetail() {return certificateDetail;}

    private void setCertificateDetail() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Certificate Detail')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.certificateDetail = element.getText();
        }
    }

    public String getValidRenewedUpTo() {return validRenewedUpTo;}

    private void setValidRenewedUpTo() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Valid upto/ Renewed upto')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null) {
            this.validRenewedUpTo = element.getText();
        }
    }

    public String getProprietorName() {return proprietorName;}

    private void setProprietorName() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Proprietor name')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.proprietorName = element.getText();
        }
    }

    public String getProprietorAddress() {return proprietorAddress;}

    private void setProprietorAddress() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Proprietor Address')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.proprietorAddress = element.getText();
        }
    }

    public String getEmail() {return email;}

    private void setEmail() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Email Id')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.email = element.getText();
        }
    }

    public String getAgentName() {return agentName;}

    private void setAgentName() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Agent name') or contains(.,'Attorney name')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.agentName = element.getText();
        }
    }

    public String getAgentAddress() {return agentAddress;}

    private void setAgentAddress() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Agent Address') or contains(.,'Attorney Address')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.agentAddress = element.getText();
        }
    }

    public String getGoodsServiceDetails() {return goodsServiceDetails;}

    private void setGoodsServiceDetails() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Goods & Service Details')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.goodsServiceDetails = element.getText();
        }
    }

    public String getPublicationDetails() {return publicationDetails;}

    private void setPublicationDetails() {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Publication Details')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.publicationDetails = element.getText();
        }
    }

    public Date getWipoNotificationDate() {return wipoNotificationDate;}

    private void setWipoNotificationDate() throws ParseException {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'WIPO Notification Date')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            String wipNotDate = element.getText();
            this.wipoNotificationDate = new SimpleDateFormat("dd/MM/yyyy").parse(wipNotDate);
        }
    }

    public String getConditions()   {return conditions;}

    private void setConditions()   {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'Conditions')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.conditions = element.getText();
        }
    }

    public String getInternationalRegNo()   {return internationalRegNo;}

    private void setInternationalRegNo()    {
        String Xpath = "//*[@id='lblappdetail']/table[3]/tbody/tr[contains(.,'International Reg No.')]/td[2]";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            this.internationalRegNo = element.getText();
        }
    }

    public byte[] getTrademarkLogo()    {return trademarkLogo;}

    private void setTradeMarkLogo() throws IOException {
        String Xpath = "//*[@id=\"lblappdetail\"]/table[4]/tbody/tr[2]/td/img";
        WebElement element = SeleniumHelper.findElementByXpath(webDriver,Xpath);
        if(element != null){
            String newXpath = "/html/body/img";
            String imgLink = element.getAttribute("src");
            ((JavascriptExecutor)webDriver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(1));
            webDriver.get(imgLink);
            File screenShot = webDriver.findElement(By.xpath(newXpath)).getScreenshotAs(OutputType.FILE);
            trademarkLogo = webDriver.findElement(By.xpath(newXpath)).getScreenshotAs(OutputType.BYTES);
            BufferedImage img = ImageIO.read(screenShot);
            ImageIO.write(img, "png", screenShot);
            FileUtils.copyFile(screenShot,
            new File("tests/Trademark Logos/"+applicationNo+".png"));
            webDriver.close();
            webDriver.switchTo().window(tabs.get(0));
            webDriver.switchTo().frame("showframe");
        }
    }

    public byte[] getMainPageResponse()  {return mainPageResponse;}

    private void setMainPageResponse()  {
        mainPageResponse = webDriver.getPageSource().getBytes();
    }
}