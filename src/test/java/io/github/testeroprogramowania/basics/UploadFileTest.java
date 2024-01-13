package io.github.testeroprogramowania.basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadFileTest {
    @Test
    public void uploadFileTest() throws IOException {
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        WebDriver driver = new ChromeDriver();
        // tworzenie zmiennej dla randomowej liczby
        int randomNumber = (int) (Math.random()*1000);
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        // Zrobienie screenshota dla efektu przed
        TakesScreenshot screenshot = (TakesScreenshot) driver; // castowanie drivera na TakeScreenshot
        File beforeUploadFile = screenshot.getScreenshotAs(OutputType.FILE);
        String fileNamebeforeUpload = "beforeUpload" + randomNumber + ".png"; // tworzenie nazwy dla każdego kolejnego screenshota
        FileUtils.copyFile(beforeUploadFile,new File("src/test/resources/screenshots/" + fileNamebeforeUpload));

        // wybór inputu do wprowadzania pliku
        WebElement uploadFileInp = driver.findElement(By.id("myFile"));
        uploadFileInp.sendKeys("C:\\Users\\barte\\OneDrive\\Pulpit\\Github_Repositories\\tutorialselenium\\tutorialselenium\\src\\test\\resources\\sample.json");

        // Tworzenie screenshota
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE); // tworzenie obiektu klasy File dla screenshota, który jest enumem
        String fileNameAfterUpload = "AfterUpload" + randomNumber + ".png"; // tworzenie nazwy dla każdego kolejnego screenshota
        FileUtils.copyFile(srcFile,new File("src/test/resources/screenshots/" + fileNameAfterUpload)); // copyFile potrzebuje wyjątku

    }
}
