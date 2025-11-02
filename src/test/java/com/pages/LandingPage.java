package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    public WebDriver driver;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement txtbxSearch;
    @FindBy(xpath = "//a[text()='Top Deals']")
    private WebElement lnkTopDeals;
    @FindBy(xpath = "//h4[@class='product-name']")
    private WebElement hdrProductName;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean searchItem(String name) {
        txtbxSearch.sendKeys(name);
        return true;
    }

    public String getProductName() {
        return hdrProductName.getText();
    }

    public boolean selectTopDeals() {
        lnkTopDeals.click();
        return true;
    }

    public String getTitleLandingPage() {
        return driver.getTitle();
    }

}
