package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ontraport.app.tools.AbstractPage;

public class SmartForm_Edit extends AbstractPage {

	protected String url = "/#!/smart_form_fe/edit&id=";

	@FindBy(how = How.XPATH, using = "//div[@class='fe-design-canvas jb-ace-scroll-target']//li//div//input[@type='submit']")
	private WebElement buttonSubmit;

	@FindBy(how = How.XPATH, using = "//div[@class='jb-css-font-selector ui-widget']//select[@class='jb-font-selector-family jb-font-selector-input']")
	private WebElement selectFontFamily;

	@FindBy(how = How.XPATH, using = "//div[@class='fe-controls']//span[text()='save']")
	private WebElement buttonPageSave;

	public SmartForm_Edit clickSubmitButton() throws Exception {
		Actions builder = new Actions(driver);
		builder.moveToElement(buttonSubmit).click().build().perform();
		Thread.sleep(1000);
		return PageFactory.initElements(driver, SmartForm_Edit.class);
	}

	public SmartForm_Edit editFontFamily(String option) throws Exception {
		Actions builder = new Actions(driver);
		WebElement selectFont = selectOption(option);
		builder.moveToElement(selectFontFamily).moveToElement(selectFont)
				.click().build().perform();
		Thread.sleep(1000);
		buttonPageSave.click();
		Thread.sleep(1000);
		return PageFactory.initElements(driver, SmartForm_Edit.class);
	}

	public WebElement selectOption(String option) {
		WebElement selectFont = driver
				.findElement(By
						.xpath("//div[@class='jb-css-font-selector ui-widget']//select[@class='jb-font-selector-family jb-font-selector-input']//option[text()='"
								+ option + "']"));
		return selectFont;
	}

	public String getTextFromInput() {
		Select select = new Select(selectFontFamily);
		WebElement option = select.getFirstSelectedOption();
		String fontName = option.getText();
		System.out.println("fontName: " + fontName);
		return fontName;
	}

}
