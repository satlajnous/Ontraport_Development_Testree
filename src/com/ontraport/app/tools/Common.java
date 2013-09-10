package com.ontraport.app.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
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
            //e.printStackTrace();
        }
        return jQcondition;
    }
    
    
    /**
     * Get the text from the text box
     * @param inputTypeWebElement
     * @return
     */
    public static String getValueOfTextBox (WebElement inputTypeWebElement){
    	return inputTypeWebElement.getAttribute("value").trim();
    }
    
    
    /**
     * Gets the first selected option from the drop down
     * @param selectWebElement
     * @return
     */
    public static String getSelectedValueFromDropDown (WebElement selectWebElement){
    	Select selectBox = new Select(selectWebElement);
    	String selectedOption = selectBox.getFirstSelectedOption().getText();
    	return selectedOption;
    }
    
    
    public static boolean verifyTwoStringsAreEqual (String s1, String s2){
    	return s1.trim().equalsIgnoreCase(s2.trim());
    }
    
    public static boolean verifyStringStartsWith (String s1, String s2){
    	return s1.trim().startsWith(s2.trim());
    }
    
  
    
    /**
     * Used for asserting the values in text box
     * @param inputTypeWebElement
     * @param expectedValue
     * @return
     */
    public static boolean verifyTextBoxValue (WebElement inputTypeWebElement, String expectedValue){
    	boolean flag = false;
    	try {
    		flag = verifyTwoStringsAreEqual (getValueOfTextBox(inputTypeWebElement), expectedValue);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return flag;
    }
    
    
    /**
     * Used for asserting the values in text box
     * @param inputTypeWebElement
     * @param expectedValue
     * @return
     */
    public static boolean verifySelectDropDownValue (WebElement selectWebElement, String expectedValue){
    	boolean flag = false;
    	try {
    		flag = verifyTwoStringsAreEqual (getSelectedValueFromDropDown(selectWebElement), expectedValue);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return flag;
    }
    
    
    /**
     * Used for asserting the values in text box
     * @param inputTypeWebElement
     * @param expectedValue
     * @return
     */
    public static boolean verifyTextBoxValueStartsWith (WebElement inputTypeWebElement, String expectedValue){
    	boolean flag = false;
    	try {
    		flag = verifyStringStartsWith (getValueOfTextBox(inputTypeWebElement), expectedValue);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return flag;
    }
    
    
    /**
     * Used for asserting the values in text box
     * @param inputTypeWebElement
     * @param expectedValue
     * @return
     */
    public static boolean verifySelectDropDownValueStartsWith (WebElement selectWebElement, String expectedValue){
    	boolean flag = false;
    	try {
    		flag = verifyStringStartsWith (getSelectedValueFromDropDown(selectWebElement), expectedValue);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return flag;
    }
    
    /**
     * Used to scroll to the element visible
     * @param driver
     * @param targetWebElement
     */
    public static void scrollTillElementVisisble (WebDriver driver, WebElement targetWebElement){
    	
	    
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetWebElement);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

}
