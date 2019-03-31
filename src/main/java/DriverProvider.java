import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class DriverProvider {

    private static WebDriver driver;

    public static WebDriver getDriverInstance() {
        return driver;
    }

    public static WebDriver createDriver() {

        String platform = System.getProperty("platform");
        String os = System.getProperty("os.name").toLowerCase();
        String extension = "";

        //create path to driver depending on OS
        String driverRoot = "src" + File.separator + "main" + File.separator + "resources" + File.separator;

        if (os.contains("win")) extension = ".exe";

        if (platform.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverRoot + "chromedriver" + extension);
            driver = new ChromeDriver();
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        } else {
            System.setProperty("webdriver.gecko.driver", driverRoot + "geckodriver" + extension);
            driver = new FirefoxDriver();
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        }

        return driver;
    }
}
