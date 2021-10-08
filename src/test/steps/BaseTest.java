import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;

    public void startTest(String browser) {

        switch (browser) {
            case "chrome":
                BasicConfigurator.configure();
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                BasicConfigurator.configure();
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.navigate().to("https://www.aspiration.com/");
    }
    @After
    public  void finishTest() {
        driver.quit();
    }
}
