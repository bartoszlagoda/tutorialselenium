package io.github.testeroprogramowania.basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorsTest {
    @Test
    public void findElements(){
        // Podstawowe selektory
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        WebDriver driver = new ChromeDriver();
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // <!-- znajdowanie ID w CSS -->
        // znajdź element o id=clickOnMe
        By cssId = By.cssSelector("#clickOnMe");
        WebElement clickOnMeId = driver.findElement(cssId);

        // <!-- znajdowanie CLASS w CSS -->
        // znajdź element o class=topSecret
        By paraHidden = By.cssSelector(".topSecret");
        WebElement topSecretClass = driver.findElement(paraHidden);

        // <!-- znajdowanie TAGÓW w CSS -->
        // znajdź element o tagu html <input>
        By byInputTag = By.cssSelector("input");
        WebElement inputTag = driver.findElement(byInputTag);
        inputTag.sendKeys("Drugi");

        // <!-- znajdowanie po atrybutach [NAME,CLASS] w CSS -->
        // znajdź element o name=fname
        By firstName = By.cssSelector("[name='fname']");
        WebElement cssFirstName = driver.findElement(firstName);
        By cssClass = By.cssSelector("[class='topSecret']");
        WebElement cssClassFindEl = driver.findElement(cssClass);

        // <!-- znajdowanie po atrybutach NAME w inputach w CSS -->
        driver.findElement(By.cssSelector("input[name='fname']"));

        // <!-- znajdowanie po atrybutach NAME zawierających name w swoich nazwach w CSS -->
        driver.findElement(By.cssSelector("[name*='name']"));

        // <!-- znajdowanie po atrybutach NAME zaczynających się w swoich nazwach od fna w CSS -->
        driver.findElement(By.cssSelector("[name^='fna']"));

        // <!-- znajdowanie po atrybutach NAME konczacych się w swoich nazwach na me w CSS -->
        driver.findElement(By.cssSelector("[name$='me']"));

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

        // rodzice i dzieci w liście
        // pierwsze dziecko tagu nadrzędnego
        driver.findElement(By.cssSelector("li:first-child"));
        // ostatnie dziecko tagu nadrzędnego
        driver.findElement(By.cssSelector("li:last-child"));
        // któreś z kolei dziecko tagu nadrzędnego (numerujemy od 1)
        driver.findElement(By.cssSelector("li:nth-child(1)"));
        driver.close();
    }
}
