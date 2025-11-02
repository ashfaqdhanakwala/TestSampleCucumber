package com.steps;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.utils.TestBase;
import com.utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Hooks {
    TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        // First Step
        TestBase.WebDriverManager().get(TestBase.prop.getProperty("QAUrl"));

    }

    @After
    public void AfterScenario(Scenario scenario) {
        if (scenario.getStatus().toString().equalsIgnoreCase("failed")) {

            Date d = new Date();
            TestBase.fileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
            File screenshot = ((TakesScreenshot) TestBase.WebDriverManager()).getScreenshotAs(OutputType.FILE);
            byte[] screenshotbyte = ((TakesScreenshot) TestBase.WebDriverManager()).getScreenshotAs(OutputType.BYTES);
            String screenshotPath = System.getProperty("user.dir") + "//reports//screenshots//" + TestBase.fileName;
            try {
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                // Attach screenshot to ExtentCucumberAdapter
                scenario.attach(screenshotbyte, "image/png", "Failed Screenshot");
                ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        // Last Step
        if (TestBase.WebDriverManager() != null) {
            TestBase.WebDriverManager().quit();
        }

    }

}
