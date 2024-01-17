package io.github.testeroprogramowania.testngtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

@Listeners(value = {SampleTestListener.class})
public class FirstTest extends BaseTest{

    // WebDriverWait rozszerza FluentWait

    @Test
    public void firstTest(){

        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        // (WebDriverWait to ma wbudowane)
        wait.ignoring(NoSuchElementException.class); // dodanie ignorowania NoSuchElementException
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1)); // co 1 sekundę odpytuj
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        waitForElementToExist(By.cssSelector("p"));

        WebElement para = driver.findElement(By.cssSelector("p"));
        String paraText = driver.findElement(By.cssSelector("p")).getText();

        // Przykład asercji twardych

        Assert.assertEquals(para.isDisplayed(),true);
        Assert.assertTrue(para.isDisplayed()); // lepsze niz to u góry

        Assert.assertTrue(para.getText().startsWith("Dopiero"));
        Assert.assertFalse(para.getText().startsWith("Pojawiłem"));

        Assert.assertEquals(para.getText(),"Dopiero się pojawiłem!");
        Assert.assertEquals(para.getText(),"Dopiero","Teksty sa rozne."); // doda naszą wiadomość do błędu

        System.out.println("Klasa: FirstTest, Metoda: firstTest");
    }

    @Test
    public void softAssertionTest(){

        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        // (WebDriverWait to ma wbudowane)
        wait.ignoring(NoSuchElementException.class); // dodanie ignorowania NoSuchElementException
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1)); // co 1 sekundę odpytuj
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        waitForElementToExist(By.cssSelector("p"));

        WebElement para = driver.findElement(By.cssSelector("p"));

        // Przykład asercji miękkich (softAssert)
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(para.isDisplayed(),true);
        softAssert.assertEquals(para.getText(),"Dopiero","Teksty sa rozne."); // doda naszą wiadomość do błędu
        softAssert.assertTrue(para.isDisplayed()); // lepsze niz to u góry

        softAssert.assertTrue(para.getText().startsWith("Dopiero"));
        softAssert.assertFalse(para.getText().startsWith("Pojawiłem"));
        softAssert.assertEquals(para.getText(),"Dopiero się","Teksty sa rozne."); // doda naszą wiadomość do błędu

        softAssert.assertEquals(para.getText(),"Dopiero się pojawiłem!");

        System.out.println("Klasa: FirstTest, Metoda: firstTest");
        //softAssert.assertAll();
    }

    @Test
    public void secondTest(){

        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        // (WebDriverWait to ma wbudowane)
        wait.ignoring(NoSuchElementException.class); // dodanie ignorowania NoSuchElementException
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1)); // co 1 sekundę odpytuj
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        waitForElementToExist(By.cssSelector("p"));

        String paraText = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertEquals(paraText,"Dopiero się pojawiłem!");
        System.out.println("Klasa: FirstTest, Metoda: secondTest");

        driver.quit();
    }

    @Test
    public void thirdTest(){

        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        // (WebDriverWait to ma wbudowane)
        wait.ignoring(NoSuchElementException.class); // dodanie ignorowania NoSuchElementException
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1)); // co 1 sekundę odpytuj
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        waitForElementToExist(By.cssSelector("p"));

        String paraText = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertEquals(paraText,"Dopiero się pojawiłem!");
        System.out.println("Klasa: FirstTest, Metoda: secondTest");

        driver.quit();
    }

    public void waitForElementToExist(By locator){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        // (WebDriverWait to ma wbudowane)
        wait.ignoring(NoSuchElementException.class); // dodanie ignorowania NoSuchElementException
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1)); // co 1 sekundę odpytuj
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
