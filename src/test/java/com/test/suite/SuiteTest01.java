package com.test.suite;

import com.fwk.setup.TestSetup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SuiteTest01 extends TestSetup {

	private String status = "failed";

    @Test
	public void test() throws Exception {

		open("https://lambdatest.github.io/sample-todo-app/");

		$(By.name("li1")).click();
		$(By.name("li2")).click();
		$(By.id("sampletodotext")).setValue("Complete LambdaTest Tutorial.").pressEnter();

		String newElem = $(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();
		sleep(2000);

		Assert.assertEquals(newElem, "Complete LambdaTest Tutorial.");
		status = "passed";
	}

}