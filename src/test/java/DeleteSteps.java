import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class DeleteSteps {

    @When("the computer deleted message is displayed$")
    public void deletedComputerMessage() {
        BasePageObject basePO = new BasePageObject();
        assertTrue(basePO.getMessageWarningElement().getText().contains("Computer has been deleted"));
    }
}
