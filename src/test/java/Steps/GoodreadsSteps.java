package Steps;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class GoodreadsSteps {
    WebDriver driver = new FirefoxDriver();
    String url = "https://www.goodreads.com/";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setup() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Setup");

    }


    @Given("^I open the Goodreads web page$")
    public void iOpenTheBrowser() {
        try {
            driver.get(url);
        } catch (Exception e) {

        }
    }


    @Then("^I login$")
    public void iLogin() {
        System.out.println("login");
        try {
            driver.findElement(By.id("sign_in")).submit();
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Home'])[1]/preceding::a[1]")).click();
        } catch (Exception e) {

        }

    }

    @After
    public void tearDown() throws Exception {
        try {

            driver.quit();
            System.out.println("End");
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        } catch (Exception e) {

        }
    }

    @When("^I enter user id as \"([^\"]*)\"$")
    public void iEnterUserIdAs(String user) {
        try {
            System.out.println("user");
            driver.findElement(By.id("userSignInFormEmail")).click();
            driver.findElement(By.id("userSignInFormEmail")).clear();
            driver.findElement(By.id("userSignInFormEmail")).sendKeys(user);
        } catch (Exception e) {

        }
    }

    @And("^I enter password as \"([^\"]*)\"$")
    public void iEnterPasswordAs(String password) {
        try {
            System.out.println("pass");
            driver.findElement(By.id("user_password")).click();
            driver.findElement(By.id("user_password")).sendKeys(password);
        } catch (Exception e) {

        }
    }

    @And("^I verify the user$")
    public void iVerifyTheUser() {
        try {
            System.out.println("verify");
            driver.findElement(By.linkText("Profile")).click();
            assertEquals("R D (edit profile)", driver.findElement(By.id("profileNameTopHeading")).getText());

        } catch (Exception e) {

        }
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String arg0) {
        try {
            driver.findElement(By.name("q")).click();
            driver.findElement(By.name("q")).clear();
            driver.findElement(By.name("q")).sendKeys(arg0);
            driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        } catch (Exception e) {

        }
    }


    @And("^I mark it as <Read>$")
    public void iMarkItAsRead() {
        try{
            if (!driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enlarge cover'])[1]/following::div[3]")).getText().contains("Read)")){
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='View shelf'])[3]/following::button[1]")).click();
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Events'])[2]/following::div[10]")).click();
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='View shelf'])[3]/following::button[1]")).click();
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='View shelf'])[3]/following::button[1]")).click();
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='View shelf'])[3]/following::span[1]")).click();
                driver.findElement(By.id("close")).click();

            }



        } catch(Exception e){

        }


        driver.navigate().back();
    }




    @And("^I mark it as <Currently Reading>$")
    public void iMarkItAsCurrentlyReading() {
        if (!driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]")).getText().contains("Currently Reading")) {

            System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]")).getText());
            driver.findElement(By.xpath("//*[@id=\"1_book_5364\"]/div[2]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"1_book_5364\"]/div[2]/div/div[1]/ul[1]/li[2]/button/span"));
        }

    }

    @Then("^I select volume Outlander#(\\d+)$")
    public void iSelectVolumeOutlander(int arg0) {
        if (arg0 == 1)
            driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]/a/span")).click();
        if (arg0 == 2)
            driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[2]/div[2]/table/tbody/tr[2]/td[2]/a")).click();


    }

    @And("^I go back in the browser$")
    public void iGoBackInTheBrowser() {
        driver.navigate().back();
    }


    @And("^I verify its status is <Read>$")
    public void iVerifyItsStatus() {
        try {
            //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='View shelf'])[3]/following::button[1]")).click();
            //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='View shelf'])[3]/following::span[1]")).click();
            ///driver.findElement(By.id("close")).click();//close review window

            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enlarge cover'])[1]/following::span[1]")).click();

            assertEquals("Read", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enlarge cover'])[1]/following::span[1]")).getText());
            System.out.print(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enlarge cover'])[1]/following::span[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @And("^I verify its status is <Currently Reading>$")
    public void iVerifyItsStatusIsCurrentlyReading() {
        try {
            assertEquals("Currently Reading", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enlarge cover'])[1]/following::span[1]")).getText());
            System.out.print(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enlarge cover'])[1]/following::span[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @When("^I select <Community> menu$")
    public void iSelectCommunityMenu() {
        driver.findElement(By.linkText("Community ▾")).click();
    }

    @And("^I press om the <Quizzes> option$")
    public void iPressOmTheQuizzesOption() {
        driver.findElement(By.linkText("Quizzes")).click();
    }

    @Then("^I select <Guess the book> option$")
    public void iSelectGuessTheBookOption() {
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/div[2]/div/div[3]/a[3]")).click();
        try {
            assertEquals("The Guess the book quiz: 8 questions by Anda T. | Goodreads", driver.getTitle());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}

