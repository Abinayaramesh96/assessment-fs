package com.assessment.fs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom {
  WebDriver ldriver;
  public LoginPom(WebDriver rdriver) {
    ldriver = rdriver;
    PageFactory.initElements(rdriver, this);
  }
  @FindBy(xpath = "//input[@name=\"email\"]")
  WebElement emailbox;
  @FindBy(xpath = "//input[@name=\"password\"]")
  WebElement passwordbox;
  @FindBy(xpath = "//input[@type=\"submit\"]")
  WebElement loginbtn;


  public void set_emailaddress(String emailaddress)
  {
    emailbox.clear();
    emailbox.sendKeys(emailaddress);
  }
  public void set_password(String password)
  {
    passwordbox.clear();
    passwordbox.sendKeys(password);
  }
  public void click_loginbtn()
  {
    loginbtn.click();
  }
}
