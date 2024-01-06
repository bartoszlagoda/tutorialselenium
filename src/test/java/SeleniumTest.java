import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
    @Test
    public void openGooglePage(){
        // Wskazanie ścieżki do WebDrivera
        /*
        String path = "C:\\Users\\barte\\PycharmProjects\\tutorial_selenium\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        */
        //otwieranie przeglądarki Chrome (potrzebny jest zainstalowany chromedriver zgodny z wersją Chrome)
        WebDriver driver = new ChromeDriver();
        // wejście na stronę google.com
        driver.get("https://www.google.com");
    }
}
