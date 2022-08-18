import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//feature/demo.feature",
        glue = "stepDefinition",
        dryRun = false,
        plugin = {"pretty", "html:test-output"},
        monochrome = true
)
public class runTest {

}