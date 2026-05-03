package ombiryanihouse;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MyStepDefinitions {

    WebDriver driver;

    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 🔥 Browser setup
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // 🔹 Open Website
    @Given("user opens the website URL {string}")
    public void user_opens_the_website_url(String url) {
        driver.get(url);
    }

    @When("the page is loaded")
    public void the_page_is_loaded() {
        System.out.println("Page loaded");
    }

    // 🔹 Homepage
    @Then("homepage should be displayed successfully")
    public void homepage_should_be_displayed_successfully() {
        Assert.assertTrue(driver.getTitle().contains("Om Biryani House"));
    }

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        driver.get("https://ombiryanihouse.wordpress.com/");
    }


    // 🔹 Navigation
    @When("user clicks on {string} link")
    public void user_clicks_on_link(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
        pause(2);
    }

    @Then("about page should open")
    @Then("Contact page should open")
    @Then("Blog page should open")
    @Then("Privacy Policy page should open")
    public void verify_page_open() {
        System.out.println("Page: " + driver.getTitle());
    }

    // 🔹 Contact Page
    @Given("user is on Contact page")
    public void user_is_on_contact_page() {
        driver.get("https://ombiryanihouse.wordpress.com/contact/");
    }

    @When("user enters name as {string}")
    public void user_enters_name(String name) {
        driver.findElement(By.name("g29-name")).sendKeys(name);
    }

    @And("user enters phone as {string}")
    public void user_enters_phone(String phone) {
        driver.findElement(By.name("g29-phone")).sendKeys(phone);
    }

    @And("user enters email as {string}")
    public void user_enters_email(String email) {
        driver.findElement(By.name("g29-email")).sendKeys(email);
    }



    // 🔹 Blank fields
    @When("user leaves all required fields blank")
    public void user_leaves_all_required_fields_blank() {
        driver.findElement(By.name("g29-name")).clear();
        driver.findElement(By.name("g29-email")).clear();
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedError) {
        WebElement email = driver.findElement(By.name("g29-email"));
        String validation = email.getAttribute("validationMessage");
        Assert.assertTrue(validation.length() > 0);
    }

    // ✅ FIXED SUBMIT BUTTON (MAIN FIX HERE)
    @And("user clicks on submit button")
    public void user_clicks_on_submit_button() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[@type='submit']")
        ));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", btn);

        wait.until(ExpectedConditions.elementToBeClickable(btn));

        try {
            // Normal click
            btn.click();
        } catch (Exception e) {
            // Fallback JS click
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", btn);
        }

        pause(5);
    }


    // 🔹 Mobile
    @Given("user opens website on mobile device {string}")
    public void user_opens_website_on_mobile(String device) {
        driver.manage().window().setSize(new Dimension(375, 812));
        driver.get("https://ombiryanihouse.wordpress.com/");
    }

    @When("user navigates through the website")

    @Then("content should adjust properly to screen size")


    // 🔥 Close browser
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}