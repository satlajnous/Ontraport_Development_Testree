package com.ontraport.app.tools;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.parts.ActionsMenu;
import com.ontraport.app.parts.ColumnManager;
import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.parts.GroupManager;
import com.ontraport.app.parts.GroupSelector;
import com.ontraport.app.parts.SearchBox;
import com.ontraport.app.parts.SiteMenu;
import com.ontraport.app.parts.UserMenu;
import com.ontraport.app.parts.WorkMenu;

public abstract class AbstractPage {
	protected String url = "http://app.ontraport.com";

	@FindBy(how = How.XPATH, using = "//li[@data-elemkey='user']/a")
	protected WebElement linkUsermenu;

	@FindBy(how = How.XPATH, using = "//a[@href='Login/logout']")
	protected WebElement linkLogout;

	@FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_group_actions']/span[text()='Actions']")
	protected WebElement linkActionsMenu;

	@FindBy(how = How.XPATH, using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' chrome-action-bar-search ')]//input[@type='search']")
	protected WebElement inputSearchBox;

	@FindBy(how = How.XPATH, using = "//div[label[text()='RECORDS']]/descendant::button")
	protected WebElement buttonRecords;

	@FindBy(how = How.XPATH, using = "//div[label[text()='RECORDS']]/descendant::li/div[text()='100']")
	protected WebElement inputSetRecordToHundred;

	@FindBy(how = How.XPATH, using = "//button//span[text()='Preview']")
	private WebElement buttonPreview;

	@FindBy(how = How.XPATH, using = "//html//body")
	private WebElement newWindowBody;
	
	@FindBy(how = How.XPATH, using = "//table[@class='ussr-table-striped']//tr//td[1]")
	private List<WebElement> tableItemList;

	protected DialogBox dialogBox;
	protected WebDriver driver;
	protected UserMenu userMenu;
	protected SiteMenu siteMenu;
	protected WorkMenu workMenu;
	protected SearchBox searchBox;
	protected GroupManager groupManager;
	protected GroupSelector groupSelector;
	protected ActionsMenu actionsMenu;
	protected ColumnManager columnManager;

	public AbstractPage() {
		driver = AbstractSuite.getDriver();
	}

	public AbstractPage init() {
		// TODO: dialog
		dialogBox = (DialogBox) new DialogBox().init();
		userMenu = (UserMenu) new UserMenu().init();
		siteMenu = (SiteMenu) new SiteMenu().init();
		workMenu = (WorkMenu) new WorkMenu().init();
		searchBox = (SearchBox) new SearchBox().init();
		groupManager = (GroupManager) new GroupManager().init();
		groupSelector = (GroupSelector) new GroupSelector().init();
		actionsMenu = (ActionsMenu) new ActionsMenu().init();
		columnManager = (ColumnManager) new ColumnManager().init();
		return PageFactory.initElements(driver, this.getClass());
	}

	public AbstractPage open(String url) throws Exception {
		driver.get(this.url + url);
		Common.waitForPage(driver, 60);
		return null;
	}

	public AbstractPage back() {
		driver.navigate().back();
		return null;
	}

	public ActionsMenu openActionsMenu() throws Exception {
		linkActionsMenu.click();
		return PageFactory.initElements(driver, ActionsMenu.class);
	}

	public UserMenu openUserMenu() throws Exception {
		linkUsermenu.click();
		return PageFactory.initElements(driver, UserMenu.class);
	}

	public AbstractPage search() throws Exception {
		inputSearchBox.click();
		return null;
	}

	public AbstractPage logout() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Integer.valueOf("600"));
		if (linkUsermenu.isDisplayed())
			linkUsermenu.click();
		wait.until(ExpectedConditions.visibilityOf(linkLogout));
		linkLogout.click();
		Common.waitForPage(driver, 60);
		open("/login.html");
		return null;
	}

	/*
	 * Adding more Page Object Common Utility methods
	 */

	/*
	 * 1. To get the label name of any text box element
	 */
	public WebElement getTextBoxOnTheLabel(
			List<WebElement> txtFieldParentElements, String textboxLabel)
			throws Exception {
		Iterator<WebElement> itr = txtFieldParentElements.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			String textfromApp = eachParentElement.getText().trim();
			System.out.println(textfromApp);
			if (textfromApp.equalsIgnoreCase(textboxLabel)) {
				return eachParentElement.findElement(By
						.xpath(".//input[@type='text']"));
			}

		}

		throw new Exception("No Label Match found");
	}

	/*
	 * 2. To select an item from drop down by typing the name of the item in
	 * input text box
	 */
	public void selectDropDownByTyping(WebElement selectButtonChoose,
			WebElement selectInputChoose, List<WebElement> selectListDIVChoose,
			String option) {
		System.out
				.println("**************************************************************");

		System.out.println("option:" + option);

		selectButtonChoose.click();
		selectInputChoose.sendKeys(option);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("*************ChildItems************");
		System.out.println("Number:" + selectListDIVChoose.size());

		for (int i = 0; i < selectListDIVChoose.size(); i++) {
			selectButtonChoose.sendKeys(Keys.ARROW_DOWN);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> childEle = selectListDIVChoose;
			Iterator<WebElement> childEleIterator = childEle.iterator();
			while (childEleIterator.hasNext()) {
				WebElement webElement = (WebElement) childEleIterator.next();
				System.out.println(webElement.getText());
				if (webElement.getText().trim().equalsIgnoreCase(option.trim())) {
					webElement.click();
					return;
				}

			}
		}

	}
	
	

	public void selectDropDownByTyping (WebElement parentElement, WebElement selectButtonChoose, WebElement selectInputChoose, String selectListElementXPath, String option){
		System.out.println("**************************************************************");


		System.out.println("option:" + option);

		selectButtonChoose.click();
		selectInputChoose.sendKeys(option);


		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.xpath("//div[div[text()='"+ruleDesc+"']]//div[input[normalize-space(@placeholder)='"+placeHolder+"']]/descendant::li/div[normalize-space(text())='"+option+"']")).click();
		//List<WebElement> childEleP = driver.findElements(By.xpath("//div[input[normalize-space(@placeholder)='"+placeHolder+"']]//li/div"));
		//Iterator<WebElement> childEleIteratorP = childEleP.iterator();
		System.out.println("*************ChildItems************");
		List<WebElement> selectListDIVChoose = parentElement.findElements(By.xpath(selectListElementXPath));
		System.out.println("Number:"+selectListDIVChoose .size());

		for (int i = 0; i < selectListDIVChoose.size(); i++) {
			selectButtonChoose.sendKeys(Keys.ARROW_DOWN);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> childEle = selectListDIVChoose;
			Iterator<WebElement> childEleIterator = childEle.iterator();
			while (childEleIterator.hasNext()) {
				WebElement webElement = (WebElement) childEleIterator.next();
				System.out.println(webElement.getText());
				if (webElement.getText().trim().equalsIgnoreCase(option.trim())){
					webElement.click();
					return;
				}
			}
		}
	}
		
			
			

	/*
	 * 3. To check the presence of element in a list after creation or
	 * modification
	 */
	public boolean isElementPresent(String name) {
		try {
			driver.findElement(By.xpath("//*[normalize-space(text())='"
					+ (name) + "']"));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * 4. Set to 100 records on the page
	 */
	public void setHundredRecordsPerPage() {
		try {
			int sizeOfList= tableItemList.size();
			if(sizeOfList>6){
			buttonRecords.click();
			Thread.sleep(2000);
			inputSetRecordToHundred.click();
			Thread.sleep(5000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 5. Handing Pop up windows in FireFox
	 */
	public String windowHandle() throws Exception {
		String mainwindhandle = driver.getWindowHandle();
		String emailText2 = null;
		buttonPreview.click();
		Thread.sleep(3000);
		Set s = driver.getWindowHandles();
		Iterator ite = s.iterator();
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			// Switching to the pop-up window
			if (!popupHandle.contains(mainwindhandle)) {
				driver.switchTo().window(popupHandle);
				String pageTitle = driver.getTitle();
				System.out.println("Page Title: " + pageTitle);
				emailText2 = newWindowBody.getText().trim();
				System.out.println("Email Message at Preview Page: "
						+ emailText2);
				driver.switchTo().defaultContent();
				driver.switchTo().window(mainwindhandle);
			}
		}
		return emailText2;
	}
}
