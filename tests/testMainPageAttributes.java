import com.probe.trademark.pojo.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.probe.helper.SeleniumHelper;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class testMainPageAttributes {

    public static void main(String[] args) throws ParseException, IOException {
        System.setProperty("webdriver.chrome.driver", new File("driver/chromedriver").getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        testSeleniumChromeDriver test = new testSeleniumChromeDriver();
        int applyNo = 4190564;
        String filePath = "/home/ritam/probe/trademark-scraper/tests/Attribute Names.txt";
        while(true) {
            Set<String> attributeNames = getAttributes(Integer.toString(applyNo++), options);
//            System.out.println(attributeNames);
            String curAttribute;
            BufferedReader bufRead = new BufferedReader(new FileReader(filePath));
            while((curAttribute = (bufRead.readLine()))!=null){
                attributeNames.add(curAttribute);
            }
            bufRead.close();
            BufferedWriter bufWrite = new BufferedWriter(new FileWriter(filePath));
            Iterator it = attributeNames.iterator();
            while(it.hasNext()) {
                bufWrite.write(String.valueOf(it.next()));
                bufWrite.newLine();
            }
            bufWrite.close();
            System.out.println(applyNo);
        }
    }

    private static Set<String> getAttributes(String applicationNo, ChromeOptions options) throws ParseException, IOException {
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://ipindiaonline.gov.in/eregister/eregister.aspx");
        webDriver.switchTo().frame("eregoptions");
        webDriver.findElement(By.id("btnviewdetails")).click();
        webDriver.switchTo().parentFrame();
        webDriver.switchTo().frame("showframe");
        webDriver.findElement(By.id("rdb_0")).click();
        webDriver.findElement(By.id("applNumber")).sendKeys(applicationNo);
        System.out.println("Enter captcha:");
        Scanner scan = new Scanner(System.in);
        String captcha = scan.nextLine();
        webDriver.findElement(By.id("captcha1")).sendKeys(captcha);
        webDriver.findElement(By.id("btnView")).click();
        webDriver.findElement(By.id("SearchWMDatagrid_ctl03_lnkbtnappNumber1")).click();
        Set<String> attributeNames = new MainPageAttributes(webDriver).getAttributeNames();
        webDriver.close();
        return attributeNames;
    }
}