package stepDef;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import  cucumber.api.java.en.And;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginPage {
    WebDriver driver;
    String baseUrl = "https://saucedemo.com/";

    @Given("user should open saucedemo")
    public void user_should_be_open_https_saucedemo_com() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @When("user input valid username")
    public void user_input_valid_username() throws Exception {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(500);
        driver.findElement(By.id("")).sendKeys("secret_sauce");
        Thread.sleep(500);
    }
    @And("user click login button")
    public void user_click_login_button() throws Exception {
        driver.findElement(By.id("login_button")).click();
        Thread.sleep(500);
    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        Assert.assertEquals("Products",driver.findElement(By.className("title")).getText());
        System.out.println("Scenario : Login as valid customer");
        System.out.println("If Login Success, You Can See Title Name" + driver.findElement(By.className("title")).getText());
        driver.quit();
    }
}

