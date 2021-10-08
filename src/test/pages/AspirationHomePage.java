import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AspirationHomePage extends BasePage{
    public AspirationHomePage(WebDriver driver) {
        super(driver);
    }

    private By lnkSpendSave = By.partialLinkText("Spend");

    protected void clickSpendSave(){
        driver.navigate().to(findElement(lnkSpendSave).getAttribute("href"));
    }
}
