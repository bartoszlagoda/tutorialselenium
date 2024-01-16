package io.github.testeroprogramowania.testngtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }

    @BeforeTest // uruchomienie przed pierwszym testem
    public void beforeTest(){
        System.out.println("I am running before Test");
    }
    @BeforeMethod // uruchomione przed każdą metodą testową
    public void beforeMethod(){
        System.out.println("I am running before method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }
    @AfterTest // uruchomienie po ostatnim teście
    public void afterTest(){
        System.out.println("I am running after Test");
        driver.quit();
    }

    @AfterMethod// uruchomione po każdej metodzie testowej
    public void afterMethod(){
        System.out.println("I am running after method");

    }
}
