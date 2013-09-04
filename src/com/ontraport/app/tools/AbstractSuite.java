package com.ontraport.app.tools;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.ontraport.app.pages.Login;

public abstract class AbstractSuite
{
    protected static WebDriver driver;
    protected Common    common;

    public static WebDriver getDriver ()
    {
        return driver;
    }

    @BeforeClass
    public static void beforeSuite () throws Exception
    {
        Common common = new Common();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.cache.disk.enable", false);
        profile.setPreference("browser.cache.memory.enable", false);
        profile.setPreference("browser.cache.offline.enable", false);
        profile.setPreference("network.http.use-cache", false);
        driver = new FirefoxDriver(profile);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().maximize();
        Login login = (Login) new Login().init();
        login.open(Login.url);
        System.out.println(common.prop("USERNAME"));
        login.as(common.prop("USERNAME"), common.prop("PASSWORD"));
        Common.waitForPage(driver, 60);
    }

    @AfterClass
    public static void afterSuite ()
    {
        driver.close();
        driver.quit();
    }

}
