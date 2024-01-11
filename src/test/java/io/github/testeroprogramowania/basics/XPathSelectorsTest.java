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
        driver.findElement(By.xpath("//*[@name='fname']"));
        //lokalizowanie wszystkich elementów posiadających tag name = fname
        driver.findElement(By.xpath("//*[@name]"));

        // Jak lokalizować elementy zwracając uwagę na wartość atrybutu jakiegoś znacznika
        driver.findElement(By.xpath("//button[@id='clickOnMe']"));
        //szukamy jakiegoś buttona, dla którego wartość posiadanego id nie równa się clickOnMe
        driver.findElement(By.xpath("//button[@id!='clickOnMe']"));
        //szukamy jakiegoś elementu, dla którego wartość posiadanego id nie równa się clickOnMe
        driver.findElement(By.xpath("//*[@id!='clickOnMe']"));
        // jakiś element, który zawiera atrybut name zawierający ciąg znaków 'ame' w swojej nazwie
        driver.findElement(By.xpath("//*[contains(@name,'ame')]"));
        // jakiś element, który zawiera atrybut name zaczynający się od pewnego ciągu znaków
        driver.findElement(By.xpath("//*[starts-with(@name,'fnam')]"));
        // jakiś element, który zawiera atrybut name kończący się pewnym ciągiem znaków
//        driver.findElement(By.xpath("//*[ends-with(@name,'me')]")); // może nie działać na pewnych wersjach
        // xPath -> numeracja od 1, java -> numeracja od 0
        driver.findElement(By.xpath("//*[substring(@name,string-length(@name) - string-length('ame')+1)='ame']"));

        // ------------------ Dzieci, rodzice, wstępni, zstępni ------------------
        // dziecko znacznika div, którym jest ul
        driver.findElement(By.xpath("//div/child::ul"));
        // wszystkie tagi ul w div
        driver.findElement(By.xpath("//div//ul"));
        // wszystkie dzieci (zstępni) ul diva
        driver.findElement(By.xpath("//div/descendant::ul"));
        // wszystkie dzieci (zstępni) diva
        driver.findElement(By.xpath("//div/descendant::*"));
        // wszystkie tagi, które są nad div
        driver.findElement(By.xpath("//div/ancestor::*"));
        // tag body, który jest nad div
        driver.findElement(By.xpath("//div/ancestor::body"));
        // bezpośredni rodzic dla div
        driver.findElement(By.xpath("//div/.."));
        // bezpośredni rodzic dla div i kolejne odwołanie do następnego rodzica
        driver.findElement(By.xpath("//div/../.."));
        // --- wybieranie tagów występujących po naszym elemencie ---
        // wszystkie tagi następujące po obrazku 'img'
        driver.findElement(By.xpath("//img/following::*"));
        // tagi na tym samym poziomie co 'img'
        driver.findElement(By.xpath("//img/following-sibling::*"));
        // tagi przed tagiem 'img'
        driver.findElement(By.xpath("//img/preceding::*"));

        // ----------- Lokalizowanie pewnych elementów w jednym wyszukiwaniu -----------
        // szukanie jednocześnie linków i inputów
        driver.findElement(By.xpath("//a | //input"));
        // szukanie jednocześnie linków i divów
        driver.findElement(By.xpath("//a | //div"));
        // szukanie jednocześnie spełnionych dwóch warunków: name i id równe fname
        driver.findElement(By.xpath("//input[@name='fname' and @id='fname']"));
        // szukanie jednego spełnionego warunku z dwóch warunków: name lub id równe fname
        driver.findElement(By.xpath("//input[@name='fname' or @id='fnam']"));


    }
}
