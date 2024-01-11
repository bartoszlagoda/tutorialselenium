package io.github.testeroprogramowania.basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XPathSelectorsTest {
    @Test
    public void findElements() {
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        WebDriver driver = new ChromeDriver();
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // button o id clickOnMe
        By cssId = By.xpath("/html/body/button[@id='clickOnMe']");
        WebElement clickOnMeId = driver.findElement(cssId);

        // znajdź element o name=fname
        By firstName = By.xpath("//input[@name='fname']");
        WebElement firstNameInput = driver.findElement(firstName);

        // znajdź element o class=topSecret
        By paraHidden = By.xpath("//p[@class='topSecret']");
        driver.findElement(paraHidden);

        // w CSSSelector nie ma takiej opcji
        // znajdź link w3schools na stronie po tekście opisującym ten link
        driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));

        // w CSSSelector nie ma takiej opcji
        // znajdź link w3schools na stronie po fragmencie tekstu opisującym ten link
        driver.findElement(By.xpath("//a[contains(text(),'Visit')]"));

        driver.findElement(By.xpath("/html/body/table/tbody/tr"));
        // znak podwójnego slash pozwala na pominięcie wszystkich pośrednich ścieżek
        driver.findElement(By.xpath("/html/body/table//tbody/tr"));
        driver.findElement(By.xpath("/html/body/div/ul"));
        driver.findElement(By.xpath("//ul"));

        // Jak korzystać z indeksów w XPath?
        // lokalizowanie elementu o dowolnym tagu - zwrócenie wszystkich elementów na stronie
        driver.findElement(By.xpath("//*"));
        // lokalizowanie pierwszego elementu o dowolnym tagu w strukturze - czyli html
        driver.findElement(By.xpath("*"));
        driver.findElement(By.xpath("/*"));
        // lokalizowanie pierwszego elementu typu input
        driver.findElement(By.xpath("(//input)[1]"));
        // lokalizowanie ostatniego elementu typu input (jeśli nie znamy ilości inputów na stronie)
        // lepsze rozwiązanie niż w selektorach CSS
        driver.findElement(By.xpath("(//input)[last()]"));
        // lokalizowanie ostatniego elementu typu button, który ma id (jeśli nie znamy ilości inputów na stronie)
        driver.findElement(By.xpath("(//button[@id])[last()]"));
        //lokalizowanie wszystkich elementów o tagu name = fname
        driver.findElement(By.xpath("(//*[@name='fname']"));
        //lokalizowanie wszystkich elementów posiadających tag name = fname
        driver.findElement(By.xpath("(//*[@name]"));



    }
}
