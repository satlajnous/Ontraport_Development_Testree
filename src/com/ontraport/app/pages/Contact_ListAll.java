package com.ontraport.app.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.parts.ColumnManager;
import com.ontraport.app.tools.AbstractPage;

public class Contact_ListAll extends AbstractPage {

	protected String url = "/#!/contact/listAll";

	@FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_new']")
	private WebElement linkToCreate;

	@FindBy(how = How.XPATH, using = "//tr[@class='sem-collection-header-display']//a[.='Add Column']")
	private WebElement addColumn;

	@FindBy(how = How.XPATH, using = "//tr[@class='sem-collection-header-display']//a[.='Zip Code']")
	private WebElement zipcodeColumn;

	@FindBy(how = How.XPATH, using = "//a[text()='Zip Code']/following-sibling::div/a[3]/span")
	private WebElement pencil;

	@FindBy(how = How.CSS, using = "span.ussr-icon.ussr-icon-checkbox-empty")
	private WebElement checkBox;

	@FindBy(how = How.XPATH, using = "//tr[@class='sem-collection-header-display']//a[.='First Name']")
	private WebElement firstNameColumn;

	@FindBy(how = How.XPATH, using = "//a//span[text()='Messages']")
	private WebElement linkMessages;

	@FindBy(how = How.XPATH, using = "//a//span[text()='Sales']")
	private WebElement linkSales;

	@FindBy(how = How.XPATH, using = "//a//span[text()='Rules']")
	private WebElement linkRules;
	
	@FindBy(how = How.XPATH, using = "//a//span[text()='Smart Forms']")
	private WebElement linkSmartForms;
	
	/*
	 * @FindBy(how = How.XPATH, using = "//a//span[text()='Settings']") private
	 * WebElement linkSettings;
	 */

	@FindBy(how = How.XPATH, using = "//a[@href='#!/sales_report/settings']")
	private WebElement linkSettings;
	
	@FindBy(how = How.XPATH, using = "//li[@class='ussr-header-nav-option-user']/a")
	private WebElement linkUserNav;
	
	@FindBy(how = How.XPATH, using = "//a[@href='#!/account/view']")
	private WebElement linkUserNavAdmin;
	
	@FindBy(how = How.XPATH, using = "//a//span[text()='Sequences']")
	private WebElement linkSequences;

	@FindBy(how = How.XPATH, using = "//*[@id='ussr-chrome-panel-pane']/div[1]/div[1]")
     private WebElement displayPageHeader;

	
	public SalesReport_Settings navSalesReport() throws Exception {
		try {
			linkSales.click();
			Thread.sleep(5000);
			linkSettings.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, SalesReport_Settings.class);
	}
	
		public Sequence_ListAll navSequences() throws Exception {
				try {
					linkSequences.click();
				} catch (NoSuchElementException e) {
					e.printStackTrace();
				}
				return PageFactory.initElements(driver, Sequence_ListAll.class);
			}


	public Rule_ListAll navRules() throws Exception {
		try {
			linkRules.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, Rule_ListAll.class);
	}

	public Message_ListAll navMessages() throws Exception {
		try {
			linkMessages.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, Message_ListAll.class);
	}
	
	
	public SmartForm_ListAll navSmartForms() throws Exception {
		try {
			linkSmartForms.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, SmartForm_ListAll.class);
	}
	
	public Account_View navAdmin() throws Exception {
		try {
			linkUserNav.click();
			Thread.sleep(1000);
			linkUserNavAdmin.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, Account_View.class);
	}


	public ColumnManager addColumn() throws Exception {

		try {
			addColumn.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, ColumnManager.class);
	}

	public Contact_Create create() throws Exception {

		try {
			linkToCreate.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, Contact_Create.class);
	}
	
		public String getTextHomePage () throws Exception{
		   	String pageHeader= displayPageHeader.getText().trim();
	    	System.out.println("Home Page Header: "+pageHeader);
		    	return pageHeader;
		   }


	public AbstractPage selectContacts() throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(firstNameColumn).click().build().perform();
		builder.moveToElement(checkBox).click().build().perform();
		// deleteButton.click();
		return PageFactory.initElements(driver, this.getClass());
	}

	public AbstractPage selectColumn() throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(zipcodeColumn).click().build().perform();
		builder.moveToElement(pencil).click().build().perform();
		// deleteButton.click();
		return PageFactory.initElements(driver, this.getClass());
	}

}
