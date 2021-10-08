import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SpendAndSavePage extends BasePage {
    public SpendAndSavePage(WebDriver driver) {
        super(driver);
    }

    private static final String[] cardProducts = {"Aspiration", "Aspiration Plus"};

    private By tblPlans = By.xpath("//*[@class=\"plan-content\"]");
    private By btnGetAspiration = By.xpath("//*[@ng-click=\"getAspirationOriginal()\"]");
    private By txtGetAspirationEmail = By.id("join-waitlist-input");
    private By btnGetAspirationPlus = By.xpath("//*[@ng-click=\"getAspirationPlus()\"]");
    private By rdoYearly = By.xpath("//*[@class=\"option selected\"]");
    private By rdoMonthly = By.xpath("//*[@class=\"option\"]");

    public boolean hasCardProducts() {
        List<WebElement> products = findElements(tblPlans);
        List<String> productsName = getContentDetails(products, "h2");

        for (String card : cardProducts) {
            if (productsName.stream().noneMatch(name -> name.equals(card))) {
                return false;
            }
        }
        return true;
    }

    public boolean hasGetAspirationModal() {
        return hasElement(txtGetAspirationEmail);
    }

    public boolean hasGetAspirationPlusModal() {
        if (hasYearlyOption()) {
            if (hasMonthlyOption()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasYearlyPrice() {
        String x = findElement(rdoYearly).findElement(By.tagName("b")).getText();
        if (findElement(rdoYearly).findElement(By.tagName("b")).getText().equals("$71.88")) {
            return true;
        }

        return false;
    }

    public boolean hasMonthlyPrice() {
        if (findElement(rdoMonthly).findElement(By.tagName("b")).getText().equals("$7.99")) {
            return true;
        }
        return false;
    }

    private boolean hasMonthlyOption() {
        return hasElement(rdoMonthly);
    }

    private boolean hasYearlyOption() {
        return hasElement(rdoYearly);
    }

    public void clickGetAspirations() {
        click(btnGetAspiration);
    }

    public void clickGetAspirationPlus() {
        click(btnGetAspirationPlus);
    }

    public List<String> getContentDetails(List<WebElement> rows, String tag) {
        List<String> contentDetails = new ArrayList<>();

        for (WebElement row : rows) {
            WebElement rowDetail = row.findElement(By.tagName(tag));
            contentDetails.add(rowDetail.getText());
        }
        return contentDetails;
    }
}
