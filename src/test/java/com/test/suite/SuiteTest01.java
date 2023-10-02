package com.test.suite;

import com.fwk.setup.TestSetup;
import com.pages.HomePage;
import com.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SuiteTest01 extends TestSetup {

	private String status = "failed";

    @Test
	public void test() throws Exception {

		open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Verify Login Page
		Assert.assertTrue(LoginPage.brandingLogo.isDisplayed());
		LoginPage.username.sendKeys(username);
		LoginPage.password.sendKeys(password);
		LoginPage.loginBth.click();
		Assert.assertTrue(HomePage.brandingLogo.isDisplayed());
	}

}