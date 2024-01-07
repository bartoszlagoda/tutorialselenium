import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
    @Test
    public void openGooglePage(){
        //otwieranie przeglądarki Chrome (potrzebny jest zainstalowany chromedriver zgodny z wersją Chrome)
        WebDriver driver = getDriver("chrome");
        // otworzenie okna przeglądarki na pełnym ekranie
        driver.manage().window().maximize();
        Dimension dimension = new Dimension(200,200);
        driver.manage().window().setSize(dimension);
        driver.get("https://www.google.com");
        // utworzenie egzekutora JavaScript
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('https://www.testeroprogramowania.pl','blank','height=200','width=200')");


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
