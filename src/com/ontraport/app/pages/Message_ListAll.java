package com.ontraport.app.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.Common;

public class Message_ListAll extends AbstractPage
{
	
	protected String   url = "/#!/message/listAll";

    @FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_new']")
    private WebElement linkToCreate;

    public Message_TypeSelection create () throws Exception
    {
        
        try {
            linkToCreate.click();
            Thread.sleep(1000);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, Message_TypeSelection.class);
    }
    
    public Message_Edit editMessage (String msgName) throws Exception{
    	 WebElement linkElement = driver.findElement(By.xpath("//*[normalize-space(text())='" + (msgName) +"']"));
         Common.scrollTillElementVisisble(driver, linkElement);
         linkElement.click();
    	Thread.sleep(1000);
    	return PageFactory.initElements(driver, Message_Edit.class);
    }
}