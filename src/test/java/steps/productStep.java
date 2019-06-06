package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverClass.DriverClass;
import pages.HomePage;


public class productStep extends DriverClass {
    HomePage homePage = new HomePage(driver);

    @Given("^User opens flipkart in chrome$")
    public void user_opens_flipkart_in_chrome() throws InterruptedException {
        driver.get("https://www.flipkart.com/");
        Thread.sleep(1000);
        homePage.closePopUp();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @When("^User search for a \"([^\"]*)\"$")
    public void user_search_for_a_product(String productName) throws Throwable {
        homePage.searchFor(productName);
    }

    @Then("^User applies a \"([^\"]*)\" to sort the products$")
    public void user_applies_a_filter_to_sort_the_products(String filter) throws Throwable {
        homePage.putFilter(filter);
    }

    @And("^User selects first product$")
    public void user_selects_first_product() throws Throwable {
        homePage.selectProduct();

    }

    @And("^User redirects to product page$")
    public void User_redirects_to_product_page() throws Throwable {
        homePage.redirectsToProductPage();
    }


    @And("^User selects \"([^\"]*)\"$")
    public void User_selects_size(String Size) throws Throwable {
        homePage.selectSize(Size);
    }
    @Then("^User enters pin code$")
    public void User_enters_pin_code() throws InterruptedException {
        homePage.enterPinCode();
    }


}