import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreatePageObject extends BasePageObject {

    //returns Computer webelements to create and update a computer

    public CreatePageObject(){
        super();
    }

    public WebElement getComputerNameElement(){
        return driver.findElement(By.id("name"));
    }

    public WebElement getIntroducedDateElement(){
        return driver.findElement(By.id("introduced"));
    }

    public WebElement getDiscontinuedDateElement(){
        //will return more than 1 element
        return driver.findElement(By.id("discontinued"));
    }

    public List<WebElement> getHelperElements(){
        //will return more than 1 element
        return driver.findElements(By.className("help-inline"));
    }

    public WebElement getCompanyNameElement(){
        return driver.findElement(By.id("company"));
    }

    public WebElement getCreateComputerButtonElement(){
        return driver.findElement(By.cssSelector("input.btn.primary"));
    }

    public WebElement getCancelButtonElement(){
        return driver.findElement(By.cssSelector("a.btn"));
    }

    public WebElement getErrorElement() {
        return driver.findElement(By.cssSelector("div.clearfix.error>label"));
    }

    public List<WebElement> getErrorElements() {
        return driver.findElements(By.cssSelector("div.clearfix.error>label"));
    }

}
