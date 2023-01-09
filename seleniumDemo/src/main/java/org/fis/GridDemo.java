package org.fis;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridDemo {

    WebDriver driver;
    String baseURL, nodeURL;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        baseURL = "https://www.fisglobal.com/en";
        nodeURL = "http://192.168.137.1:4444/";
        ChromeOptions chromeOptions=new ChromeOptions();


        driver = new RemoteWebDriver(new URL(nodeURL), chromeOptions);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
    @Test
    public void sampleTest() {
        driver.get(baseURL);


        if(driver.getTitle().contains("FIS"))
            Assert.assertTrue(true,"Correct Site Found");
        else
            Assert.assertTrue(false,"Wrong Site");


    }
}
