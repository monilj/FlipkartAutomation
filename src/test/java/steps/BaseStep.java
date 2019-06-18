package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import driverClass.DriverClass;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseStep extends DriverClass{

    @Before
    public void beforeScenario() {
        if (null == driver) {
            initialize();
        }
    }



//    @After
//    public void afterScenario(Scenario scenario) {
//        if (null != driver) {
//            writeExtentReport();
//        }
//    }
}
