package com.fwk.setup;

import com.codeborne.selenide.WebDriverRunner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestSetup {
    private WebDriver driver;
    public String status="failed";

    public static String username;
    public static String password;
    public static String sessionId;

    @BeforeMethod(alwaysRun = true)
    @Parameters(value = { "config", "environment" })
    public void setUp(String config_file, String environment) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
        JSONObject envs = (JSONObject) config.get("environments");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> env = (Map<String, String>) envs.get(environment);
        for (Map.Entry<String, String> pair : env.entrySet()) {
            capabilities.setCapability(pair.getKey(), pair.getValue());
        }
        System.setProperty("browser", env.get("browserName"));
        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        capabilities.setCapability("name", this.getClass().getName());

        username = System.getenv("USERNAME");
        if (username == null) {
            username = (String) config.get("username");
        }

        password = System.getenv("PASSWORD");
        if (password == null) {
            password = (String) config.get("password");
        }

        driver = new CustomWebDriverProvider().createDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //sessionId = driver.getSessionId().toString();

        WebDriverRunner.setWebDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        //driver.executeScript("lambda-status="+status);
        driver.quit();
    }

}