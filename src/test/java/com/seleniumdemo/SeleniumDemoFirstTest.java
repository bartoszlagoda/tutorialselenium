package com.seleniumdemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
* 1. Przejście na stronę www.seleniumdemo.com
* 2. Wybierz opcję 'Shop'
* 3. Zweryfikuj czy w sklepie znajduje się produkt Java Selenium WebDriver
* */
public class SeleniumDemoFirstTest {
    @Test
    public void findSeleniumTutorial(){
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        WebDriver driver = new ChromeDriver();
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony seleniumdemo
        driver.get("http://seleniumdemo.com/");
        // znalezienie elementu Shop na stronie
        WebElement shopElementInMenu = driver.findElement(By.xpath("//span[text()='Shop']"));
        // kliknięcie w znaleziony element Shop
        shopElementInMenu.click();
        // znalezienie elementu Java Selenium Webdriver
        WebElement seleniumProduct = driver.findElement(By.xpath("//h2[text()='Java Selenium WebDriver']"));
        // przetestowanie czy przycisk przypisany do zmiennej seleniumProduct znajduje się na stronie
        Assert.assertTrue(seleniumProduct.isDisplayed());
        // zamknięcie strony
        driver.close();
    }
}
