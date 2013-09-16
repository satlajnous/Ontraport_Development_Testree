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
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")
	private WebElement nameInput;

	@FindBy(how = How.XPATH, using = "//div[div[text()='WHEN THIS HAPPENS:']]//div[input[normalize-space(@placeholder)='Select Trigger...']]/descendant::button")
	private WebElement whenDropDown;

	@FindBy(how = How.XPATH, using = "//div[div[text()='IF THIS IS TRUE:']]//div[input[normalize-space(@placeholder)='Select Condition (optional)...']]/descendant::button")
	private WebElement ifConditionalDropDown;

	@FindBy(how = How.XPATH, using = "//div[div[text()='IF THIS IS TRUE:']]//div[input[normalize-space(@placeholder)='Select Field...']]/descendant::button")
	private WebElement ifFieldDropDown;

	@FindBy(how = How.XPATH, using = "//div[div[text()='IF THIS IS TRUE:']]//div[input[normalize-space(@placeholder)='Select Condition...']]/descendant::button")
	private WebElement ifConditionalFieldDropDown;

	@FindBy(how = How.XPATH, using = "//div[div[text()='WHEN THIS HAPPENS:']]//div[input[normalize-space(@placeholder)='Select Field...']]/descendant::button")
	private WebElement whenFieldDropDown;

	@FindBy(how = How.XPATH, using = "//div[div[text()='THEN DO THIS:']]//div[input[normalize-space(@placeholder)='Select Action...']]/descendant::button")
	private WebElement thenDropDown;

	@FindBy(how = How.XPATH, using = "//div[@class='ussr-component-helper-field-display-rule-editor']//div[.='First Name']")
	private WebElement firstName;

	@FindBy(how = How.XPATH, using = "//div[@class='ussr-component-helper-field-display-rule-editor']//div[.='Field is this value']")
	private WebElement fieldEqualValue;

	@FindBy(how = How.XPATH, using = "//ul[@class='ussr-component-drilldownselect-ul']//div[.='Contact is created']")
	private WebElement contactCreated;

	@FindBy(how = How.XPATH, using = "//ul[@class='ussr-component-drilldownselect-ul']//div[.='A Certain field is updated']")
	private WebElement fieldIsUpdated;

	@FindBy(how = How.XPATH, using = "//ul[@class='ussr-component-drilldownselect-ul']//div[.='Equal To']")
	private WebElement equalTo;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Value...']")
	private WebElement valueField;

	@FindBy(how = How.XPATH, using = "//ul[@class='ussr-component-drilldownselect-ul']//div[.='Recharge all declined transactions']")
	private WebElement rechargeDeclinedTransactions;

	@FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
	private WebElement saveButton;
	

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

public Rule_ListAll createRuleFirstNameisUpdated(String name)
		throws Exception {
	nameInput.click();
	nameInput.clear();
	nameInput.sendKeys(name);
	whenDropDown.click();
	fieldIsUpdated.click();
	whenFieldDropDown.click();
	firstName.click();
	thenDropDown.click();
	rechargeDeclinedTransactions.click();
	saveButton.click();
	return PageFactory.initElements(driver, Rule_ListAll.class);
}

public Rule_ListAll createRuleFeildEqualTo(String name) throws Exception {
	nameInput.click();
	nameInput.clear();
	nameInput.sendKeys(name);
	whenDropDown.click();
	contactCreated.click();
	ifConditionalDropDown.click();
	fieldEqualValue.click();
	ifFieldDropDown.click();
	firstName.click();
	ifConditionalFieldDropDown.click();
	equalTo.click();
	valueField.click();
	valueField.clear();
	valueField.sendKeys("Text Field");
	thenDropDown.click();
	rechargeDeclinedTransactions.click();
	saveButton.click();
	return PageFactory.initElements(driver, Rule_ListAll.class);
}


	
}