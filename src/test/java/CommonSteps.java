import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class CommonSteps {

    @Then("^the Homepage has loaded$")
    public void homepageHasLoaded() throws Throwable {
        BasePageObject basePO = new BasePageObject();
        assertTrue("Add a new computer button is not displayed on the homepage",basePO.getAddComputerButtonElement().isDisplayed());
    }

    @Then("^I click on the \"([^\"]*)\" button$")
    public void clickOnAButton(String buttonName) {
        if (buttonName.equals("Add a new computer")){
            BasePageObject basePO = new BasePageObject();
            basePO.getAddComputerButtonElement().click();
        }
        if (buttonName.equals("Create this computer")){
            CreatePageObject createPO = new CreatePageObject();
            createPO.getCreateComputerButtonElement().click();
        }
        if (buttonName.equals("Cancel")){
            CreatePageObject createPO = new CreatePageObject();
            createPO.getCancelButtonElement().click();
        }
        if (buttonName.equals("Save this computer")){
            ReadPageObject readPO = new ReadPageObject();
            readPO.getSaveComputerButtonElement().click();
        }
        if (buttonName.equals("Delete this computer")){
            DeletePageObject deletePO = new DeletePageObject();
            deletePO.getDeleteButtonElement().click();
        }
    }

    //common to both update and create
    @When("the \"([^\"]*)\" is successfully saved$")
    public void computerCreatedMessage(String computerName) {
        BasePageObject basePO = new BasePageObject();
        assertTrue(basePO.getMessageWarningElement().getText().contains(computerName));
    }

    //common to both update and create
    @When("the title of the page is \"([^\"]*)\"$")
    public void titleOfPage(String pageTitle) {
        BasePageObject basePO = new BasePageObject();
        assertTrue(basePO.getPageHeader().getText().contains(pageTitle));
    }
}
