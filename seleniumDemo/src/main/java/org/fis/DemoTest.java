package org.fis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoTest {
    public static void main(String[] args) {

        //Driver Setup
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //Automating Task
        driver.get("https://www.google.co.in");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        String title=driver.getTitle();
        System.out.println("TITLE IS : "+title);

        //Sending Information to be searched
        WebElement inputBox= driver.findElement(By.name("q"));
        WebElement searchButton=driver.findElement(By.name("btnK"));
        inputBox.sendKeys("FIS"+ Keys.ENTER);
//        searchButton.click();

        driver.close();



    }
}
