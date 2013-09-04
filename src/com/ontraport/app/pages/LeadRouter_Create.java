package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class LeadRouter_Create extends AbstractPage
{

    protected String   url = "/#!/lead_rout/create";

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;
    
    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    private WebElement leadRouterName;
    
    @FindBy(how = How.XPATH, using = "//div/div[text()='Add User']")
    private WebElement addUser;
    
    @FindBy(how = How.XPATH, using = "//div[@class='target-rout ussr-component ussr-component-lead_rout_target ontraport_components_lead_rout_target'][1]//button")
    private WebElement userDropDown;

    @FindBy(how = How.XPATH, using = "//ul[@class='ussr-component-drilldownselect-ul']/li[1]/div")
    private WebElement firstUser;
    
    @FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
    private WebElement saveButton;
    
    @FindBy(how = How.XPATH, using = "  //div[@class='lead_rout_entry_row']//div[@class='header_box target-break ussr-component ussr-component-form_control_input_text ontraport_components_form_control_input_text ussr-form-cell ussr-component-form-control clearfix']//input")
    private WebElement percentOfLeads;
    
    public LeadRouter_Create sample () throws Exception
    {
        return PageFactory.initElements(driver, LeadRouter_Create.class);
    }
    public LeadRouter_ListAll fillOutRR (String routerName) throws Exception
    {
    	leadRouterName.click();
    	leadRouterName.clear();
    	leadRouterName.sendKeys(routerName);
    	//addUser.click();
    	userDropDown.click();
    	firstUser.click();
    	saveButton.click();
        return PageFactory.initElements(driver, LeadRouter_ListAll.class);
    }
    public LeadRouter_ListAll fillOutWR (String routerName) throws Exception
    {
    	leadRouterName.click();
    	leadRouterName.clear();
    	leadRouterName.sendKeys(routerName);
    	addUser.click();
    	userDropDown.click();
    	firstUser.click();
    	percentOfLeads.sendKeys("100");
    	saveButton.click();
        return PageFactory.initElements(driver, LeadRouter_ListAll.class);
    }

}