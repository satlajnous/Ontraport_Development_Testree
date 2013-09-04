package com.ontraport.app.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common
{
    private static Properties prop = new Properties();

    public Common ()
    {
        try
        {
            InputStream file = this.getClass().getResourceAsStream("/Common.properties");
            prop.load(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String prop ( String key ) throws Exception
    {
        return prop.getProperty(key);
    }

    public static boolean waitForPage ( WebDriver driver, int timeOutInSeconds )
    {
        boolean jQcondition = false;
        try
        {
            new WebDriverWait(driver, timeOutInSeconds)
            {
            }.until(new ExpectedCondition<Boolean>()
            {
                @Override
                public Boolean apply ( WebDriver driverObject )
                {
                    return (Boolean) ( (JavascriptExecutor) driverObject ).executeScript("return jQuery.active === 0");
                }
            });
            jQcondition = (Boolean) ( (JavascriptExecutor) driver )
                    .executeScript("return window.jQuery != undefined && jQuery.active === 0");
            return jQcondition;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return jQcondition;
    }

}
