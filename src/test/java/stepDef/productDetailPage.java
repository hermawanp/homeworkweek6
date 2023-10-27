package stepDef;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.an.E;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import  cucumber.api.java.en.And;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;
public class productDetailPage {
    WebDriver driver;
    String baseUrl = "https://saucedemo.com/";

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
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(500);
    }

    @When("user click product name in list")
    public void user_click_product_name_in_list() throws Exception {
        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click();
        Thread.sleep(500);
    }

    @Then("show to chosen product detail page")
    public void show_to_chosen_product_detail_page() {
        Assert.assertEquals("Sauce Labs Backpack", driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
        System.out.println("Scenario : Show Product Detail");
        System.out.println("If Success Choose Product Detail" + driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText() + ", You Can See Product Title Name" + driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText() + " in Product Detail Page");
    }
}
