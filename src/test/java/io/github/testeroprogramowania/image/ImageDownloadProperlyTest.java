package io.github.testeroprogramowania.image;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageDownloadProperlyTest {

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
        driver.get("https://testeroprogramowania.github.io/selenium/image.html");

        // sprawdzenie czy obrazek pojawia się na stronie
        WebElement image = driver.findElement(By.tagName("img"));
        String height = image.getAttribute("naturalHeight");
        System.out.println(height);

        Assert.assertEquals(height,"0");
    }
}
