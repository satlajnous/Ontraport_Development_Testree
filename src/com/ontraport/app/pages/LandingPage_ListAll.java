package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class LandingPage_ListAll extends AbstractPage {

	protected String url = "/#!/landing_page/listAll";

	@FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_new']")
	private WebElement clickNewLandingPage;

	@FindBy(how = How.XPATH, using = "//div[@class='ussr-dialog-buttons']//span[normalize-space(text())='Ok']/parent::button")
	private WebElement buttonDialogOK;

	@FindBy(how = How.LINK_TEXT, using = "Copy")
	private WebElement linkCopy;
	
	@FindBy(how = How.LINK_TEXT, using = "Delete")
	private WebElement linkDelete;
	/*
	 * @FindBy(how = How.XPATH, using =
	 * "//div[@id='ussr-chrome-panel-pane']//table[@class='ussr-table-striped']"
	 * ) private WebElement landingPageNameColumn;
	 * 
	 * @FindBy(how = How.CSS, using = "span.ussr-icon.ussr-icon-checkbox-empty")
	 * private WebElement checkBox;
	 */

	public LandingPage_TypeSelection clickNewLandingPage() throws Exception {
		clickNewLandingPage.click();
		return PageFactory
				.initElements(driver, LandingPage_TypeSelection.class);
	}

	public LandingPage_Edit editLandingPage(String lpName) throws Exception {
		driver.findElement(
				By.xpath("//*[normalize-space(text())='" + (lpName) + "']"))
				.click();
		Thread.sleep(1000);
		return PageFactory.initElements(driver, LandingPage_Edit.class);
	}

	public LandingPage_Edit copyLP(String lpName) throws Exception {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement chkBox= driver.findElement(By.xpath("//a[normalize-space(text())='"+(lpName)+"']/parent::span"));
		chkBox.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		linkCopy.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		buttonDialogOK.click();
		return PageFactory.initElements(driver, LandingPage_Edit.class);
	}
}