import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//feature/demo2.feature",
        glue = "stepDefinition",
        dryRun = false
)
public class runTest {

}