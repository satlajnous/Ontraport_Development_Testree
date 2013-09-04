package com.ontraport.app.parts;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.pages.Affiliate_ListAll;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.tools.AbstractPart;

public class SiteMenu extends AbstractPart {
	@FindBy(how = How.XPATH, using = "//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']")
	private WebElement contactSettingsLink;

	@FindBy(how = How.XPATH, using = "//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")
	private WebElement contactLink;

	@FindBy(how = How.XPATH, using = "//aside[@id='ussr-chrome-sidebar']//span[.='Partners']")
	private WebElement linkPartners;

	public Contact_Settings contact_Settings() throws Exception {

		try {
			contactSettingsLink.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, Contact_Settings.class);
	}

	public Contact_ListAll contacts() throws Exception {

		try {
			contactLink.click();

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, Contact_ListAll.class);
	}

	public DialogBox contactsToDialog() throws Exception {

		try {
			contactLink.click();

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, DialogBox.class);
	}

	public Affiliate_ListAll clickPartners() throws Exception {

		try {
			linkPartners.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, Affiliate_ListAll.class);
	}
}
