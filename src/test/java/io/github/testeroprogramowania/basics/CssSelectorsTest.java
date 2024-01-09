package io.github.testeroprogramowania.basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorsTest {
    @Test
    public void findElements(){
        // Podstawowe selektory
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        WebDriver driver = new ChromeDriver();
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // <!-- znajdowanie ID w CSS -->
        // znajdź element o id=clickOnMe
        By cssId = By.cssSelector("#clickOnMe");
        WebElement clickOnMeId = driver.findElement(cssId);

        // <!-- znajdowanie CLASS w CSS -->
        // znajdź element o class=topSecret
        By paraHidden = By.cssSelector(".topSecret");
        WebElement topSecretClass = driver.findElement(paraHidden);

        // <!-- znajdowanie TAGÓW w CSS -->
        // znajdź element o tagu html <input>
        By byInputTag = By.cssSelector("input");
        WebElement inputTag = driver.findElement(byInputTag);
        inputTag.sendKeys("Drugi");

        // <!-- znajdowanie po atrybutach [NAME,CLASS] w CSS -->
        // znajdź element o name=fname
        By firstName = By.cssSelector("[name='fname']");
        WebElement cssFirstName = driver.findElement(firstName);
        By cssClass = By.cssSelector("[class='topSecret']");
        WebElement cssClassFindEl = driver.findElement(cssClass);
    }
}
