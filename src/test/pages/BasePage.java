import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement findElement(By element) {
        return waitForElement(element);
    }

    protected WebElement waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void click(By element) {
        this.findElement(element).click();
    }

    protected void sendKeys(By element, String text) {
        findElement(element).sendKeys(text);
    }

    protected List<WebElement> findElements(By element) {
        waitForElement(element);
        return driver.findElements(element);
    }

    protected boolean hasElement(By element){
        if(this.findElements(element).stream().count() > 0){
            return true;
        }
        return false;
    }

    protected void selectElementByText(By element, String text) {
        Select selectObject = new Select(findElement(element));
        selectObject.selectByVisibleText(text);
    }


    protected void selectElementByValue(By element, String value) {
        Select selectObject = new Select(findElement(element));
        selectObject.selectByValue(value);
    }

    protected void selectRadioButton(By element, String value){
        List<WebElement> radioList = findElements(element);
        for(WebElement radioButton: radioList){
            if(radioButton.getAttribute("value").equals(value)){
                radioButton.click();
                break;
            }
        }
    }
}
