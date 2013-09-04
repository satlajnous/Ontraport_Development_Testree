package com.ontraport.app.pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.Common;

public class Message_CreateEmail extends AbstractPage
{

    protected String   url = "/#!/message/create&type=e-mail";

    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    private WebElement inputMessageName;
	
	@FindBy(how = How.XPATH, using = "//div[label[normalize-space(text())='Send out name']]/descendant::input")
    private WebElement inputSendOutName;
	
	@FindBy(how = How.XPATH, using = "//div[label[normalize-space(text())='Reply to email']]/descendant::input")
    private WebElement inputReplyToEmail;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Mail From']]/descendant::button")
    private WebElement buttonMailFrom;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Mail From']]/descendant::li[1]/div")
    private WebElement selectMailFrom;

	@FindBy(how = How.XPATH, using = "//div[label[normalize-space(text())='Subject']]/descendant::input")
    private WebElement inputSubject;
	
	@FindBy(how = How.CSS, using="body")
    private WebElement inputBodyOfText;
	
	@FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
    private WebElement buttonSave;
	
	 public Message_ListAll newEmailMsg (String msgName, String sendOutName, String replyToEmail, String subject, String bodyText) throws Exception
	    {
		 /*Time is taken in loading of page and without Thread.sleep()the fields are not entered with values and an
     	exception is thrown */
	        try {
	        	Thread.sleep(3000);  					
	        	inputMessageName.sendKeys(msgName);	  
	            Thread.sleep(1000);
	            inputSendOutName.sendKeys(sendOutName);	
	            Thread.sleep(1000);
	            inputReplyToEmail.sendKeys(replyToEmail);
	            Thread.sleep(1000);
	            buttonMailFrom.click();	            
	            selectMailFrom.click();	            
	            inputSubject.sendKeys(subject);	            
	            driver.switchTo().frame(1);	    		
	    		inputBodyOfText.sendKeys(bodyText);	    		
	    		driver.switchTo().defaultContent();	 	    		
	    		/*Message_Edit msgEdit= new Message_Edit();
	    		msgEdit.editInsertMergeField(insertOption);*/
	            buttonSave.click();
	            Thread.sleep(3000);
	        } catch (NoSuchElementException e) {
	            e.printStackTrace();
	        }
	        return PageFactory.initElements(driver, Message_ListAll.class);
	    }


}