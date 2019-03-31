import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReadPageObject extends BasePageObject {

    public ReadPageObject(){
        super();
    }

    public WebElement getFilterElement(){
        return driver.findElement(By.id("searchbox"));
    }

    public WebElement getFilterButtonElement(){
        return driver.findElement(By.id("searchsubmit"));
    }

    public WebElement getUniqueResultElement(String ahrefLinkText){
        return driver.findElement(By.linkText(ahrefLinkText));
    }

    public WebElement getSaveComputerButtonElement(){
        return driver.findElement(By.cssSelector("input.btn.primary"));
    }

    public WebElement getPagingLinks(String ahrefLinkText){
        return driver.findElement(By.linkText(ahrefLinkText));
    }

    public WebElement getCurrentPage(){
        return driver.findElement(By.xpath("//a[contains(text(),'Displaying')]"));
    }

    public WebElement getDisabledPreviousCSSClass(){
        return driver.findElement(By.cssSelector("li.prev.disabled"));
    }

    public WebElement getFilterPageHeader(){
        List<WebElement> h1Elements = driver.findElements(By.tagName("h1"));
        return h1Elements.get(1);
    }
}
