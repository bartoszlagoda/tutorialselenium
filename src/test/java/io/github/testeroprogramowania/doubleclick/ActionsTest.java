package io.github.testeroprogramowania.doubleclick;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;

public class ActionsTest {
    @Test
    public void uploadFileTest() throws IOException {
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        WebDriver driver = new ChromeDriver();
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        // klikanie prawym przyciskiem myszy
        Actions actions = new Actions(driver);
        actions.contextClick().perform(); // kliknięcie prawym przyciskiem myszy

        WebElement button = driver.findElement(By.id("bottom"));
        actions.doubleClick(button).perform(); // podwójne kliknięcie na element bottom
    }
}
