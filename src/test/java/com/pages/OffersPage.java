package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersPage {
    public WebDriver driver;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement txtbxSearch;
    @FindBy(xpath = "//table/tbody/tr/td[1]")
    private WebElement tdProductName;

    public OffersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean searchItem(String name) {
        txtbxSearch.sendKeys(name);
        return true;
    }

    public String getProductName() {
        return tdProductName.getText();
    }

}
