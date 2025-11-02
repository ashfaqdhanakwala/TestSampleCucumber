package com.utils;

import com.pages.PageObjectManager;

import java.io.IOException;

public class TestContext {
    public String strTextLandingPage;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContext() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(TestBase.WebDriverManager());
        genericUtils = new GenericUtils(TestBase.WebDriverManager());
    }

}
