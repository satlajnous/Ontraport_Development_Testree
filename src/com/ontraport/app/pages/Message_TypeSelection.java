package com.ontraport.app.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Message_TypeSelection extends AbstractPage
{

    protected String   url = "/#!/message/typeSelection";

    @FindBy(how = How.XPATH, using = "//div[div[*/text()='E-Mail']]/descendant::button[*[normalize-space(text())='Create']]")
    private WebElement linkToCreateEmailMsg;
    
    @FindBy(how = How.XPATH, using = "//div[div[*/text()='Postcard']]/descendant::button[*[normalize-space(text())='Create']]")
    private WebElement linkToCreatePostcardMsg;
    
    @FindBy(how = How.XPATH, using = "//div[div[*/text()='Task']]/descendant::button[*[normalize-space(text())='Create']]")
    private WebElement linkToCreateTaskMsg;
    
    @FindBy(how = How.XPATH, using = "//div[div[*/text()='SMS']]/descendant::button[*[normalize-space(text())='Create']]")
    private WebElement linkToCreateSMSMsg;
    
    public Message_CreateEmail emailCreate () throws Exception
    {
        
        try {
        	linkToCreateEmailMsg.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, Message_CreateEmail.class);
    }
    
    public Message_CreatePostcard postcardCreate () throws Exception
    {
        
        try {
        	linkToCreatePostcardMsg.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, Message_CreatePostcard.class);
    }
    
    public Message_CreateTask taskCreate () throws Exception
    {
        
        try {
        	linkToCreateTaskMsg.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, Message_CreateTask.class);
    }
    
    public Message_CreateSms smsCreate () throws Exception
    {
        
        try {
        	linkToCreateSMSMsg.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, Message_CreateSms.class);
    }
   

}