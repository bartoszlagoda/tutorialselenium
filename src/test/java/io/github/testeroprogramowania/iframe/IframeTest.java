package io.github.testeroprogramowania.iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {
    @Test
    public void iframePageTest(){
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        WebDriver driver = new ChromeDriver();
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania - iframe
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        // 1 SPOSÓB NA OTWIERANIE IFRAME
        driver.switchTo().frame(0); // przejście do iframe
        driver.findElement(By.name("fname")).sendKeys("Bartosz");
        driver.switchTo().defaultContent(); // powrót do strony głównej
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        // 2 SPOSÓB NA OTWIERANIE IFRAME (rekomendowana metoda)
        WebElement iframe = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.name("fname")).sendKeys("Bartosz2");

        // 3 METODA NA OTWIERANIE IFRAME
        // da się skorzystać tylko przy posiadaniu atrybutu id albo name
    }
}
