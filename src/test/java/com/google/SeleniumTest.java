package com.google;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {
    @Test
    public void openGooglePage(){
        //otwieranie przeglądarki Chrome (potrzebny jest zainstalowany chromedriver zgodny z wersją Chrome)
        WebDriver driver = getDriver("chrome");
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony google.com
        driver.get("https://www.google.com");
        // przepięcie się do okna z plikami cookie
//        driver.switchTo().frame(0);
        // znalezienie przycisku akceptacji cookie
        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Alle akzeptieren']"));
        agreeButton.click();
        // powrót do pierwotnego okna
        driver.switchTo().defaultContent();
        // zlokalizowanie pola do wpisywania frazy do wyszukiwania
        WebElement searchField = driver.findElement(By.name("q"));
        // wpisanie wyszukiwanej frazy 'Selenium'
        searchField.sendKeys("Selenium");
        // zasymulowanie kliknięcia przycisku Enter
        searchField.sendKeys(Keys.ENTER);
        // znalezienie rezultatu
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));
        // asercja sprawdzająca czy webelement result jest wyświetlony
        Assert.assertTrue(result.isDisplayed());
        driver.close();
    }

    public WebDriver getDriver(String browser) throws IllegalArgumentException{
        if(browser.equals("chrome")){
            return new ChromeDriver();
        }else if(browser.equals("edge")){
            return new EdgeDriver();
        }
        throw new IllegalArgumentException("Allowed values are ['chrome','edge']");
    }
}
