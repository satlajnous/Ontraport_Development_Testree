package com.ontraport.app.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Contact_Settings extends AbstractPage
{
	@FindBy(how = How.XPATH, using = "//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")
    private WebElement fieldSettingsButton;
	
	@FindBy(how = How.XPATH, using = "//div[@class='ussr-list-item-desc' and text()='Route new leads to the right user.']")
    private WebElement linkLeadRouting;
	
	@FindBy(how = How.XPATH, using = "//div[@class='ussr-list-item-desc' and text()='Set your lead scoring rules.']")
    private WebElement linkLeadScoring;
	
	
	public Contact_Settings fieldSettings () throws Exception
    {
        
        try {
        	fieldSettingsButton.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, Contact_Settings.class);
    }
	public LeadRouter_ListAll leadRouting () throws Exception
    {
        
        try {
        	linkLeadRouting.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, LeadRouter_ListAll.class);
    }
	
	public LeadScoring_Edit leadScoring () throws Exception
    {
        
        try {
        	linkLeadScoring.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, LeadScoring_Edit.class);
    }
}
