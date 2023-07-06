package com.assessment.fs.stepdefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

 @RunWith(Cucumber.class)
  @CucumberOptions(
      features = {"src/test/resources/feature"},
      glue = {"com/assessment/fs/stepdefinitions"},
      monochrome = true,
      plugin = {"pretty", "html:test-output1"} )

  public class TestRunner {
  }

