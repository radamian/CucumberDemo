import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features",
        glue="Steps",
        plugin = {"pretty", "html:target/cucumber"},
        tags = {"@run_me"})
public class RunCukesTest {
}