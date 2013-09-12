package com.ontraport.app.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.Common;

public class Rule_Create extends AbstractPage {

	protected String url = "/#!/rule/create";

	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	private WebElement inputRuleName;

	@FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
	private WebElement buttonSave;

	/*
	 * New WebElements
	 */
	@FindBy(how = How.XPATH, using = "//*[input/@placeholder]")
	private List<WebElement> selectListGenericParentLandingPage;

	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	private List<WebElement> inputTextBoxCollection;

	@FindBy(how = How.XPATH, using = "//textarea")
	private List<WebElement> inputTextAreaCollection;

	
	public Rule_Create inputRuleName(String ruleName) throws Exception {
		inputRuleName.clear();
		inputRuleName.sendKeys(ruleName);
		return PageFactory.initElements(driver, Rule_Create.class);
}
	public WebElement getParentWebElementForSelect(String placeHolder)
			throws Exception {
		System.out.println(selectListGenericParentLandingPage.size());
		for (int i = 0; i < selectListGenericParentLandingPage.size(); i++) {
			WebElement inputElement = selectListGenericParentLandingPage.get(i)
					.findElement(By.xpath(".//input"));
			String placeholderVal = inputElement.getAttribute("placeholder")
					.trim();
			if (placeholderVal.equalsIgnoreCase(placeHolder.trim())) {
				return selectListGenericParentLandingPage.get(i);
			}
		}

		throw new Exception(
				"Unable to locate Select drop down element with the attribute:"
						+ placeHolder);
	}

	public Rule_Create typeIntoTextBoxBasedOnIndex(int index,
			String textToBetyped) {
		WebElement inputBoxEle = inputTextBoxCollection.get(index - 1);
		inputBoxEle.clear();
		inputBoxEle.sendKeys(textToBetyped);
		return PageFactory.initElements(driver, Rule_Create.class);
	}

	public Rule_Create typeIntoTextBoxBasedOnPlaceholder(
			String placeHolder, String textToBetyped) throws Exception {
		WebElement parentOfSelect = getParentWebElementForSelect(placeHolder);
		WebElement inputTxtBox = parentOfSelect.findElement(By
				.xpath(".//input"));
		inputTxtBox.clear();
		inputTxtBox.sendKeys(textToBetyped);
		return PageFactory.initElements(driver, Rule_Create.class);
	}

	public Rule_ListAll clickSaveButton() throws Exception {
		buttonSave.click();
		return PageFactory.initElements(driver, Rule_ListAll.class);
	}

	public Rule_Create typeIntoTextArea(String textToBetyped, int index)
			throws Exception {

		WebElement inputTxtBox = inputTextAreaCollection.get(index - 1);
		inputTxtBox.clear();
		inputTxtBox.sendKeys(textToBetyped);
		return PageFactory.initElements(driver, Rule_Create.class);
	}

	public Rule_Create selectValueFromDropDown(String placeholder,
			String valueToBeSelected) throws Exception {

		WebElement parentElement = getParentWebElementForSelect(placeholder);
		WebElement selectBtnElement = parentElement.findElement(By
				.xpath(".//button"));
		WebElement selectInputElement = parentElement.findElement(By
				.xpath(".//input"));
		// List<WebElement> selectDIVListElement =
		// parentElement.findElements(By.xpath(".//li/div"));
		// selectDropDownByTyping(selectBtnElement, selectInputElement,
		// selectDIVListElement, valueToBeSelected);
		selectDropDownByTyping(parentElement, selectBtnElement,
				selectInputElement, ".//li/div", valueToBeSelected);
		Common.waitForPage(driver, 5);
		return PageFactory.initElements(driver, Rule_Create.class);
	}
	
public Rule_Create selectDropDownsBasedOnConditions(String[] placeHolders, String[] selectOptions) {
	Rule_Create ruleCreate = null;
	for (int i = 0; i < placeHolders.length; i++) {
		try {
			ruleCreate = selectValueFromDropDown (placeHolders[i], selectOptions[i]);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return ruleCreate;
}

	
}