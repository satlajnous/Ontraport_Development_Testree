package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.Common;

public class Rule_Edit extends AbstractPage {

	protected String url = "/#!/rule/edit&id=";

	@FindBy(how = How.XPATH, using = "//*[input/@placeholder]")
	private List<WebElement> selectListGenericParentLandingPage;

	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	private List<WebElement> inputTextBoxCollection;

	@FindBy(how = How.XPATH, using = "//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span")
	private WebElement displayWhenThisHappens;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span")
	private WebElement displayThenDoThis;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span/span[1]")
	private WebElement displayWhenThisHappensWithCondition;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span/span[1]")
	private WebElement displayThenDoThisWithCondition;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")
	private WebElement displayRuleName;
	
	
	public boolean verifyTheValueInDropDownBasedOnPlaceHolder(
			String placeHolder, String expectedValue) throws Exception {

		WebElement parentOfSelect = getParentWebElementForSelect(placeHolder);
		WebElement inputTxtBox = parentOfSelect.findElement(By
				.xpath(".//input"));

		return Common.verifyTextBoxValue(inputTxtBox, expectedValue);
	}

	public boolean verifyValueOfTxtBoxBasedOnIndex(int index,
			String expectedValue) {
		WebElement inputBoxEle = inputTextBoxCollection.get(index - 1);
		return Common.verifyTextBoxValue(inputBoxEle, expectedValue);
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
	
	public boolean verifyWhenThisHappensText(String condition){
		String whenThisHappens= displayWhenThisHappens.getText().trim();
		if(whenThisHappens.equals(condition.trim())){
			return true;
		}
		return false;
	}
	
	public boolean verifyThenDoThisText(String condition){
		String thenDoThis= displayThenDoThis.getText().trim();
		if(thenDoThis.equals(condition.trim())){
			return true;
		}
		return false;
	}
	
	public boolean verifyWhenThisHappensTextWithCondition(String condition){
		String whenThisHappens= displayWhenThisHappensWithCondition.getText().trim();
		if(whenThisHappens.equals(condition.trim())){
			return true;
		}
		return false;
	}
	
	public boolean verifyThenDoThisTextWithCondition(String condition){
		String thenDoThis= displayThenDoThisWithCondition.getText().trim();
		if(thenDoThis.equals(condition.trim())){
			return true;
		}
		return false;
	}
	
	public boolean verifyRuleName(String condition){
		String ruleName=displayRuleName.getAttribute("value").trim();
		if(ruleName.equals(condition.trim())){
			return true;
		}
		return false;
	}
	

}