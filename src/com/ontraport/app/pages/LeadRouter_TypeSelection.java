package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class LeadRouter_TypeSelection extends AbstractPage
{
	@FindBy(how = How.XPATH, using = "//div[div[a[text()='Round Robin']]]/descendant::a/button")
    private WebElement create_RR;
	
	@FindBy(how = How.XPATH, using = "//div[div[a[text()='Weighted Random']]]/descendant::a/button")
    private WebElement create_WR;
	
	public LeadRouter_Create create_RR () throws Exception
	{
		create_RR.click();
        return PageFactory.initElements(driver, LeadRouter_Create.class);
    }
	public LeadRouter_Create create_WR () throws Exception
	{
		create_WR.click();
        return PageFactory.initElements(driver, LeadRouter_Create.class);
    }
}
