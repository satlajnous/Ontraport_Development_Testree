package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class SmartForm_Create extends AbstractPage {

	protected String url = "/#!/smart_form_fe/create";

	@FindBy(how = How.CSS, using = "div.fe-title.fe-title-user-hasnt-clicked")
	private WebElement inputSmartFormName;

	@FindBy(how = How.XPATH, using = "//div[@class='ussr-dialog-content']//input")
	private WebElement inputEnterDialogName;

	@FindBy(how = How.XPATH, using = "//div[@class='ui-dialog-buttonset']//button//span[text()='save']")
	private WebElement buttonDialogSave;

	@FindBy(how = How.XPATH, using = "//div[@class='fe-design-style-widget-group ussr-border-light-all ussr-corner-top ussr-texture-flat-light']//div[@class='fe-design-style-widget-wrapper']")
	private WebElement fieldPropertyText;

	public SmartForm_Create createNewSmartForm(String smartFormName)
			throws Exception

	{
		inputSmartFormName.click();
		inputEnterDialogName.sendKeys(smartFormName);
		buttonDialogSave.click();
		return PageFactory.initElements(driver, SmartForm_Create.class);
	}

	public String verifyNothingIsSelectedInField() throws Exception

	{
		String fieldProperty = fieldPropertyText.getText().trim();
		System.out.println("Field Property Text: " + fieldProperty);
		return fieldProperty;
	}

}