package com.ontraport.app.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactInfo {
	private static Properties prop = new Properties();

    public static void main ( String[] args )
    {
        try
        {
            prop.load(new FileInputStream("contacts.xml"));
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
}
