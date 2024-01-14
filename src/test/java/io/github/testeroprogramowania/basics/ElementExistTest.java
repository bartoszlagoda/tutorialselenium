package io.github.testeroprogramowania.basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

        Assert.assertTrue(elementExist((By.tagName("p"))));
        Assert.assertFalse(elementExist((By.id("topSecret"))));

        Assert.assertTrue(elementExistBySize((By.tagName("p"))));
        Assert.assertFalse(elementExistBySize((By.id("topSecret"))));

        // czy element jest wyświetlony?
        Assert.assertFalse(driver.findElement(By.tagName("p")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.tagName("button")).isDisplayed()); // true

        // czy możliwa jest interakcja z przyciskiem
        Assert.assertTrue(driver.findElement(By.tagName("button")).isEnabled()); // true

        WebElement checkbox = driver.findElement(By.cssSelector("[type='checkbox']"));
        checkbox.click();
        // czy element jest zaznaczony?
        Assert.assertTrue(checkbox.isSelected());
    }

    // czy element istnieje na stronie - 1
    public boolean elementExist(By locator){
        try{
            driver.findElement(locator);
            return true;
        } catch(NoSuchElementException ex){
            return false;
        }
    }
    // czy element istnieje na stronie - 2
    public boolean elementExistBySize(By locator){
        return driver.findElements(locator).size() > 0;
    }
}
