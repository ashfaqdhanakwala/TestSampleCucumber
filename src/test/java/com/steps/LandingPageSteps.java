package com.steps;

import com.pages.LandingPage;
import com.utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LandingPageSteps {
    TestContext testContext;
    LandingPage landingPage;

    public LandingPageSteps(TestContext testContext) {
        this.testContext = testContext;
        this.landingPage = testContext.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() {

        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^User Searches with shortname \"([^\"]*)\" and extracts actual product name$")
    public void user_searches_with_shortname_and_extracts_actual_product_name(String name) throws InterruptedException {
        landingPage.searchItem(name);
        Thread.sleep(2000);
        String[] arrProductText = landingPage.getProductName().split("-");
        testContext.strTextLandingPage = arrProductText[0].trim();
        System.out.println(testContext.strTextLandingPage);
        landingPage.selectTopDeals();

    }

}
