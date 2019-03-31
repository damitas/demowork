
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class CreateSteps {

    @When("I \"([^\"]*)\" the computer with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void enterComputerDetails(String action, String computerName, String introducedDate, String discontinuedDate, String companyName) {
        BasePageObject basePO = new BasePageObject();
        basePO.createUpdateComputer(action,computerName,introducedDate,discontinuedDate,companyName);
    }

    @When("the computer name field errors$")
    public void computerNameValidationError() {
            CreatePageObject createPO = new CreatePageObject();
            assertTrue(createPO.getErrorElement().getText().contains("Computer name"));
    }

    @When("the date fields error$")
    public void dateValidationError() {
        CreatePageObject createPO = new CreatePageObject();
        assertTrue(createPO.getErrorElements().get(1).getText().contains("Introduced date"));
        assertTrue(createPO.getErrorElements().get(2).getText().contains("Discontinued date"));
    }

    @When("I enter the invalid dates \"([^\"]*)\" \"([^\"]*)\"$")
    public void datesValidationError(String introducedDate, String discontinuedDate) {
        CreatePageObject createPO = new CreatePageObject();
        createPO.getIntroducedDateElement().sendKeys(introducedDate);
        createPO.getDiscontinuedDateElement().sendKeys(discontinuedDate);
    }
}
