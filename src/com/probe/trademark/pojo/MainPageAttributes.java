package com.probe.trademark.pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashSet;
import java.util.Set;

public class MainPageAttributes {
    Set<String> attributeNames;

    public MainPageAttributes(WebDriver webDriver){
        attributeNames = new HashSet<String>();
        int rowNum = webDriver.findElement(By.xpath("//*[@id=\"lblappdetail\"]/table[3]")).findElements(By.tagName("tr")).size();
        for(int iterator = 1; iterator <= rowNum; iterator++){
            String attribute = webDriver.findElement(By.xpath("//*[@id=\"lblappdetail\"]/table[3]/tbody/tr[" + iterator + "]/td[1]")).getText();
            attributeNames.add(attribute);
        }
    }

    public Set<String> getAttributeNames()  {   return attributeNames; }
}
