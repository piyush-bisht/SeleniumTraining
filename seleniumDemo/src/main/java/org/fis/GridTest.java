package org.fis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class GridTest {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.137.1:4444"),chromeOptions);
        driver.get("https://www.google.co.in");

        InternetExplorerOptions internetExplorerOptions =new InternetExplorerOptions();
        WebDriver driver2=new RemoteWebDriver(new URL("http://192.168.137.1:4444"),internetExplorerOptions);
        driver2.get("https://www.yahoo.com");

        FirefoxOptions firefoxOptions=new FirefoxOptions();
        WebDriver driver3=new RemoteWebDriver(new URL("http://192.168.137.1:4444"),firefoxOptions);
        driver3.get("https://www.fis.com");

    }
}
