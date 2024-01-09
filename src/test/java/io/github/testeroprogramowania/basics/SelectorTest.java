package io.github.testeroprogramowania.basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {
    @Test
    public void findElements(){
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        WebDriver driver = new ChromeDriver();
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // znajdź element o id=clickOnMe
        WebElement clickOnMeButton = driver.findElement(By.id("clickOnMe"));

        // znajdź element o name=fname
        By firstName = By.name("fname");
        WebElement firstNameInput = driver.findElement(firstName);

        // znajdź element o class=topSecret
        By paraHidden = By.className("topSecret");
        driver.findElement(paraHidden);

        // znajdź element o tagu html <input>
        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator); // zwróci pierwszy input na stronie
        // wpisanie czegoś do pierwszego znalezionego inputa
        input.sendKeys("Pierwszy");
        // utworzenie listy wszystkich inputów na stronie
        List<WebElement> inputs = driver.findElements(inputLocator);
        // wydrukowanie na ekranie liczby inputów na stronie
        System.out.println(inputs.size());

        // znajdź link w3schools na stronie po tekście opisującym ten link
        WebElement w3schoolsLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
        // znajdź link w3schools na stronie po części tekstu opisującego ten link
        WebElement w3schoolsPartLink = driver.findElement(By.partialLinkText("W3Schools"));

        // znajdź wszystkie tagi występujące na stronie
        By all = By.cssSelector("*");
        driver.findElements(all);

        // wszystkie elementy ul znajdujące się w div
        By ulInDiv = By.cssSelector("div ul");
        // wszystkie elementy tr znajdujące się w table -> tbody
        By trInTable = By.cssSelector("table tr");
        By trInBody = By.cssSelector("tbody tr");
        driver.findElement(ulInDiv);
        driver.findElement(trInTable);
        driver.findElement(trInBody);

        // tylko pierwszy element ul w div i tr w tbody
        By firstChildUlInDiv = By.cssSelector("div > ul");
        By firstChildTrInTbody = By.cssSelector("tbody > tr");
        driver.findElement(firstChildUlInDiv);
        driver.findElement(firstChildTrInTbody);

        // znajdź pierwszy selektor <form> który znajduje się od razu po <label>
        driver.findElement(By.cssSelector("label + form"));
        // znajdź wszystkie selektory <form>, które znajdują się po <label>
        driver.findElement(By.cssSelector("label ~ form"));
        driver.close();
    }
}
