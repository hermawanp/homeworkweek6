package stepDef;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import  cucumber.api.java.en.And;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class addToCartPage {
    WebDriver driver;
    String baseUrl = "https://saucedemo.com";

    @Given("user login to saucedemo")
    public void user_login_to_saucedemo() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login_button")).click();
        Thread.sleep(500);
    }

    @When("user click Add to cart button in second list product")
    public void user_click_Add_to_cart_button_in_second_list_product() throws Exception {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(500);
    }

    @And("user click icon cart")
    public void user_click_icon_cart() throws Exception {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(500);
    }

    @Then("in cart page, will show the product that user choose")
    public void in_cart_page_will_show_the_product_that_user_choose() {
        Assert.assertEquals("Sauce Labs Products", driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
        System.out.println("Scenario : Add Product to Cart");
        System.out.println("If Success Add Product to Cart" + driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText() + ", You can see Product Title Name" + driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText() + " in Cart Page");
        driver.quit();
    }
}
