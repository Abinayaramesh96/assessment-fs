package com.assessment.fs.stepdefinitions;

import com.assessment.fs.pageobjects.LoginPom;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class LoginStepDefinition extends BaseClass {
  LoginPom lp;

  @Before
  public void launchBrowser() {
    super.setup();
    lp = new LoginPom(driver);
  }

  @After
  public void screenshot(Scenario scenario) throws IOException {
    if (scenario.isFailed()) {
      TakesScreenshot ts = (TakesScreenshot) driver;
      File src = ts.getScreenshotAs(OutputType.FILE);
      //File tar=new File(".\\Screenshot1\\homepage.png");
      File tar = new File("/reports/screenshots/failure/landingpage.png");
      FileHandler.copy(src, tar);
    }
  }

  @Given("user on the landing page URL {string}")
  public void user_on_the_landing_page_url(String url) {
    driver.get(url);
  }

  @When("user enter valid {string} and valid {string}")
  public void user_enter_valid_and_valid(String email, String password) {
    lp.set_emailaddress(email);
    lp.set_password(password);
  }

  @When("user click on the login button")
  public void user_click_on_the_login_button() {
    lp.click_loginbtn();
  }

  @Then("user should be logged  and navigate to account page URL {string}")
  public void user_should_be_logged_and_navigate_to_account_page_url(String title) {
    Assert.assertEquals(title, driver.getTitle());
  }

  @Given("user launch landing page URL {string}")
  public void user_launch_landing_page_url(String url) {
    driver.get(url);
  }

  @When("user enter invalid username {string} and invalid password {string}")
  public void user_enter_invalid_username_and_invalid_password(String invalidusername, String invalidpassword) {
    lp.set_password(invalidusername);
    lp.set_password(invalidpassword);
  }

  @When("click on the login button")
  public void click_on_the_login_button() {
    lp.click_loginbtn();
  }

  @Then("user should see an error message {string}")
  public void user_should_see_an_error_message(String errormsg) {
    String error = driver.findElement(By.xpath("//div[text()=\"Warning: No match for E-Mail Address and/or Password.\"]")).getText();
    Assert.assertEquals(errormsg, error);

  }

}

