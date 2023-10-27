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

public class loginFailedPage {
    WebDriver driver;
    String baseUrl = "https://saucedemo.com/";

    @Given("user should open saucedemo")
    public void user_should_be_open_https_saucedemo_com() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @When("user input invalid username")
    public void user_input_invalid_username() throws Exception {
        driver.findElement(By.id("user-name")).sendKeys("standard_user123");
        Thread.sleep(500);
    }
    @And("user input invalid password")
    public void user_input_invalid_password() throws Exception {
        driver.findElement(By.id("password")).sendKeys("secret_sauce1");
        Thread.sleep(500);
    }
    @And("user click login button")
    public void user_click_login_button() throws Exception {
        driver.findElement(By.id("login_button")).click();
        Thread.sleep(500);
    }
    @Then("dashboard should not be displayed")
    public void  dashboard_should_not_be_displayed() {
        Assert.assertEquals("Epic sadface: Username and Password do not match to any user",driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match')]")).getText());
        System.out.println("Scenario : Login as invalid user");
        System.out.println("If failed login, You can see error" + driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match')]")).getText());
        driver.quit();
    }
}
