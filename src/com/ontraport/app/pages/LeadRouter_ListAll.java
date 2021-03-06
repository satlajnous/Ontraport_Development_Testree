package com.ontraport.app.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class LeadRouter_ListAll extends AbstractPage
{

    protected String   url = "/#!/lead_rout/listAll";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;
    
    @FindBy(how = How.XPATH, using = "//*[@id='panelbuttonbar']/div//span[text()='New Lead Router']")
    private WebElement newLeadRouterButton;

    @FindBy(how = How.XPATH, using = "//tr[@class='sem-collection-header-display']//a[.='Router Name']")
    private WebElement routerNameColumn;
    
    @FindBy(how = How.CSS, using = "span.ussr-icon.ussr-icon-checkbox-empty")
    private WebElement checkBox;
    
    @FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_group_actions']")
    private WebElement linkActions;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-chrome-panel-action-drawer-content ussr-texture-flat-light']")
    private WebElement buttonDeleteRouter;
    
    public LeadRouter_ListAll clickActions () throws Exception
    {	linkActions.click();
     	Thread.sleep(1000);
        return PageFactory.initElements(driver, LeadRouter_ListAll.class);
    }
    public LeadRouter_TypeSelection newLeadRouter () throws Exception
    {
        
        try {
        	newLeadRouterButton.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, LeadRouter_TypeSelection.class);
    }
    public AbstractPage selectRouters () throws InterruptedException
    {	
    	Actions builder = new Actions(driver);
    	builder.moveToElement(routerNameColumn).build().perform();
    	builder.moveToElement(checkBox).click().build().perform();

        return PageFactory.initElements(driver, this.getClass());
    }
    
    public boolean isElementDisplayed(){
    	boolean isShown= buttonDeleteRouter.isDisplayed();
    	System.out.println("Is displayed? "+isShown);
    	return isShown;
    }

}