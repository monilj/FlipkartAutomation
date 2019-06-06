package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class HomePage extends BasePage {

    private static final String pinCodeKormanagala = "560048";

    @FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']")
    private WebElement closePopUpCross;

    @FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
    private WebElement searchbox;

    @FindBy(xpath = "//button[@class='vh79eN']")
    private WebElement searchButton;

    @FindAll(@FindBy(partialLinkText = "Solid"))
    private List<WebElement> productHandle;

    @FindBy(xpath = "//*[@id='swatch-0-size']")
    private WebElement shortSize;

    @FindBy(xpath = "//input[@placeholder='Enter delivery pincode']")
    private WebElement pinCOdePlaceHolder;

    //@FindBy(css = "._2LG8B7")
    //private WebElement selectedAddress;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void closePopUp() {
        closePopUpCross.click();
    }

    public void searchFor(String productName) throws Throwable {
        waitForElementToBevisible(searchbox);
        searchbox.sendKeys(productName);
        Thread.sleep(2000);
        searchButton.click();
        Thread.sleep(2000);
    }

    public void putFilter(String filterName) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='" + filterName + "']")).click();
    }

    public void selectProduct() throws InterruptedException {
        System.out.println(productHandle.size());
        Thread.sleep(2000);
        productHandle.get(0).click();
        Thread.sleep(5000);
    }

    public void redirectsToProductPage() {
        //String windowHandle = driver.getWindowHandle();
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window((String) tabs.get(1));

    }

    public void selectSize(String size) throws InterruptedException {
        System.out.println();
        System.out.println(driver.getTitle());
        Thread.sleep(1000);
        shortSize.click();
        System.out.println("clicked on short size");

    }

    public void enterPinCode() throws InterruptedException {

        try {
            Thread.sleep(1000);
            driver.findElement(By.className("_2LG8B7")).click();
//            selectedAddress.click();
        }
        catch (NoSuchElementException nse)
        {
            System.out.println("There is no selected address. Please enter pin code");
        }
        finally {
            Thread.sleep(1000);
            pinCOdePlaceHolder.clear();
            pinCOdePlaceHolder.sendKeys(pinCodeKormanagala);
        }


    }


}
