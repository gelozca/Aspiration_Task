import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SpendAndSaveSteps extends BaseTest{

    @Given("The user navigate to the Aspiration Home Page")
    public void theUserNavigateToTheAspirationHomePage() {
        startTest("chrome");
    }

    @When("Click on the Spend & Save link at the top of the home page")
    public void clickOnTheSpendSaveLinkAtTheTopOfTheHomePage() {
        AspirationHomePage homePage = new AspirationHomePage(driver);
        homePage.clickSpendSave();
    }

    @Then("Aspiration and Aspiration Plus should be displayed")
    public void aspirationAndAspirationPlusShouldBeDisplayed() {
        SpendAndSavePage spendAndSavePage = new SpendAndSavePage(driver);
        Assert.assertTrue(spendAndSavePage.hasCardProducts());
    }

    @And("Click on the Get Aspiration link")
    public void clickOnTheGetAspirationLink() {
        SpendAndSavePage spendAndSavePage = new SpendAndSavePage(driver);
        spendAndSavePage.clickGetAspirations();
    }

    @Then("A modal containing an input field for an an email address should be displayed")
    public void aModalContainingAnInputFieldForAnAnEmailAddressShouldBeDisplayed() {
        SpendAndSavePage spendAndSavePage = new SpendAndSavePage(driver);
        Assert.assertTrue(spendAndSavePage.hasGetAspirationModal());
    }

    @And("Click on the Get Aspiration Plus link")
    public void clickOnTheGetAspirationPlusLink() {
        SpendAndSavePage spendAndSavePage = new SpendAndSavePage(driver);
        spendAndSavePage.clickGetAspirationPlus();
    }

    @Then("A modal with monthly and yearly plans should be displayed")
    public void aModalWithMonthlyAndYearlyPlansShouldBeDisplayed() {
        SpendAndSavePage spendAndSavePage = new SpendAndSavePage(driver);
        Assert.assertTrue(spendAndSavePage.hasGetAspirationPlusModal());
    }

    @Then("Yearly radio option should display yearly price")
    public void yearlyRadioOptionShouldDisplayYearlyPrice() {
        SpendAndSavePage spendAndSavePage = new SpendAndSavePage(driver);
        Assert.assertTrue(spendAndSavePage.hasYearlyPrice());
    }

    @Then("Monthly radio option should display monthly price")
    public void monthlyRadioOptionShouldDisplayMonthlyPrice() {
        SpendAndSavePage spendAndSavePage = new SpendAndSavePage(driver);
        Assert.assertTrue(spendAndSavePage.hasMonthlyPrice());
    }
}
