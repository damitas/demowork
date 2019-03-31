import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.UUID;

public class BasePageObject {
/*
Contains common locators that can be used across a number of pageobjects
*/

    protected static WebDriver driver;

    public BasePageObject() {
        driver = DriverProvider.getDriverInstance();
    }

    public WebElement geth1tagElement(){
       return driver.findElement(By.tagName("h1"));
    }

    //Homepage web element
    public WebElement getAddComputerButtonElement(){
        return driver.findElement(By.id("add"));
    }

    public WebElement getMessageWarningElement(){
        return driver.findElement(By.cssSelector("div.alert-message.warning"));
    }

    public void createUpdateComputer(String action, String computerName, String introducedDate, String discontinuedDate, String companyName) {
        CreatePageObject createPO = new CreatePageObject();
        WebElement computerNameElement = createPO.getComputerNameElement();
        WebElement introducedDateElement = createPO.getIntroducedDateElement();
        WebElement discontinuedDateElement = createPO.getDiscontinuedDateElement();

        //when updating the user would clear the field, when 'creating' the field should be defaulted to cleared
        if(action.equals("update")){
            computerNameElement.clear();
            introducedDateElement.clear();
            discontinuedDateElement.clear();
        }

        createPO.getComputerNameElement().sendKeys(computerName);
        createPO.getIntroducedDateElement().sendKeys(introducedDate);
        createPO.getDiscontinuedDateElement().sendKeys(discontinuedDate);
        if(companyName.length()>0) {
            Select companyNameDropDown = new Select(createPO.getCompanyNameElement());
            companyNameDropDown.selectByVisibleText(companyName);
        }
    }

    public void createUniqueComputerAndLoadEditScreen(String randomUUIDString, String introducedDate, String discontinuedDate, String companyName){
        BasePageObject basePO = new BasePageObject();
        basePO.getAddComputerButtonElement().click();

        //create a unique computer name
        basePO.createUpdateComputer("create",randomUUIDString,introducedDate, discontinuedDate, companyName);
        CreatePageObject createPO = new CreatePageObject();
        createPO.getCreateComputerButtonElement().click();

        //search for the unique computer
        ReadPageObject readPO = new ReadPageObject();
        readPO.getFilterElement().sendKeys(randomUUIDString);
        readPO.getFilterButtonElement().click();
    }

    public void createUniqueComputerName(String randomUUIDString, String introducedDate, String discontinuedDate, String companyName){
        BasePageObject basePO = new BasePageObject();
        basePO.getAddComputerButtonElement().click();

        //create a unique computer name
        basePO.createUpdateComputer("create",randomUUIDString,introducedDate, discontinuedDate, companyName);
        CreatePageObject createPO = new CreatePageObject();
        createPO.getCreateComputerButtonElement().click();
    }

    public WebElement getPageHeader(){
        List<WebElement> h1Elements = driver.findElements(By.tagName("h1"));
        return h1Elements.get(1);
    }
}
