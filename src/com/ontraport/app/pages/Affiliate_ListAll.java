package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Affiliate_ListAll extends AbstractPage {

	protected String url = "/#!/affiliate/listAll";

	@FindBy(how = How.XPATH, using = "//span[@class='ussr-theme-blue1']/span[text()='Global Settings']")
	private WebElement linkGlobalSettings;
	
	@FindBy(how = How.XPATH, using = "//span[@class='ussr-theme-blue1']/span[text()='Programs']")
	private WebElement linkPrograms;

	public Affiliate_Settings clickGlobalSettings() throws Exception {
		linkGlobalSettings.click();
		return PageFactory.initElements(driver, Affiliate_Settings.class);
	}
	
	public AffiliateProgram_ListAll clickPrograms() throws Exception {
		linkPrograms.click();
		return PageFactory.initElements(driver, AffiliateProgram_ListAll.class);
	}
	
}