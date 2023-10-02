package com.test;

import com.fwk.setup.TestSetup;
import com.pages.HomePage;
import com.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SingleTest extends TestSetup {


	@Test(groups = {"Default", "SingleTest"}, testName = "LoginTest")
	public void test() throws Exception {

		open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Verify Login Page
		Assert.assertTrue(LoginPage.brandingLogo.isDisplayed());
		Assert.assertTrue(LoginPage.title.isDisplayed());
		Assert.assertTrue(LoginPage.personIcon.isDisplayed());
		Assert.assertTrue(LoginPage.username.isDisplayed());
		Assert.assertTrue(LoginPage.password.isDisplayed());
		LoginPage.username.sendKeys(username);
		LoginPage.password.sendKeys(password);
		LoginPage.loginBth.click();
		Assert.assertTrue(HomePage.brandingLogo.isDisplayed());
	}

}
