package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.ontraport.app.tools.AbstractPage;

public class LandingPage_Edit extends AbstractPage {

	protected String url = "/#!/landing_page/edit&id=";

	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	private WebElement inputLandingPageName;

	@FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
	private WebElement buttonSave;

	@FindBy(how = How.XPATH, using = "//div[@class='menu_button_class']//input[@type='TEXT']")
	private WebElement inputPageTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='menu_button_class']//td[normalize-space(text())='Page URL:']")
	private WebElement clickPageURL;

	@FindBy(how = How.XPATH, using = "//div[@class='menu_button_class']//tr[td[normalize-space(text())='Page URL:']]//td[2]")
	private WebElement getpageURL;

	@FindBy(how = How.XPATH, using = "//div[@class='blue_box']//input[@name='domaintype']|//td[normalize-space(text())='Use a Hosted Domain']")
	private WebElement radioButtonHostedDomain;

	@FindBy(how = How.XPATH, using = "//div[@class='ontraport_components_dialog']/div[@class='blue_box']//td[normalize-space(text())='http://']/input[@class='inpt_text standard_input']")
	private WebElement inputTextInDomainPopUp;

	@FindBy(how = How.XPATH, using = "//div[@class='ontraport_components_dialog']/div[@class='blue_box']//tr[td[normalize-space(text())='http://']]//td[5]//input[@type='TEXT']")
	private WebElement inputInDomainPopUpURL;

	@FindBy(how = How.XPATH, using = "//div[normalize-space(text())='Page Alignment:']//select//option[@value='left']")
	private WebElement selectPageAlignmentLeft;
	
	@FindBy(how = How.XPATH, using = "//div[normalize-space(text())='Page Alignment:']//select")
	private WebElement pageAlignmentLeft;
	
	@FindBy(how = How.XPATH, using = "//div[@class='ontraport_components_dialog']//input[@class='btn2' and @value='Accept']")
    private WebElement buttonAcceptDialog;
	
	@FindBy(how = How.XPATH, using = "//div[@class='menu_button_class']//tr[td[text()='Page Size: ']]//td[2]//div")
    private WebElement linkPageSize;

	public String getLandingPageName() throws Exception {
		String lpName = inputLandingPageName.getAttribute("value").trim();
		System.out.println("LP Name: " + lpName);
		return lpName;
	}

	public void saveLP() {
		buttonSave.click();
	}

	public void changeLPName(String newName) throws Exception {
		inputLandingPageName.clear();
		inputLandingPageName.sendKeys(newName);
		Thread.sleep(1000);
	}

	public String getTextFromLPName() {
		String lpName = inputLandingPageName.getAttribute("value").trim();
		System.out.println("LP Name :" + lpName);
		return lpName;
	}

	public void enterPageTitle(String pageTitle) throws Exception {
		inputPageTitle.clear();
		inputPageTitle.sendKeys(pageTitle);
		Thread.sleep(1000);
	}

	public String getPageTitle() throws Exception {
		String pageTitle = inputPageTitle.getAttribute("value").trim();
		System.out.println("Page Title: " + pageTitle);
		return pageTitle;
	}

	public void enterNewPageURL(String newPageURL) throws Exception {
		clickPageURL.click();
		inputTextInDomainPopUp.click();
		inputTextInDomainPopUp.clear();
		inputTextInDomainPopUp.sendKeys(newPageURL);
		Thread.sleep(1000);
		inputInDomainPopUpURL.click();
		inputInDomainPopUpURL.clear();
		buttonAcceptDialog.click();
		Thread.sleep(1000);
	}

	public String getPageURL() throws Exception {
		String pageURLText = getpageURL.getText().trim();
		System.out.println("Page URL: " + pageURLText);
		return pageURLText;
	}

	public void setPageAlignment() throws Exception {
		Actions builder = new Actions(driver);
		builder.moveToElement(selectPageAlignmentLeft).click().build()
				.perform();
		Thread.sleep(1000);
	}
	
	public String getTextFromPageAlignment() {
		Select select = new Select(pageAlignmentLeft);
		WebElement option = select.getFirstSelectedOption();
		String pageAlign = option.getText();
		System.out.println("Page Alignment: " + pageAlign);
		return pageAlign;
	}
	
	public void setPageSize() throws Exception {
		linkPageSize.click();
		Thread.sleep(1000);
		
	}
	
	
}