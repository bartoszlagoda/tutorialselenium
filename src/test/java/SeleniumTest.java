import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
    @Test
    public void openGooglePage(){
        //otwieranie przeglądarki Chrome (potrzebny jest zainstalowany chromedriver zgodny z wersją Chrome)
        WebDriver driver = getDriver("edge");
        driver.get("https://www.google.com/");
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
