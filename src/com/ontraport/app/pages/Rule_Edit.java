package com.ontraport.app.pages;

import java.util.Iterator;
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
	
	@FindBy(how = How.XPATH, using = "//*[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")
	private WebElement displayRuleName;
	
	@FindBy(how = How.XPATH, using = "//div[div[normalize-space(text())='WHEN THIS HAPPENS:']]//span[@class='sem-statement-text-wrapper']")
	private List<WebElement> displayWhenThisHappensConditions;
	
	/*@FindBy(how = How.XPATH, using = "//div[div[normalize-space(text())='IF THIS IS TRUE:']]//span[@class='sem-statement-text-wrapper']")
	private List<WebElement> displayWhenThisHappensConditions;*/
	
	@FindBy(how = How.XPATH, using = "//div[div[normalize-space(text())='THEN DO THIS:']]//span[@class='sem-statement-text-wrapper']")
	private List<WebElement> displayThenDoThisConditions;
	
	
	
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
	
	public boolean verifyWhenThisHappensText (String condition){
		List<WebElement> list= displayWhenThisHappensConditions;
		Iterator<WebElement> itr= list.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
		String whenThisHappensText= eachParentElement.getText().trim();
		System.out.println("When This Happens Text: "+whenThisHappensText);
		if(whenThisHappensText.equals(condition.trim())){
			return true;
		}
		
		}
		return false;
	}
	
	public boolean verifyThenDoThisText(String condition){
		List<WebElement> list= displayThenDoThisConditions;
		Iterator<WebElement> itr= list.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
		String thenDoThisText= eachParentElement.getText().trim();
		System.out.println("Then Do This Text: "+thenDoThisText);
		if(thenDoThisText.equals(condition.trim())){
			return true;
		}
		
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