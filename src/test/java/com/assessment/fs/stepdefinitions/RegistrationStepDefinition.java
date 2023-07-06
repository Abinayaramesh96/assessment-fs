package com.assessment.fs.stepdefinitions;

import com.assessment.fs.pageobjects.FleetstudioPom;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class RegistrationStepDefinition extends BaseClass {
  FleetstudioPom fs;
  private static final String URL_TO_LAND = "https://tutorialsninja.com/demo/index.php?route=account/login";

  @Before
  public void setup() {
    super.setup();
    fs = new FleetstudioPom(driver);
  }

  @After
  public void screenshot(Scenario scenario) throws IOException {
    if (scenario.isFailed()) {
      TakesScreenshot ts = (TakesScreenshot) driver;
      File src = ts.getScreenshotAs(OutputType.FILE);
      File tar = new File("/reports/screenshots/landingpage.png");
      FileHandler.copy(src, tar);
    }
  }

  @Given("Launch the landing page")
  public void launch_the_landing_page() {
    driver.get(URL_TO_LAND);
  }

  @When("The user click the continue button")
  public void the_user_click_the_continue_button() {
    fs.click_continue_btn1();
  }

  @Then("the user is taken to the register account page")
  public void the_user_is_taken_to_the_register_account_page() {
    String title = driver.getTitle();
    Assert.assertEquals(title, "Register Account");
  }

  @When("User enter the personal details")
  public void user_enter_the_personal_details() {
    fs.set_fname("Abinaya");
    fs.set_lname("Ramesh");
    fs.set_email("abinaya@123.gmail.com");
    fs.set_phone("1234567890");
    fs.set_password("12345678");
    fs.set_confirm("12345678");

  }

  @When("Click the continue button")
  public void click_the_continue_button() {
    System.out.println("user submitted");
    //fs.click_submit();
  }

  @Then("User registered for an account")
  public void user_registered_for_an_account() {
    System.out.println("user registered");
  }
}

