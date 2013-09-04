package com.ontraport.app.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.Common;

public class Message_CreateSms extends AbstractPage
{

    protected String   url = "/#!/message/create&type=sms";

    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    private WebElement inputMessageName;
    
    @FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
    private WebElement buttonSave;
    
	@FindBy(how = How.XPATH, using = "//div[@class='ussr-form-input-wrapper']//textarea")
    private WebElement inputSMSText;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Insert Merge Field']]/descendant::button")
    private WebElement selectButtonInsertMergeField;
	
	@FindBy(how = How.XPATH, using = "//div//input[normalize-space(@placeholder)='Insert Merge Field']")
    private WebElement selectInputInsertMergeField;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Insert Merge Field']]//li/div")
    private List<WebElement> selectListInsertMergeField;
	
    public Message_ListAll newSMSMsg (String msgName, String bodyText, String mergeField) throws Exception
    {
    	/*Time is taken in loading of page and without Thread.sleep()the fields are not entered with values and an
     	exception is thrown */
        try {
        	Thread.sleep(3000);
            inputMessageName.sendKeys(msgName);
            Thread.sleep(1000);
            inputSMSText.sendKeys(bodyText);
            Thread.sleep(1000);
            selectDropDownByTyping(selectButtonInsertMergeField, selectInputInsertMergeField, selectListInsertMergeField, mergeField);
            Thread.sleep(1000);
            buttonSave.click();
            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, Message_ListAll.class);
    }

}