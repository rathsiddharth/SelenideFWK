package com.test.suite;

import com.fwk.setup.TestSetup;
import com.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SuiteTest02 extends TestSetup {

    @Test
    public void test() throws Exception {

        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Verify Login Page
        Assert.assertTrue(LoginPage.brandingLogo.isDisplayed());
        Assert.assertTrue(LoginPage.title.isDisplayed());
        Assert.assertTrue(LoginPage.personIcon.isDisplayed());
        Assert.assertTrue(LoginPage.username.isDisplayed());
        Assert.assertTrue(LoginPage.password.isDisplayed());
    }

}