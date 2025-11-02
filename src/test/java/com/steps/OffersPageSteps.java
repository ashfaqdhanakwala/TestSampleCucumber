package com.steps;

import com.pages.OffersPage;
import com.utils.GenericUtils;
import com.utils.TestContext;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class OffersPageSteps {
    public String strtextOffersPage;
    OffersPage offersPage;
    TestContext testContext;
    GenericUtils genericUtils;

    public OffersPageSteps(TestContext testContext) {
        this.testContext = testContext;
        this.offersPage = testContext.pageObjectManager.getOffersPage();
        this.genericUtils = testContext.genericUtils;
    }

    @Then("^User Searches for same shortName \"([^\"]*)\" in offers page to check if product exist$")
    public void user_searches_for_same_short_name_in_offers_page_to_check_if_product_exist(String name) throws InterruptedException {
        genericUtils.SwitchToChildWindow();
        offersPage.searchItem(name);
        Thread.sleep(2000);
        strtextOffersPage = offersPage.getProductName().trim();
        Assert.assertEquals(testContext.strTextLandingPage, strtextOffersPage);
    }

}
