package pages;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private static final String pinCodeKormanagala = "560048";


    @FindBy(css = "button._2AkmmA._29YdH8")
    private WebElement closePopUpCross;

    @FindBy(css = "input[placeholder='Search for products, brands and more']")
    private WebElement searchbox;

    @FindBy(css = ".vh79eN")
    private WebElement searchButton;

    @FindAll(@FindBy(partialLinkText = "Solid"))
    private List<WebElement> productHandle;

    @FindBy(css = "#swatch-0-size")
    private WebElement shortSize;

    @FindBy(css = "input._20PCkk")
    private WebElement pinCOdePlaceHolder;

    @FindBy(css = "._2LG8B7")
    private WebElement selectedAddress;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void closePopUp() {
        closePopUpCross.click();
    }

    public void searchFor(String productName) throws Throwable {
        waitForElement(searchbox);
        searchbox.sendKeys(productName);
        searchButton.click();
    }

    public void putFilter(String filterName) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='" + filterName + "']")).click();
    }

    public void selectProduct() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(productHandle.size());
        waitForElement(productHandle.get(0));
        productHandle.get(0).click();
    }

    public void redirectsToProductPage() {
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window((String) tabs.get(1));
    }

    public void selectSize(String size) throws InterruptedException {
        System.out.println(driver.getTitle());
        waitForElement(shortSize);
        shortSize.click();
        System.out.println("clicked on short size");

    }

    public void enterPinCode() throws InterruptedException {
        waitForElement(pinCOdePlaceHolder);
        pinCOdePlaceHolder.sendKeys(pinCodeKormanagala);
    }
}
