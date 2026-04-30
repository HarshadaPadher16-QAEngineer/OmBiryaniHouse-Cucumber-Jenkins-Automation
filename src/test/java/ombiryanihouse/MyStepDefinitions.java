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

    // ✅ FIXED INQUIRY (correct locator + wait)
    @And("user enters inquiry as {string}")
    public void user_enters_inquiry(String msg) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement inquiry = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("contact-form-comment-g29-comment")
        ));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", inquiry);

        inquiry.sendKeys(msg);
    }

    // ✅ FIXED SUBMIT BUTTON
    @And("user clicks on submit button")
    public void user_clicks_on_submit_button() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class,'pushbutton-wide')]")
        ));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", btn);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", btn);

        pause(5);
    }

    // ✅ SUCCESS MESSAGE
    @Then("success message {string} should be displayed")
    public void success_message_should_be_displayed(String expectedMsg) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("contact-form__confirmation")
        ));

        Assert.assertTrue(successMsg.getText().toLowerCase().contains(expectedMsg.toLowerCase()));
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

    // 🔹 Invalid email
    @When("user enters invalid email as {string}")
    public void user_enters_invalid_email(String invalidEmail) {
        driver.findElement(By.name("g29-email")).sendKeys(invalidEmail);
    }

    @Then("error message for invalid email should be displayed")
    public void error_message_for_invalid_email_should_be_displayed() {
        WebElement email = driver.findElement(By.name("g29-email"));
        String validation = email.getAttribute("validationMessage");
        Assert.assertTrue(validation.length() > 0);
    }

    // 🔹 Mobile
    @Given("user opens website on mobile device {string}")
    public void user_opens_website_on_mobile(String device) {
        driver.manage().window().setSize(new Dimension(375, 812));
        driver.get("https://ombiryanihouse.wordpress.com/");
    }

    @When("user navigates through the website")

    @Then("content should adjust properly to screen size")

    // 🔹 Images
    @When("user checks all images on the page")
    public void user_checks_all_images_on_the_page() {
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Images: " + images.size());
    }

    @Then("all images should be visible properly")
    public void all_images_should_be_visible_properly() {
        for (WebElement img : driver.findElements(By.tagName("img"))) {
            Assert.assertTrue(img.isDisplayed());
        }
    }



    // 🔥 Close browser
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}