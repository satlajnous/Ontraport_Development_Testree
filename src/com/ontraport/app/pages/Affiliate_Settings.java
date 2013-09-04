package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.ontraport.app.tools.AbstractPage;

public class Affiliate_Settings extends AbstractPage {
	protected String url = "/#!/affiliate/settings";

	@FindBy(how = How.XPATH, using = "//div[label[text()=\"I'll pay affiliates by\"]]//input")
	private WebElement selectButtonPayAffiliatesBy;

	@FindBy(how = How.XPATH, using = "//div[@class='ussr-component-drilldownselect-menu-wrapper']//li[div[text()='Paypal']]")
	private WebElement selectInputPaypal;

	@FindBy(how = How.XPATH, using = "//div[@class='ussr-component-drilldownselect-menu-wrapper']//li[div[text()='Check']]")
	private WebElement selectInputCheck;

	@FindBy(how = How.XPATH, using = "//div[@class='ussr-component-drilldownselect-menu-wrapper']//li[div[text()='Their Choice']]")
	private WebElement selectInputTheirChoice;

	@FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
	private WebElement buttonSave;

	@FindBy(how = How.XPATH, using = "//div[label[text()='Pay Threshold']]//input")
	private WebElement inputPayThreshold;

	@FindBy(how = How.XPATH, using = "//div[label[text()='Commission is paid to']]//input")
	private WebElement selectButtonCommissionPaidTo;

	@FindBy(how = How.XPATH, using = "//div[@class='ussr-component-drilldownselect-menu-wrapper']//li[div[text()='First Referrer']]")
	private WebElement selectInputFirstReferrer;

	@FindBy(how = How.XPATH, using = "//div[@class='ussr-component-drilldownselect-menu-wrapper']//li[div[text()='Last Referrer']]")
	private WebElement selectInputLastReferrer;

	@FindBy(how = How.XPATH, using = "//div[label[text()='Cookies will expire']]//input")
	private WebElement selectButtonCookiesExpire;

	@FindBy(how = How.XPATH, using = "//div[@class='ussr-component-drilldownselect-menu-wrapper']//li[div[text()='Never']]")
	private WebElement selectInputNever;

	@FindBy(how = How.XPATH, using = "//div[@class='ussr-component-drilldownselect-menu-wrapper']//li[div[text()='30 days']]")
	private WebElement selectInput30Days;

	@FindBy(how = How.XPATH, using = "//div[text()='Back']")
	private WebElement buttonBack;

	@FindBy(how = How.XPATH, using = "//button//span[text()='Cancel']")
	private WebElement buttonCancel;

	public Affiliate_ListAll globalSettings_Paypal() throws Exception {
		selectButtonPayAffiliatesBy.click();
		selectInputPaypal.click();
		buttonSave.click();
		return PageFactory.initElements(driver, Affiliate_ListAll.class);
	}

	public Affiliate_ListAll globalSettings_check() throws Exception {
		selectButtonPayAffiliatesBy.click();
		selectInputCheck.click();
		buttonSave.click();
		return PageFactory.initElements(driver, Affiliate_ListAll.class);
	}

	public Affiliate_ListAll globalSettings_TheirChoice() throws Exception {
		selectButtonPayAffiliatesBy.click();
		selectInputTheirChoice.click();
		buttonSave.click();
		return PageFactory.initElements(driver, Affiliate_ListAll.class);
	}

	public Affiliate_ListAll globalSettings_paythreshold(String key)
			throws Exception {
		inputPayThreshold.clear();
		inputPayThreshold.sendKeys(key);
		buttonSave.click();
		return PageFactory.initElements(driver, Affiliate_ListAll.class);
	}

	public Affiliate_ListAll globalSettings_FirstReferrer() throws Exception {
		selectButtonCommissionPaidTo.click();
		selectInputFirstReferrer.click();
		buttonSave.click();
		return PageFactory.initElements(driver, Affiliate_ListAll.class);
	}

	public Affiliate_ListAll globalSettings_LastReferrer() throws Exception {
		selectButtonCommissionPaidTo.click();
		selectInputLastReferrer.click();
		buttonSave.click();
		return PageFactory.initElements(driver, Affiliate_ListAll.class);
	}

	public Affiliate_ListAll globalSettings_NeverExpire() throws Exception {
		selectButtonCookiesExpire.click();
		selectInputNever.click();
		buttonSave.click();
		return PageFactory.initElements(driver, Affiliate_ListAll.class);
	}

	public Affiliate_ListAll globalSettings_30DaysExpire() throws Exception {
		selectButtonCookiesExpire.click();
		selectInput30Days.click();
		buttonSave.click();
		return PageFactory.initElements(driver, Affiliate_ListAll.class);
	}

	public Affiliate_ListAll globalSettings_Back() throws Exception {
		buttonBack.click();
		return PageFactory.initElements(driver, Affiliate_ListAll.class);
	}

	public Affiliate_ListAll globalSettings_Cancel() throws Exception {
		buttonCancel.click();
		return PageFactory.initElements(driver, Affiliate_ListAll.class);
	}

}