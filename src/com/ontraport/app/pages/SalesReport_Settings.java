package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class SalesReport_Settings extends AbstractPage {

	protected String   url = "/#!/sales_report/settings";

	@FindBy(how = How.XPATH, using = "//span[@class='ussr-icon ussr-icon-textfield']")
	private WebElement linkGateWay;

	@FindBy(how = How.XPATH, using = "//a//span[text()='Messages']")
	private WebElement linkRechargeSettings;
	
	public Gateway_ListAll clickGateways (){
		try{
			linkGateWay.click();
		}catch (Exception e){
			
		}
		
		return PageFactory.initElements(driver, Gateway_ListAll.class);
	}
	
}
