package com.ontraport.app.pages;


import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Rule_Create extends AbstractPage
{

	protected String   url = "/#!/rule/create";
	
	@FindBy(how = How.XPATH, using = "//input[@type='text']")
    private WebElement inputRuleName;
	
	@FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
    private WebElement buttonSave;
		
	@FindBy(how = How.XPATH, using = "//div[div[text()='WHEN THIS HAPPENS:']]//div[input[normalize-space(@placeholder)='Select Trigger...']]/descendant::button")
    private WebElement selectButtonWhenThisHappensType;
	
	@FindBy(how = How.XPATH, using = "//div[div[text()='WHEN THIS HAPPENS:']]//div//input[normalize-space(@placeholder)='Select Trigger...']")
    private WebElement selectInputWhenThisHappensType;
	
	@FindBy(how = How.XPATH, using = "//div[div[text()='WHEN THIS HAPPENS:']]//div[input[normalize-space(@placeholder)='Select Trigger...']]//li/div")
    private List<WebElement> selectListWhenThisHappensType;
	
	@FindBy(how = How.XPATH, using = "//div[div[text()='THEN DO THIS:']]//div[input[normalize-space(@placeholder)='Select Action...']]/descendant::button")
    private WebElement selectButtonThenDoThisType;
	
	@FindBy(how = How.XPATH, using = "//div[div[text()='THEN DO THIS:']]//div//input[normalize-space(@placeholder)='Select Action...']")
    private WebElement selectInputThenDoThisType;
	
	@FindBy(how = How.XPATH, using = "//div[div[text()='THEN DO THIS:']]//div[input[normalize-space(@placeholder)='Select Action...']]//li/div")
    private List<WebElement> selectListThenDoThisType;
		
	 public Rule_ListAll newRuleWhenThisHappens_ContactIsCreated (String ruleName, String whenThisHappensoption, String thenDoThisOption) throws Exception
	 {	
	        try {
	            inputRuleName.sendKeys(ruleName);
	            Thread.sleep(3000);
	            
				selectDropDownByTyping(selectButtonWhenThisHappensType, selectInputWhenThisHappensType, selectListWhenThisHappensType, whenThisHappensoption); 
	            Thread.sleep(2000);
	            
				selectDropDownByTyping(selectButtonThenDoThisType, selectInputThenDoThisType, selectListThenDoThisType, thenDoThisOption); 
	            Thread.sleep(2000);
	            buttonSave.click();
	        } catch (NoSuchElementException e) {
	            e.printStackTrace();
	        }
	        return PageFactory.initElements(driver, Rule_ListAll.class);
	    }
	 

}