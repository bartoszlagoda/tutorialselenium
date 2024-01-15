package io.github.testeroprogramowania.image;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImageDownloadProperlySleepMethodTest {

    WebDriver driver;
    @Test
    public void waitTest() throws InterruptedException {
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // przez 10 sekund sprawdzanie czy element jest na stronie
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();
        Thread.sleep(5000); // 5000 ms -> 5 s
        driver.findElement(By.cssSelector("p")); // na stronie pojawia się dopiero po trzech sekundach
    }
}
