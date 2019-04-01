import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReadSteps {

    @Given("there is more than \"(\\d)\" page of results with computer name beginning \"([^\"]*)\"$")
    public void pagesOfResults(Integer pages, String computerNamePreFix) {

        Integer pagingSize = 10;
        Integer noOfRecords = pagingSize*2; //will create 2 more records than the page size
        String randomUUIDString = "";
        String introducedDate = "2019-03-01";
        String discontinuedDate = "2020-03-01";
        String companyName = "Apple Inc.";BasePageObject basePO = new BasePageObject();

        for(int i=0;i<noOfRecords; i++) {
            UUID uuid = UUID.randomUUID();
            randomUUIDString = uuid.toString();
            basePO.createUniqueComputerName(computerNamePreFix+randomUUIDString, introducedDate, discontinuedDate, companyName);

        }
    }

    @When("I search for the computer name \"([^\"]*)\"$")
    public void searchForComputerName(String computerNamePreFix) {
        //search for the unique computer
        ReadPageObject readPO = new ReadPageObject();
        readPO.getFilterElement().sendKeys(computerNamePreFix);
        readPO.getFilterButtonElement().click();
    }

    @When("I click on the next link")
    public void clickNextLink() {
        //search for the unique computer
        ReadPageObject readPO = new ReadPageObject();
        readPO.getPagingLinks("Next").click();
    }

    @When("I click on the previous link")
    public void clickPreviousLink() {
        //search for the unique computer
        ReadPageObject readPO = new ReadPageObject();
        readPO.getPagingLinks("Previous").click();
    }

    @Then("the next 11 to 20 records are shown")
    public void nextRecordsShown() {
        ReadPageObject readPO = new ReadPageObject();
        assertTrue(readPO.getCurrentPage().getText().contains("11 to 20"));
    }

    @Then("the records 1 to 10 are shown")
    public void previousRecordsShown() {
        ReadPageObject readPO = new ReadPageObject();
        assertTrue(readPO.getCurrentPage().getText().contains("1 to 10"));
    }

    @Then("the previous link is disabled")
    public void previousLinkDisabled() {
        ReadPageObject readPO = new ReadPageObject();
        assertTrue(readPO.getDisabledPreviousCSSClass().isDisplayed());
    }

    @When("computer records are found")
    public void computerFoundTitle() {
        BasePageObject basePO = new BasePageObject();
        assertFalse(basePO.getPageHeader().getText().equals("No computers found"));
    }

    @When("I search for a computer name that does not exists")
    public void computerDoesNotExist() {
        ReadPageObject readPO = new ReadPageObject();
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        readPO.getFilterElement().sendKeys(randomUUIDString);
        readPO.getFilterButtonElement().click();
    }

    @When("no computer records are found")
    public void noComputerFoundTitle() {
        BasePageObject basePO = new BasePageObject();
        assertTrue(basePO.getPageHeader().getText().contains("No computers found"));
    }
}
