package com.probe.trademark.pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Meta {
    private WebDriver webDriver;
    private String trademarkNo;
    private String trademarkClass;
    private Date applicationDate;
    private String tradeMark;
    private String proprietorName;

    public Meta(WebDriver webDriver) throws ParseException {

        this.webDriver = webDriver;
        setTrademarkNo();
        setTrademarkClass();
        setApplicationDate();
        setTradeMark();
        setProprietorName();
    }

   public String getTrademarkNo()  {return trademarkNo;}

   private void setTrademarkNo()   {
        trademarkNo = webDriver.findElement(By.xpath("//*[@id=\"SearchWMDatagrid\"]/tbody/tr[2]/td[1]")).getText();
   }

    public String getTrademarkClass()  {return trademarkClass;}

    private void setTrademarkClass()   {
        trademarkClass = webDriver.findElement(By.xpath("//*[@id=\"SearchWMDatagrid\"]/tbody/tr[2]/td[2]")).getText();
    }
    public Date getApplicationDate()  {return applicationDate;}

    private void setApplicationDate() throws ParseException {
        String applyDate = webDriver.findElement(By.xpath("//*[@id=\"SearchWMDatagrid\"]/tbody/tr[2]/td[3]")).getText();
        applicationDate = new SimpleDateFormat("dd/MM/yyyy").parse(applyDate);
    }
    public String getTradeMark()  {return tradeMark;}

    private void setTradeMark()   {
        tradeMark = webDriver.findElement(By.xpath("//*[@id=\"SearchWMDatagrid\"]/tbody/tr[2]/td[4]")).getText();
    }
    public String getProprietorName()  {return proprietorName;}

    private void setProprietorName()   {
        proprietorName = webDriver.findElement(By.xpath("//*[@id=\"SearchWMDatagrid\"]/tbody/tr[2]/td[5]")).getText();
    }

}