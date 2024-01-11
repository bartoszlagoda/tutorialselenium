package io.github.testeroprogramowania.basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {
    @Test
    public void performAction(){
        //zainicjowanie chromedrivera (jeśli webdriver nie jest zainstalowany, manager go zainstaluje za nas)
        WebDriverManager.chromedriver().setup();
        // uruchomienie przeglądarki Chrome
        WebDriver driver = new ChromeDriver();
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        // przejście do strony testeroprogramowania
        driver.get("https://testeroprogramowania.github.io/selenium/");

        // przekierowanie poprzez kliknięcie w link do strony podstawowej
        WebElement basicTestPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicTestPageLink.getText()); // wyświetlenie tekstu linka
        basicTestPageLink.click();

        // wprowadzenie wartości do inputa 'First name"
        WebElement fnameInput = driver.findElement(By.id("fname"));
        fnameInput.sendKeys("Bartosz");

        // usunięcie defaultowej wartości z inputa i wprowadzenie swojej
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.clear(); // czyszczenie pola
        usernameInput.sendKeys("admin"); // wpisanie 'admin'
//        usernameInput.sendKeys(Keys.ENTER); // zasymulowanie wciśnięcia ENTER
        usernameInput.sendKeys(Keys.TAB); // przeniesienie do pola hasło poprzez sym. wcisniecia TAB

        // zaznaczenie checkboxa na stronie
        WebElement checkBoxClick = driver.findElement(By.cssSelector("[type='checkbox']"));
        checkBoxClick.click();

        // zaznaczenie radiobuttona 'Male'
        WebElement maleValueClick = driver.findElement(By.cssSelector("[value='male']"));
        maleValueClick.click();

        // wybranie samochodu spośród wszystkich do wyboru w select
        WebElement selectCar = driver.findElement(By.cssSelector("select"));

        // W selenium istnieje specjalna klasa dla wyboru konkretnego selectu
        Select cars = new Select(selectCar); // tworzenie obiektu klasy Select na select ze zmiennej selectCar
        cars.selectByIndex(2); // numerujemy od 0 w index
        cars.selectByVisibleText("Saab"); // można wpisać tekst selectu, który chcemy wybrać (wielkość liter nieważna!)

        List<WebElement> options = cars.getOptions(); // to są elementy, na których możemy działać z listy
        for(WebElement option : options){
            System.out.println(option.getText()); // wypisanie tekstu dla każdego elementu z listy
        } // metoda ta działa na każdy WebElement

        // kliknięcie w przycisk "Kliknij mnie!"
//        WebElement clickOnMeButton = driver.findElement(By.id("clickOnMe"));
//        clickOnMeButton.click();

    }
}
