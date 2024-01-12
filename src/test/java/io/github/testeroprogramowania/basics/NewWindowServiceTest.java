package io.github.testeroprogramowania.basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowServiceTest {
    @Test
    public void testNewWindow(){
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        WebDriver driver = new ChromeDriver();
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/basics");

        String currentWindow = driver.getWindowHandle();

        // obsługa przycisku "Click me"
        WebElement buttClickMe = driver.findElement(By.id("newPage"));
        buttClickMe.click();

        //WebElement agreeButton = driver.findElement(By.className("QS5gu sy4vM"));
        //agreeButton.click();

        // Stworzenie zbioru otwartych okien przeglądarki
        Set<String> windowNames = driver.getWindowHandles();

        // sprawdzenie czy jakaś nazwa okna jest inna od tego, w którym jesteśmy i przepięcie do tego okna
        for(String window : windowNames){
            if(!window.equals(currentWindow)){
                // przepięcie się do nowego okna
                driver.switchTo().window(window);
            }
        }
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[text()='de']")).click(); // przycisk zmiany jezyka
        driver.findElement(By.xpath("//*[@id='tbTubd']/div/li[34]")).click(); // wybierz 'polski'
        WebElement agreeButton = driver.findElement(By.xpath("//*[@id='L2AGLb']/div[contains(text(),'Zaakceptuj')]")); // zaakceptuj cookie
        agreeButton.click();
        driver.findElement(By.name("q")).sendKeys("Selenium");
        // powrót do pierwszego okna
        driver.switchTo().window(currentWindow);
        driver.findElement(By.name("fname")).sendKeys("Bartosz");
        //buttClickMe.click(); // nastąpi przekierowanie na nowe okno przeglądarki ze stroną google
    }
}
