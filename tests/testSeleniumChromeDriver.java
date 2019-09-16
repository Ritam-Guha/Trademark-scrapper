import com.probe.helper.SeleniumHelper;
import com.probe.trademark.pojo.*;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.awt.*;
import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class testSeleniumChromeDriver {
    public static void main(String[] args) throws ParseException, IOException, InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", new File("driver/chromedriver").getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        testSeleniumChromeDriver test = new testSeleniumChromeDriver();
        int applyNo = 4190562;
        while(true) {
            ScrapedResults scrapedResults = test.getScrapedResults(String.valueOf(applyNo++), options);
            System.out.println("-------------------Meta data-----------------------");
            System.out.println(scrapedResults.getMeta().getTrademarkNo());
            System.out.println(scrapedResults.getMeta().getTrademarkClass());
            System.out.println(scrapedResults.getMeta().getApplicationDate());
            System.out.println(scrapedResults.getMeta().getTradeMark());
            System.out.println(scrapedResults.getMeta().getProprietorName());
            System.out.println("-------------------Mein page details-----------------------");
            System.out.println(scrapedResults.getMainPage().getAsOnDate());
            System.out.println(scrapedResults.getMainPage().getStatus());
            System.out.println(scrapedResults.getMainPage().getApplicationNo());
            System.out.println(scrapedResults.getMainPage().getTradeMarkClass());
            System.out.println(scrapedResults.getMainPage().getApplicationDate());
            System.out.println(scrapedResults.getMainPage().getOffice());
            System.out.println(scrapedResults.getMainPage().getState());
            System.out.println(scrapedResults.getMainPage().getCountry());
            System.out.println(scrapedResults.getMainPage().getFilingMode());
            System.out.println(scrapedResults.getMainPage().getTmAppliedFor());
            System.out.println(scrapedResults.getMainPage().getTmCategory());
            System.out.println(scrapedResults.getMainPage().getTmType());
            System.out.println(scrapedResults.getMainPage().getUserDetail());
            System.out.println(scrapedResults.getMainPage().getCertificateDetail());
            System.out.println(scrapedResults.getMainPage().getValidRenewedUpTo());
            System.out.println(scrapedResults.getMainPage().getProprietorName());
            System.out.println(scrapedResults.getMainPage().getProprietorAddress());
            System.out.println(scrapedResults.getMainPage().getEmail());
            System.out.println(scrapedResults.getMainPage().getAgentName());
            System.out.println(scrapedResults.getMainPage().getAgentAddress());
            System.out.println(scrapedResults.getMainPage().getGoodsServiceDetails());
            System.out.println(scrapedResults.getMainPage().getPublicationDetails());
            System.out.println("-------------------PR details-----------------------");
            System.out.println(scrapedResults.getPrDetails().getClass());
            System.out.println(scrapedResults.getPrDetails().getData());
        }
    }

    private ScrapedResults getScrapedResults(String applicationNo, ChromeOptions options) throws ParseException, IOException, AWTException, InterruptedException {
        ArrayList<Document> uploadedDocuments = new ArrayList<>();
        ArrayList<Document> referenceDocuments = new ArrayList<>();
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://ipindiaonline.gov.in/eregister/eregister.aspx");
        webDriver.switchTo().frame("eregoptions");
        SeleniumHelper.findElementById(webDriver,"btnviewdetails").click();
        webDriver.switchTo().parentFrame();
        webDriver.switchTo().frame("showframe");
        SeleniumHelper.findElementById(webDriver,"rdb_0").click();
        SeleniumHelper.findElementById(webDriver,"applNumber").sendKeys(applicationNo);
        System.out.print("Enter captcha:");
        Scanner scan = new Scanner(System.in);
        String captcha = scan.nextLine();
        SeleniumHelper.findElementById(webDriver,"captcha1").sendKeys(captcha);
        SeleniumHelper.findElementById(webDriver,"btnView").click();
        System.out.println("Application No. : " + applicationNo);
        Meta metaData = new Meta(webDriver);
        System.out.println("Saved metadata....");
        SeleniumHelper.findElementById(webDriver,"SearchWMDatagrid_ctl03_lnkbtnappNumber1").click();
        MainPage mainPage = new MainPage(webDriver);
        System.out.println("Saved main page....");
        // scraping uploaded documents
        SeleniumHelper.findElementById(webDriver,"btndocument").click();
        int rowNum1 = SeleniumHelper.findElementByXpath(webDriver,"//*[@id=\"pnlPopup\"]/div/table[2]").findElements(By.tagName("tr")).size();
        System.out.println((rowNum1-1) + " document(s) uploaded by the company");
        for (int iterator = 2; iterator <= rowNum1; iterator++) {
            WebElement element = SeleniumHelper.findElementByXpath(webDriver,"//*[@id=\\\"pnlPopup\\\"]/div/table[2]/tbody/tr[" + iterator + "]/td[2]");
            if(element != null) {
                String name = element.getText();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(SeleniumHelper.findElementByXpath(webDriver, "//*[@id=\\\"pnlPopup\\\"]/div/table[2]/tbody/tr[" + iterator + "]/td[3]").getText());
                String fileLink = SeleniumHelper.findElementByXpath(webDriver, "//*[@id=\"pnlPopup\"]/div/table[2]/tbody/tr[" + iterator + "]/td[4]/a").getAttribute("href");
                URL fileUrl = new URL(fileLink);
                byte[] bytes = IOUtils.toByteArray(new BufferedInputStream(fileUrl.openStream()));
                Document document = new Document(name, date, bytes);
                uploadedDocuments.add(document);
            }
        }
        SeleniumHelper.findElementByXpath(webDriver,"//*[@id=\"btnHide\"]").click();
        System.out.println("Saved uploaded documents....");
        //scraping PR details
        PRDetails prDetails = new PRDetails(webDriver);
        //scraping reference documents
        int rowNum2 = SeleniumHelper.findElementByXpath(webDriver,"//*[@id=\"lblappdetail\"]/table[2]").findElements(By.tagName("a")).size();
        for (int iterator = 1; iterator <= rowNum2; iterator++){
            WebElement element = SeleniumHelper.findElementByXpath(webDriver,"//*[@id=\"lblappdetail\"]/table[2]/tbody/tr[" + iterator + "]/td[2]/a");
            if(element != null) {
                String docLink = element.getAttribute("href");
                URL docUrl = new URL(docLink);
                byte[] docBytes = IOUtils.toByteArray(new BufferedInputStream(docUrl.openStream()));
                String docName = SeleniumHelper.findElementByXpath(webDriver, "//*[@id=\"lblappdetail\"]/table[2]/tbody/tr[" + iterator + "]/td[2]/a").getText();
                Document refDoc = new Document(docName, null, docBytes);
                referenceDocuments.add(refDoc);
            }
        }
        System.out.println("Saved referenced documents....");
        webDriver.close();
        return new ScrapedResults(metaData,uploadedDocuments,referenceDocuments,mainPage,prDetails);
    }
}
