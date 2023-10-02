package com.fwk.setup;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CustomWebDriverProvider implements WebDriverProvider {

    private WebDriver webDriver;

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        String currentBrowser = System.getProperty("browser", "");
        switch(currentBrowser) {
            case "chrome":
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(false);
                webDriver = new ChromeDriver(options);
                break;
            case "chromeHeadless":
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions headlessOptions = new ChromeOptions();
                headlessOptions.setHeadless(true);
                webDriver = new ChromeDriver(headlessOptions);
                break;
            case "firefox":
                ChromeDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(false);
                webDriver = new FirefoxDriver(firefoxOptions);
                break;
            case "firefoxHeadless":
                ChromeDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                FirefoxOptions headlessFirefoxOptions = new FirefoxOptions();
                headlessFirefoxOptions.setHeadless(true);
                webDriver = new FirefoxDriver(headlessFirefoxOptions);
                break;
            default:
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions defaultBrowserOptions = new ChromeOptions();
                defaultBrowserOptions.setHeadless(false);
                webDriver = new ChromeDriver(defaultBrowserOptions);
                break;
        }
        return webDriver;
    }
}