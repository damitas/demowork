import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeletePageObject extends BasePageObject{

    public DeletePageObject(){
        super();
    }

    public WebElement getDeleteButtonElement(){
        return driver.findElement(By.cssSelector("input.btn.danger"));
    }
}
