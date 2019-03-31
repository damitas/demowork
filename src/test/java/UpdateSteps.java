import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
import java.util.UUID;
import java.util.Random;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class UpdateSteps {

    @Then("^the edit computer screen is loaded for a unique computer name$")
    public void clickOnUniqueComputerName() {
        //ensures that the computer that I am searching for always exists and is unique

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        BasePageObject basePO = new BasePageObject();
        basePO.createUniqueComputerAndLoadEditScreen(randomUUIDString,"2019-03-31", "2020-03-31", "Apple Inc.");

        //click on the result
        ReadPageObject readPO = new ReadPageObject();
        readPO.getUniqueResultElement(randomUUIDString).click();
    }

    @Then("^the edit computer screen is verified for a unique computer name$")
    public void verifyUniqueComputerName() {
        //ensures that the computer that I am verifying always exists and is unique

        //create a unique computer name
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        String introducedDate = "2019-03-01";
        String discontinuedDate = "2020-03-01";
        String companyName = "Apple Inc.";

        BasePageObject basePO = new BasePageObject();
        basePO.createUniqueComputerAndLoadEditScreen(randomUUIDString ,introducedDate,discontinuedDate,companyName);

        //click on the result
        ReadPageObject readPO = new ReadPageObject();
        readPO.getUniqueResultElement(randomUUIDString).click();

        //verify values on edit screen match newly created record
        CreatePageObject createPO = new CreatePageObject();

        assertEquals("Computer name does not match",createPO.getComputerNameElement().getAttribute("value"),randomUUIDString);
        assertEquals("Introduced Date does not match",createPO.getIntroducedDateElement().getAttribute("value"),introducedDate);
        assertEquals("Discontinued Date does not match",createPO.getDiscontinuedDateElement().getAttribute("value"),discontinuedDate);
        Select companyNameDropDown = new Select(createPO.getCompanyNameElement());
        assertEquals("Company name does not match",companyNameDropDown.getFirstSelectedOption().getText(),companyName);
    }

    @When("I clear the computer name field$")
    public void computerNameValidationError() {
        CreatePageObject createPO = new CreatePageObject();
        createPO.getComputerNameElement().clear();
    }

    @When("the edit date fields error$")
    public void dateValidationError() {
        CreatePageObject createPO = new CreatePageObject();
        assertTrue(createPO.getErrorElements().get(0).getText().contains("Introduced date"));
        assertTrue(createPO.getErrorElements().get(1).getText().contains("Discontinued date"));
    }
}
