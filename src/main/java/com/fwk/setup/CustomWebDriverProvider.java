package com.fwk.setup;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import javax.annotation.Nonnull;

public class CustomWebDriverProvider implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        String currentBrowser = System.getProperty("browser", "");
        WebDriver webDriver;
        switch(currentBrowser) {
            case "chromeHeadless":
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions headlessOptions = new ChromeOptions();
                headlessOptions.addArguments("--headless=new");
                webDriver = new ChromeDriver(headlessOptions);
                break;
            case "firefox":
                ChromeDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                webDriver = new FirefoxDriver();
                break;
            case "firefoxHeadless":
                ChromeDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                FirefoxOptions headlessFirefoxOptions = new FirefoxOptions();
                headlessFirefoxOptions.addArguments("--headless=new");
                webDriver = new FirefoxDriver(headlessFirefoxOptions);
                break;
            default:
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                webDriver = new ChromeDriver();
                break;
        }
        return webDriver;
    }
}