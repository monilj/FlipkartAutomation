package pages;

import driverClass.DriverClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class BasePage {

    WebDriver driver;
    private WebDriverWait webDriverWait;
    int timeout = 30;
    int pollingTime = 1;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 30);
    }

    public void waitForElement(WebElement element) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);
        wait.until((Function<WebDriver, WebElement>) driver -> element);
    }

}
