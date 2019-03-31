import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Hooks {
    private WebDriver driver;

    @Before()
    public WebDriver startUp() {
        driver= DriverProvider.createDriver();
        driver.get("http://computer-database.gatling.io/computers");

        return driver;
    }

    @After
    public void embedScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                TakesScreenshot scrShot =((TakesScreenshot)driver);
                scrShot.getScreenshotAs(OutputType.BYTES);
                scenario.embed(scrShot.getScreenshotAs(OutputType.BYTES), "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }

       driver.quit();
    }


}