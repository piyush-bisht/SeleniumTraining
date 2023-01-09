package org.fis;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    @DataProvider(name="dp")
    public Object[][] createData()
    {
        return new Object[][]{
                {"student", "Password123"},
                {"student", "Password1234"},
                {"students", "Password123"},
                {"student", "Password1235"},

        };
    }


    @Test(dataProvider = "dp")
    public void LoginTestValidation(String username,String password){

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
    try {
        System.out.println("USING "+username+" Password: "+password);


        driver.get("https://practicetestautomation.com/practice-test-login/");


        WebElement emailInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();

        String expectedTitle = "Logged In Successfully | Practice Test Automation";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    finally{
            driver.close();
    }

    }
}
