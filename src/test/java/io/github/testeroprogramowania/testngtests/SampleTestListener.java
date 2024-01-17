package io.github.testeroprogramowania.testngtests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class SampleTestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("I am starting test");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        WebDriver driver = DriverFactory.getDriver();
        int randomNumber = (int) (Math.random()*1000);
        System.out.println("I am taking screenshot");
        TakesScreenshot screenshot = (TakesScreenshot) driver; // castowanie drivera na TakeScreenshot
        File beforeUploadFile = screenshot.getScreenshotAs(OutputType.FILE);
        String fileNamebeforeUpload = "failedTest" + randomNumber + ".png"; // tworzenie nazwy dla każdego kolejnego screenshota
        try {
            FileUtils.copyFile(beforeUploadFile,new File("src/test/resources/screenshots/" + fileNamebeforeUpload));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }
