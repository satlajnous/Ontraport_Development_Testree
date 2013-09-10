package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class QueuedMessage_ListAll extends AbstractPage
{

    protected String   url = "/#!/queued_message/listAll";

    @FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_group_actions']")
    private WebElement linkActions;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-chrome-panel-action-drawer-content ussr-texture-flat-light']")
    private WebElement buttonCancel;
    
  

    public QueuedMessage_ListAll clickActions () throws Exception
    {	
    	linkActions.click();
    	Thread.sleep(1000);
        return PageFactory.initElements(driver, QueuedMessage_ListAll.class);
    }
    
    public boolean isElementDisplayed(){
    	boolean isShown= buttonCancel.isDisplayed();
    	System.out.println("Is displayed? "+isShown);
    	return isShown;
    }

}