package com.assessment.fs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FleetstudioPom {
  WebDriver ldriver;
  @FindBy(linkText = "Continue")
  WebElement continue_btn1;
  @FindBy(xpath = "//input[@name=\"firstname\"]")
  WebElement fname;
  @FindBy(xpath = "//input[@name=\"lastname\"]")
  WebElement lname;
  @FindBy(xpath = "//input[@name=\"email\"]")
  WebElement email;
  @FindBy(xpath = "//input[@name=\"telephone\"]")
  WebElement phone;
  @FindBy(xpath = "//input[@name=\"password\"]")
  WebElement password;
  @FindBy(xpath = "//input[@name=\"confirm\"]")
  WebElement confirm;
  @FindBy(xpath = "///input[@value='Continue']")
  WebElement submit;



  public FleetstudioPom(WebDriver rdriver) {
    ldriver = rdriver;
    PageFactory.initElements(rdriver, this);
  }
  public void click_continue_btn1()
  {
    continue_btn1.click();
  }
  public void set_fname(String firstname)
  {
    fname.clear();
    fname.sendKeys(firstname);
  }
  public void set_lname(String lastname)
  {
    lname.clear();
    lname.sendKeys(lastname);
  }
  public void set_email(String mailid)
  {
    email.clear();
    email.sendKeys(mailid);
  }
  public void set_phone(String phonenum)
  {
    phone.clear();
    phone.sendKeys(phonenum);
  }
  public void set_password(String pwd)
  {
    password.clear();
    password.sendKeys(pwd);
  }
  public void set_confirm(String confirmpwd)
  {
    confirm.clear();
    confirm.sendKeys(confirmpwd);
  }
  public void click_submit()
  {
    submit.click();
  }

}
