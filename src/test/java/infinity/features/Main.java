package infinity.features;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/infinity/features",
        glue = {"infinity/stepDefination", "infinity/features"},
        monochrome = true,
        plugin = {"html:target/cucumber-reports/cucumber.html", "timeline: target/cucumber-reports/timeline.html"},
        tags = "@orderFeature"
)
public class Main extends AbstractTestNGCucumberTests {
}
