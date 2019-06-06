package driverClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverClass {

    public static WebDriver driver;
    public void initialize() {
        if (null == driver) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    public void destroyDriver() {
        driver.quit();

    }
    }
