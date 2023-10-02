package com.test;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.fwk.setup.CustomWebDriverProvider;
import com.fwk.setup.TestSetup;
import com.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SingleTest extends TestSetup {


	@Test
	public void test() throws Exception {

		open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Verify Login Page
		Assert.assertTrue(LoginPage.brandingLogo.isDisplayed());

		status = "passed";
	}

}
