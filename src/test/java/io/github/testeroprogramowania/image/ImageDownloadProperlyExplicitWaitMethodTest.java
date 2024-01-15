package io.github.testeroprogramowania.image;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class ImageDownloadProperlyExplicitWaitMethodTest {

    // WebDriverWait rozszerza FluentWait
    WebDriver driver;
    @Test
    public void webDriverWaitTest() {
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        driver = new ChromeDriver();

        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));

        driver.findElement(By.cssSelector("p")); // na stronie pojawia się dopiero po trzech sekundach
    }

    @Test
    public void fluentWaitTest(){
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        driver = new ChromeDriver();

        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        // (WebDriverWait to ma wbudowane)
        wait.ignoring(NoSuchElementException.class); // dodanie ignorowania NoSuchElementException
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1)); // co 1 sekundę odpytuj
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));

        driver.findElement(By.cssSelector("p")); // na stronie pojawia się dopiero po trzech sekundach
    }

    @Test
    public void expectedConditionTest(){
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        driver = new ChromeDriver();

        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        // deklaracja elementu przed Waitem
//        WebElement para = driver.findElement(By.cssSelector("pa")); // *

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        // (WebDriverWait to ma wbudowane)
        wait.ignoring(NoSuchElementException.class); // dodanie ignorowania NoSuchElementException
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1)); // co 1 sekundę odpytuj

//        wait.until(ExpectedConditions.visibilityOf(para)); // pojawi się błąd, ponieważ element nie występuje (*)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));

        driver.findElement(By.cssSelector("p")); // na stronie pojawia się dopiero po trzech sekundach
    }

    @Test
    public void ownConditionTest(){
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        driver = new ChromeDriver();

        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        waitForElementToExist(By.cssSelector("p"));
    }

    public void waitForElementToExist(By locator){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        // (WebDriverWait to ma wbudowane)
        wait.ignoring(NoSuchElementException.class); // dodanie ignorowania NoSuchElementException
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1)); // co 1 sekundę odpytuj
        // klasa anonimowa
       /*
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                List<WebElement> elements = driver.findElements(locator);
                if(elements.size() > 0){
                    System.out.println("Element jest na stronie");
                    return true;
                }else{
                    System.out.println("Elementu nie ma na stronie");
                    return false;
                }
            }
        });
*/
        wait.until((driver) -> {
            List<WebElement> elements = driver.findElements(locator);
            if(elements.size() > 0){
                System.out.println("Element jest na stronie");
                return true;
            }else{
                System.out.println("Elementu nie ma na stronie");
                return false;
            }
        });
    }
}
