import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/",
        plugin = { "html:target/cucumber-html-report", "json:target/cucumber.json",
                "pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
                "junit:target/cucumber-results.xml","pretty"}
)
public class TestRunner {
}