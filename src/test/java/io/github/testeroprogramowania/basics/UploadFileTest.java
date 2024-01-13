package io.github.testeroprogramowania.basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadFileTest {
    @Test
    public void uploadFileTest(){
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        WebDriver driver = new ChromeDriver();
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        // wybór inputu do wprowadzania pliku
        WebElement uploadFileInp = driver.findElement(By.id("myFile"));
        uploadFileInp.sendKeys("C:\\Users\\barte\\OneDrive\\Pulpit\\Github_Repositories\\tutorialselenium\\tutorialselenium\\src\\test\\resources\\sample.json");
    }
}
