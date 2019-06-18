package runner;


import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import driverClass.FileReaderManager;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import org.testng.annotations.AfterClass;


import java.io.File;

@RunWith(Cucumber.class)
    @CucumberOptions(features="/Users/monilj/Downloads/FlipkartAutomation/src/test/resources/features", glue=""
            ,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})

    public class runner_flipkart
    { @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
    }


    }

