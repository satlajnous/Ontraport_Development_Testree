package com.ontraport.app.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Message_Edit extends AbstractPage
{

    protected String   url = "/#!/message/edit&id=";

    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    private WebElement inputTextMsgName;
    
    @FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
    private WebElement buttonSave;
    
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
	
	@FindBy(how = How.XPATH, using = "//*[@id='ussr-chrome-panel-pane']/div[4]/div[3]/div/div/div[2]")
    private WebElement draggablePartOfScrollbar;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Insert Merge Field']]/descendant::button")
    private WebElement selectButtonInsertMergeField;
	
	@FindBy(how = How.XPATH, using = "//div//input[normalize-space(@placeholder)='Insert Merge Field']")
    private WebElement selectInputInsertMergeField;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Insert Merge Field']]//li/div")
    private List<WebElement> selectListDIVInsertMergeField;
	
	@FindBy(how = How.XPATH, using = "//button//span[text()='Cancel']")
    private WebElement buttonCancel;
	
	
    public Message_ListAll editMessageName (String msgName) throws Exception
    {	inputTextMsgName.clear();
    	inputTextMsgName.sendKeys(msgName);
    	buttonSave.click();
        return PageFactory.initElements(driver, Message_ListAll.class);
    }
    
    public Message_ListAll editMessageSendOutName (String sendOutName) throws Exception
    {	
    	inputSendOutName.clear();
    	inputSendOutName.sendKeys(sendOutName);
    	buttonSave.click();
        return PageFactory.initElements(driver, Message_ListAll.class);
    }
    
    public String getSendOutName(){
    	String sendOutName= inputSendOutName.getAttribute("value");
    	System.out.println("Previous Send Out Name: "+sendOutName);
    	return sendOutName;
    }
    
    public Message_ListAll editMessageReplyToEmail (String replyToEmail) throws Exception
    {	
    	inputReplyToEmail.clear();
    	inputReplyToEmail.sendKeys(replyToEmail);
    	buttonSave.click();
        return PageFactory.initElements(driver, Message_ListAll.class);
    }
    
    public String getReplyToEmail(){
    	String replyToEmail= inputReplyToEmail.getAttribute("value");
    	System.out.println("Previous ReplyToEmail: "+replyToEmail);
    	return replyToEmail;
    }
    
    public Message_ListAll editMessageSubject (String subject) throws Exception
    {	
    	inputSubject.clear();
    	inputSubject.sendKeys(subject);
    	buttonSave.click();
        return PageFactory.initElements(driver, Message_ListAll.class);
    }
    
    public String getSubject(){
    	String subject= inputSubject.getAttribute("value");
    	System.out.println("Previous subject: "+subject);
    	return subject;
    }
    
    public Message_ListAll editMessageBody (String bodyText) throws Exception
    {	
    	driver.switchTo().frame(1);    
    	inputBodyOfText.clear();
    	inputBodyOfText.sendKeys(bodyText);    	
    	driver.switchTo().defaultContent();
    	buttonSave.click();
        return PageFactory.initElements(driver, Message_ListAll.class);
    }
    
    public String getTextFromFrame() throws Exception{
    	driver.switchTo().frame(1);
    	String bodyText= inputBodyOfText.getText().trim();
    	driver.switchTo().defaultContent();
    	System.out.println("Previous BodyText: "+bodyText);
    	return bodyText;
    }
    
   /* public Message_ListAll editInsertMergeField (String option) throws Exception
    {	
    	scrollUntillElementFound(draggablePartOfScrollbar,selectButtonInsertMergeField);
    	selectDropDownByTyping(selectButtonInsertMergeField, selectInputInsertMergeField, selectListDIVInsertMergeField, option);
        return PageFactory.initElements(driver, Message_ListAll.class);
    }*/
    
    public Message_ListAll clickCancel()throws Exception
    {	
    	buttonCancel.click();
        return PageFactory.initElements(driver, Message_ListAll.class);
    }
    
    public Message_Edit enterTextMessage (String bodyText) throws Exception
    {	
    	driver.switchTo().frame(1);    
    	inputBodyOfText.clear();
    	inputBodyOfText.sendKeys(bodyText);    	
    	driver.switchTo().defaultContent();
        return PageFactory.initElements(driver, Message_Edit.class);
    }
    
    
    
   
}