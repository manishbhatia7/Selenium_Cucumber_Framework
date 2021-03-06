package runners;
import bindings.baseclass;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"..//src/test/resource/"},
        glue={"bindings"},
        dryRun = true,
        plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/report.html"}
)

public class TestRunner extends baseclass {


}
