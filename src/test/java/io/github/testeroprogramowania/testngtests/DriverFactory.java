package io.github.testeroprogramowania.testngtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
            WebDriverManager.chromedriver().setup();
            // uruchomienie przeglądarki Chrome
            driver = new ChromeDriver();
        }
        return driver;
    }
}
