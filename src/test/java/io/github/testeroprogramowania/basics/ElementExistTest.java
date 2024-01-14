package io.github.testeroprogramowania.basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementExistTest {

    WebDriver driver;
    @Test
    public void elementExist(){
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        driver = new ChromeDriver();
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        System.out.println(elementExist((By.tagName("p"))));
        System.out.println(elementExist((By.id("topSecret"))));

        System.out.println(elementExistBySize((By.tagName("p"))));
        System.out.println(elementExistBySize((By.id("topSecret"))));
    }

    public boolean elementExist(By locator){
        try{
            driver.findElement(locator);
            return true;
        } catch(NoSuchElementException ex){
            return false;
        }
    }
    public boolean elementExistBySize(By locator){
        return driver.findElements(locator).size() > 0;
    }
}
