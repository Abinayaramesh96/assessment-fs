package com.assessment.fs.stepdefinitions;

import com.assessment.fs.pageobjects.LoginPom;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
  protected WebDriver driver;
  LoginPom lp;
  public void setup() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
  }

  @After
  public void destroy() {
    driver.quit();
  }

}
