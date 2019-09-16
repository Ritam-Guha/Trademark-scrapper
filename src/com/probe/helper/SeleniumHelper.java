package com.probe.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class SeleniumHelper {
    public static WebElement findElementByXpath(WebDriver webDriver, String xpath) {
        return findElement(webDriver, "xpath", xpath);
    }

    public static WebElement findElementById(WebDriver webDriver, String id) {
        return findElement(webDriver, "id", id);
    }

    private static WebElement findElement(WebDriver webDriver, String context, String target) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(webDriver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class);
            return (context.equals("xpath")) ? wait.until(driver -> driver.findElement(By.xpath(target)))
                    : wait.until(driver -> driver.findElement(By.id(target)));
        }
        catch (TimeoutException e){
            return null;
        }
    }
}