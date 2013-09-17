package com.ontraport.app.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.Common;

public class SmartForm_Edit extends AbstractPage {

	protected String url = "/#!/smart_form_fe/edit&id=";

	@FindBy(how = How.XPATH, using = "//div[@class='fe-design-canvas jb-ace-scroll-target']//li//div//input[@type='submit']")
	private WebElement buttonSubmit;

	@FindBy(how = How.XPATH, using = "//div[@class='jb-css-font-selector ui-widget']//select[@class='jb-font-selector-family jb-font-selector-input']")
	private WebElement selectFontFamily;

	@FindBy(how = How.XPATH, using = "//div[@class='fe-controls']//span[text()='save']")
	private WebElement buttonPageSave;
	
	//Ravi
	
	//@FindBy(how = How.XPATH, using = "//*[@class='ussr-component-input ussr-form-input-type-text  clearfix']")
	@FindBy(how = How.XPATH, using = "//*[@id='fe-style-selector-element-options']//div[input]/label")
    private List<WebElement> txtFieldParentElementsChooseGatewayType;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='fe-style-selector-element-options']//div[select]/div")
    private List<WebElement> selectParentFields;
	
	@FindBy(how = How.XPATH, using = "//*[@id='fe-style-selector-element-options']//div[input]/div")
    private List<WebElement> txtFieldParentElementsDIV;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='fe-style-selector-element-options']//div[input]")
    private List<WebElement> txtFieldParentElements;
	
	@FindBy(how = How.XPATH, using = "//*[@id='fe-style-selector-element-options']//div[select]")
    private List<WebElement> selectParentElements;
	
	@FindBy(how = How.XPATH, using = "//*[@id='fe-style-selector-element-options']//div[select]/label")
    private List<WebElement> selectParentElementsLabel;
	
	@FindBy(how = How.XPATH, using = "//*[@id='fe-style-selector-element-options']//div[select]/div")
    private List<WebElement> selectParentElementsDiv;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='fe-style-selector-element-options']//div[input]/label")
    private List<WebElement> inputParentElementsLabel;
	
	@FindBy(how = How.XPATH, using = "//*[@id='fe-style-selector-element-options']//div[input]/div")
    private List<WebElement> inputtParentElementsDiv;
	
	//*[@id='fe-style-selector-field-style']//div[input]/div
	//*[@id='fe-style-selector-element-options']//div[select]/descendant::select
	
	@FindBy(how = How.XPATH, using = "//div[@id='fe-mode-design']/div[1]/div/ul/li/a[text()='Form Style']")
    private WebElement formStyletab;
	
	
	//*[@id='fe-style-selector-field-style']//div[select]/div/following-sibling::select
	
	@FindBy(how = How.XPATH, using = "//*[@id='fe-style-selector-field-style']//div[select]/label")
    private List<WebElement> selectFormStylParentElementsLabel;
												
	@FindBy(how = How.XPATH, using = "//*[@id='fe-style-selector-field-style']//div[select]/div")
    private List<WebElement> selectFormStylParentElementsDiv;
	
	@FindBy(how = How.XPATH, using = "//*[@id='fe-style-selector-field-style']//div[input]/label")
    private List<WebElement> inputFormStylParentElementsLabel;
	
	@FindBy(how = How.XPATH, using = "//*[@id='fe-style-selector-field-style']//div[input]/div")
    private List<WebElement> inputFormStylParentElementsDiv;
	
	@FindBy(how = How.XPATH, using = "//div[@id='fe-style-selector-field-style']/div[div[text()='field style when unselected']]//div[select]/div")
    private WebElement selectFormStylFildStlyUnSelectDiv;
	
	@FindBy(how = How.XPATH, using = "//div[@id='fe-style-selector-field-style']/div[div[text()='Input Text Style']]//div[select]/div")
    private List<WebElement> selectFormStylInputTextStylSelectDiv;
	
	@FindBy(how = How.XPATH, using = "//div[@id='fe-style-selector-field-style']/div[div[text()='label style']]//div[select]/div")
    private List<WebElement> selectFormStylLabelStyleSelectDiv;
	
	@FindBy(how = How.XPATH, using = "//div[@id='fe-style-selector-field-style']/div[div[text()='sub text style']]//div[select]/div")
    private List<WebElement> selectFormStylSubTextStyleSelectDiv;
		
	@FindBy(how = How.XPATH, using = "//div[@id='fe-style-selector-field-style']/div[div[text()='Input Text Style']]//div[input]/div")
    private List<WebElement> inputFormStylInputTextStylSelectDiv;
	
	@FindBy(how = How.XPATH, using = "//div[@id='fe-style-selector-field-style']/div[div[text()='label style']]//div[input]/div")
    private List<WebElement> inputFormStylLabelStyleSelectDiv;
	
	@FindBy(how = How.XPATH, using = "//div[@id='fe-style-selector-field-style']/div[div[text()='sub text style']]//div[input]/div")
    private List<WebElement> inputFormStylSubTextStyleSelectDiv;
		
		
	
	
	
	
	
	//div[@id='fe-style-selector-field-style']/div[div[text()='field spacing']]
	
	//div[@id='fe-style-selector-field-style']/div[div[text()='label style']]
	//div[@id='fe-style-selector-field-style']/div[div[text()='field style when unselected']]
	
	

	public SmartForm_Edit clickSubmitButton() throws Exception {
		Actions builder = new Actions(driver);
		builder.moveToElement(buttonSubmit).click().build().perform();
		Thread.sleep(3000);
		return PageFactory.initElements(driver, SmartForm_Edit.class);
	}

	
	public SmartForm_Edit clickFormStyle() throws Exception {
		Thread.sleep(2000);
		formStyletab.click();
		Thread.sleep(3000);
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
	
	public SmartForm_Edit clickSaveButton (){
		buttonPageSave.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	
	//Ravi
	public WebElement getTextBoxOnTheLabel (String textboxLabel) throws Exception{
		System.out.println("=====================getTextBoxOnTheLabel=======================");
		Iterator<WebElement> itr = txtFieldParentElementsChooseGatewayType.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			String textfromApp = eachParentElement.getText().trim();
			System.out.println (textfromApp);
			if (textfromApp.equalsIgnoreCase(textboxLabel)){
				//return eachParentElement.findElement(By.xpath(".//input[@type='text']"));
				//return eachParentElement.findElement(By.xpath(".//input[@type='text']"));
			}
			
		}
		
		//throw new Exception ("No Label Match found");
		return null;
	}
	
	public WebElement getSelectBoxOnTheLabel (String textboxLabel) throws Exception{
		System.out.println("=====================getSelectBoxOnTheLabel=======================");
		Iterator<WebElement> itr = selectParentFields.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			String textfromApp = eachParentElement.getText().trim();
			System.out.println (textfromApp);
			if (textfromApp.equalsIgnoreCase(textboxLabel)){
				//return eachParentElement.findElement(By.xpath(".//input[@type='text']"));
				//return eachParentElement.findElement(By.xpath(".//input[@type='text']"));
			}
			
		}
		
		//throw new Exception ("No Label Match found");
		return null;
	}
	
	public WebElement getTextBoxOnTheLabelisDiv (String textboxLabel) throws Exception{
		System.out.println("=====================getTextBoxOnTheLabelisDiv=======================");
		Iterator<WebElement> itr = txtFieldParentElementsDIV.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			String textfromApp = eachParentElement.getText().trim();
			System.out.println (textfromApp);
			if (textfromApp.equalsIgnoreCase(textboxLabel)){
				//return eachParentElement.findElement(By.xpath(".//input[@type='text']"));
				//return eachParentElement.findElement(By.xpath(".//input[@type='text']"));
			}
			
		}
		
		//throw new Exception ("No Label Match found");
		return null;
	}
	
	public SmartForm_Edit setValueOfTextBoxBasedOnLabel (String label, String value) throws Exception{
		System.out.println("=====================getTextBoxOnTheLabelisDiv=======================");
		Iterator<WebElement> itr = txtFieldParentElements.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			try {
				WebElement lblElement = eachParentElement.findElement(By.xpath("./label"));
				String textfromApp = lblElement.getText().trim();
				System.out.println (textfromApp);
				if (textfromApp.equalsIgnoreCase(label)){
					WebElement txtBoxEle = eachParentElement.findElement(By.xpath(".//input[@type='text']"));
					txtBoxEle.clear();
					txtBoxEle.sendKeys("value");
					return PageFactory.initElements(driver, SmartForm_Edit.class);
				}
				
			} catch (Exception e) {
			}
		}
		
		return setValueOfTextBoxBasedOnLabelDiv (label, value);
		//return null;
	}
	
	public SmartForm_Edit setValueOfTextBoxBasedOnLabelDiv (String label, String value) throws Exception{
		System.out.println("=====================getTextBoxOnTheLabelisDiv=======================");
		Iterator<WebElement> itr = txtFieldParentElements.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			try {
				WebElement lblElement = eachParentElement.findElement(By.xpath("./div"));
				String textfromApp = lblElement.getText().trim();
				System.out.println (textfromApp);
				if (textfromApp.equalsIgnoreCase(label)){
					WebElement txtBoxEle = eachParentElement.findElement(By.xpath(".//input[@type='text']"));
					txtBoxEle.clear();
					txtBoxEle.sendKeys("value");
					return PageFactory.initElements(driver, SmartForm_Edit.class);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		throw new Exception ("No Label Match found");
		//return null;
	}
	
	public SmartForm_Edit setValueOfSelectBoxBasedOnLabel (String label, String value) throws Exception{
		System.out.println("=====================setValueOfSelectBoxBasedOnLabel=======================");
		Iterator<WebElement> itr = selectParentElements.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			try {
				WebElement lblElement = eachParentElement.findElement(By.xpath("./div"));
				//WebElement lblElement = eachParentElement.findElement(By.xpath("./label"));
				String textfromApp = lblElement.getText().trim();
				System.out.println (textfromApp);
				if (textfromApp.equalsIgnoreCase(label)){
					WebElement selectWebElement = eachParentElement.findElement(By.xpath(".//select"));
					Common.selecteValueFromDropDown(driver, selectWebElement, value);
					//txtBoxEle.sendKeys("value");
					return PageFactory.initElements(driver, SmartForm_Edit.class);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return setValueOfSelectBoxDIVBasedOnLabel (label, value);
		//return null;
	}
	
	public SmartForm_Edit setValueOfSelectBoxDIVBasedOnLabel (String label, String value) throws Exception{
		System.out.println("=====================setValueOfSelectBoxBasedOnLabel=======================");
		Iterator<WebElement> itr = selectParentElements.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			try {
				WebElement lblElement = eachParentElement.findElement(By.xpath("./label"));
//				WebElement lblElement = eachParentElement.findElement(By.xpath("./div"));
				String textfromApp = lblElement.getText().trim();
				System.out.println (textfromApp);
				if (textfromApp.equalsIgnoreCase(label)){
					WebElement selectWebElement = eachParentElement.findElement(By.xpath(".//select"));
					Common.selecteValueFromDropDown(driver, selectWebElement, value);
					//txtBoxEle.sendKeys("value");
					return PageFactory.initElements(driver, SmartForm_Edit.class);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		throw new Exception ("No Label Match found");
		//return null;
	}
	
	//=====================================================================================================================================
	/*public WebElement getSelectElementBasedOnLabel (String label) throws Exception{
		System.out.println("=====================setValueOfSelectBoxBasedOnLabel=======================");
		Iterator<WebElement> itr = selectParentElements.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			try {
				//WebElement lblElement = eachParentElement.findElement(By.xpath("./label"));
				WebElement lblElement = eachParentElement.findElement(By.xpath("./div"));
				String textfromApp = lblElement.getText().trim();
				System.out.println (textfromApp);
				if (textfromApp.equalsIgnoreCase(label)){
					WebElement selectWebElement = eachParentElement.findElement(By.xpath(".//select"));
					return selectWebElement;
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return getSelectLblElementBasedOnLabel(label);
		
	}*/
	
	public WebElement getSelectElementBasedOnLabel (String label) throws Exception{
		System.out.println("=====================setValueOfSelectBoxBasedOnLabel=======================");
		Iterator<WebElement> itr = selectParentElementsLabel.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			try {
				//WebElement lblElement = eachParentElement.findElement(By.xpath("./label"));
				//WebElement lblElement = eachParentElement.findElement(By.xpath(".."));
				String textfromApp = eachParentElement.getText().trim();
				System.out.println (textfromApp);
				if (textfromApp.equalsIgnoreCase(label)){
					WebElement selectWebElement = eachParentElement.findElement(By.xpath("./following-sibling::select"));
					return selectWebElement;
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//return getSelectLblElementBasedOnLabel(label);
		throw new Exception("label not found");
		
	}
	
	public WebElement getSelectElementBasedOnLabelDiv (List<WebElement> listElements, String label) throws Exception{
		System.out.println("=====================getSelectElementBasedOnLabelDiv=======================");
		System.out.println(listElements.size());
		Iterator<WebElement> itr = listElements.iterator();
		while (itr.hasNext()) {

			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			try {
				//WebElement lblElement = eachParentElement.findElement(By.xpath("./label"));
				//WebElement lblElement = eachParentElement.findElement(By.xpath(".."));
				String textfromApp = eachParentElement.getText().trim();
				System.out.println (textfromApp);
				if (textfromApp.equalsIgnoreCase(label)){
					WebElement selectWebElement = eachParentElement.findElement(By.xpath("./following-sibling::select"));
					return selectWebElement;
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
		throw new Exception ("No Label Found");
		
		
	}
	
	
//	public WebElement getSelectElementBasedOnLabelDivwaste (List<WebElement> listElements, String label) throws Exception{
//		System.out.println("=====================setValueOfSelectBoxBasedOnLabel=======================");
//		Iterator<WebElement> itr = listElements.iterator();
//		while (itr.hasNext()) {
//
//			WebElement eachParentElement = (WebElement) itr.next();
//			Common.scrollTillElementVisisble(driver, eachParentElement);
//			try {
//				//WebElement lblElement = eachParentElement.findElement(By.xpath("./label"));
//				//WebElement lblElement = eachParentElement.findElement(By.xpath(".."));
//				String textfromApp = eachParentElement.getText().trim();
//				System.out.println (textfromApp);
//				if (textfromApp.equalsIgnoreCase(label)){
//					WebElement selectWebElement = eachParentElement.findElement(By.xpath("./following-sibling::select"));
//					return selectWebElement;
//					
//				}
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			}
//		throw new Exception ("No Label Found");
//		
//	}
//	
	
	
	public WebElement getSelectElementBasedOnLabelDiv (List<WebElement> listElementsSet1, List<WebElement> listElementsSet2, String label) throws Exception{
		try {
			return getSelectElementBasedOnLabelDiv (listElementsSet1, label);
		} catch (Exception e) {
			return getSelectElementBasedOnLabelDiv (listElementsSet2, label);
		}
		
		
	}
	
	
	public WebElement getInputElementBasedOnLabelDiv (List<WebElement> listElements, String label) throws Exception{
		System.out.println("=====================setValueOfSelectBoxBasedOnLabel=======================");
		Iterator<WebElement> itr = listElements.iterator();
		while (itr.hasNext()) {

			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			try {
				//WebElement lblElement = eachParentElement.findElement(By.xpath("./label"));
				//WebElement lblElement = eachParentElement.findElement(By.xpath(".."));
				String textfromApp = eachParentElement.getText().trim();
				System.out.println (textfromApp);
				if (textfromApp.equalsIgnoreCase(label)){
					WebElement selectWebElement = eachParentElement.findElement(By.xpath("./following-sibling::input"));
					return selectWebElement;
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
		throw new Exception ("No Label Found");
		
	}
	
	
	
	public WebElement getInputElementBasedOnLabelDiv (List<WebElement> listElementsSet1, List<WebElement> listElementsSet2, String label) throws Exception{
		try {
			return getInputElementBasedOnLabelDiv (listElementsSet1, label);
		} catch (Exception e) {
			return getInputElementBasedOnLabelDiv (listElementsSet2, label);
		}
		
		
	}
	
	
	public WebElement getSelectLblElementBasedOnLabel (String label) throws Exception{

		System.out.println("=====================setValueOfSelectBoxBasedOnLabel=======================");
		Iterator<WebElement> itr = selectParentElements.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			try {
				//WebElement lblElement = eachParentElement.findElement(By.xpath("./div"));
				WebElement lblElement = eachParentElement.findElement(By.xpath("./label"));
				String textfromApp = lblElement.getText().trim();
				System.out.println (textfromApp);
				if (textfromApp.equalsIgnoreCase(label)){
					WebElement selectWebElement = eachParentElement.findElement(By.xpath(".//select"));
					return selectWebElement;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		throw new Exception ("No Label Match found");	
	}
	
	
	
	
	
	/*public WebElement getInputTextElementBasedonLabel (String label) throws Exception {
		
		System.out.println("=====================getTextBoxOnTheLabelisDiv=======================");
		Iterator<WebElement> itr = txtFieldParentElements.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			try {
				WebElement lblElement = eachParentElement.findElement(By.xpath("./label"));
				String textfromApp = lblElement.getText().trim();
				System.out.println (textfromApp);
				if (textfromApp.equalsIgnoreCase(label)){
					WebElement txtBoxEle = eachParentElement.findElement(By.xpath(".//input[@type='text']"));
					return txtBoxEle;
				}
				
			} catch (Exception e) {
			}
		}
		
		return getInputTextDIVElementBasedonLabel (label);
		//return null;
	}
	
	public WebElement getInputTextDIVElementBasedonLabel (String label) throws Exception {
		System.out.println("=====================getTextBoxOnTheLabelisDiv=======================");
		Iterator<WebElement> itr = txtFieldParentElements.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			try {
				WebElement lblElement = eachParentElement.findElement(By.xpath("./div"));
				String textfromApp = lblElement.getText().trim();
				System.out.println (textfromApp);
				if (textfromApp.equalsIgnoreCase(label)){
					WebElement txtBoxEle = eachParentElement.findElement(By.xpath(".//input[@type='text']"));
					return txtBoxEle;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		throw new Exception ("No Label Match found");
		//return null;
	}*/
	
	
	public WebElement getInputTextDIVElementBasedonLabel (String label) throws Exception{
		System.out.println("=====================setValueOfSelectBoxBasedOnLabel=======================");
		
		
		Iterator<WebElement> itr = inputtParentElementsDiv.iterator();
		while (itr.hasNext()) {
			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			try {
				//WebElement lblElement = eachParentElement.findElement(By.xpath("./label"));
				//WebElement lblElement = eachParentElement.findElement(By.xpath(".."));
				String textfromApp = eachParentElement.getText().trim();
				System.out.println (textfromApp);
				if (textfromApp.equalsIgnoreCase(label)){
					WebElement selectWebElement = eachParentElement.findElement(By.xpath("./following-sibling::input"));
					return selectWebElement;
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//return getSelectLblElementBasedOnLabel(label);
		throw new Exception("label not found");
		
	}
	
	public WebElement getInputTextElementBasedonLabel (String label) throws Exception{
		System.out.println("=====================setValueOfSelectBoxBasedOnLabel=======================");
		Iterator<WebElement> itr = inputParentElementsLabel.iterator();
		while (itr.hasNext()) {

			WebElement eachParentElement = (WebElement) itr.next();
			Common.scrollTillElementVisisble(driver, eachParentElement);
			try {
				//WebElement lblElement = eachParentElement.findElement(By.xpath("./label"));
				//WebElement lblElement = eachParentElement.findElement(By.xpath(".."));
				String textfromApp = eachParentElement.getText().trim();
				System.out.println (textfromApp);
				if (textfromApp.equalsIgnoreCase(label)){
					WebElement selectWebElement = eachParentElement.findElement(By.xpath("./following-sibling::input"));
					return selectWebElement;
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
		return getInputTextDIVElementBasedonLabel(label);
		
	}
	
	
	
	public SmartForm_Edit setTextInFieldSettingsBasedOnLabel (String label, String value) throws Exception{
		//WebElement inputTextElement = getInputTextElementBasedonLabel(label);
		WebElement inputTextElement = getInputElementBasedOnLabelDiv(inputParentElementsLabel,inputtParentElementsDiv,label);
		inputTextElement.clear();
		inputTextElement.sendKeys(value);
		return PageFactory.initElements(driver, SmartForm_Edit.class);
	}
	
	
	public SmartForm_Edit setSelectInFieldSettingsBasedOnLabel (String label, String value) throws Exception{
		//WebElement selectElement = getSelectElementBasedOnLabel(label);
		WebElement selectElement = getSelectElementBasedOnLabelDiv(selectParentElementsDiv,selectParentElementsLabel,label);
		Common.selecteValueFromDropDown(driver, selectElement, value);
		return PageFactory.initElements(driver, SmartForm_Edit.class);
	}
	
	
	public boolean verifyTextInFieldSettingsBasedOnLabel (String label, String expectedValue) throws Exception{
		WebElement inputTextElement = getInputElementBasedOnLabelDiv(inputParentElementsLabel,inputtParentElementsDiv,label);
		return Common.verifyTextBoxValue(inputTextElement, expectedValue);	
	}
	
	
	public boolean verifySelectedOptionInFieldSettingsBasedOnLabel (String label, String expectedValue) throws Exception{
		//WebElement selectElement = getSelectElementBasedOnLabel(label);
		//WebElement selectElement = getSelectElementBasedOnLabelDiv(label);
		WebElement selectElement = getSelectElementBasedOnLabelDiv(selectParentElementsDiv,selectParentElementsLabel,label);
		return Common.verifySelectDropDownValue(selectElement, expectedValue);	
	}

	/* Form Style methods */
	
	public SmartForm_Edit setTextInFormStyleBasedOnLabel (String sectionName,String label, String value) throws Exception{
		//WebElement inputTextElement = getInputTextElementBasedonLabel(label);
		//WebElement inputTextElement = getInputElementBasedOnLabelDiv(inputFormStylParentElementsLabel,inputFormStylParentElementsDiv,label);
		WebElement inputTextElement = null;
		if (sectionName.equalsIgnoreCase("label style")){
			//div[@id='fe-style-selector-field-style']//div[div[text()='label style']]
			inputTextElement = getInputElementBasedOnLabelDiv(inputFormStylLabelStyleSelectDiv,label);
		}
		else if (sectionName.equalsIgnoreCase("Input Text Style")){
			inputTextElement = getInputElementBasedOnLabelDiv(selectFormStylInputTextStylSelectDiv,label);
		}else if (sectionName.equalsIgnoreCase("sub text style")){
		inputTextElement = getInputElementBasedOnLabelDiv(inputFormStylSubTextStyleSelectDiv,label);
		}
		
		inputTextElement.clear();
		inputTextElement.sendKeys(value);
		return PageFactory.initElements(driver, SmartForm_Edit.class);
	}
	
	
	public SmartForm_Edit setSelectInFormStyleBasedOnLabel (String sectionName, String label, String value) throws Exception{
		//WebElement selectElement = getSelectElementBasedOnLabel(label);
		//WebElement selectElement = getSelectElementBasedOnLabelDiv(selectFormStylParentElementsDiv,selectFormStylParentElementsLabel,label);
		WebElement selectElement = null;
		
		if (sectionName.equalsIgnoreCase("label style")){
			//div[@id='fe-style-selector-field-style']//div[div[text()='label style']]
			selectElement = getSelectElementBasedOnLabelDiv(selectFormStylLabelStyleSelectDiv,label);
		}
		else if (sectionName.equalsIgnoreCase("Input Text Style")){
			selectElement = getSelectElementBasedOnLabelDiv(selectFormStylInputTextStylSelectDiv,label);
		}else if (sectionName.equalsIgnoreCase("sub text style")){
			selectElement = getSelectElementBasedOnLabelDiv(selectFormStylSubTextStyleSelectDiv,label);
		}
		
		Common.selecteValueFromDropDown(driver, selectElement, value);
		return PageFactory.initElements(driver, SmartForm_Edit.class);
	}
	
	
	public boolean verifyTextInFormStyleBasedOnLabel (String label, String expectedValue) throws Exception{
		WebElement inputTextElement = getInputElementBasedOnLabelDiv(inputFormStylParentElementsLabel,inputFormStylParentElementsDiv,label);
		return Common.verifyTextBoxValue(inputTextElement, expectedValue);	
	}
	
	
	public boolean verifySelectedOptionInFormStyleBasedOnLabel (String sectionName, String label, String expectedValue) throws Exception{
		//WebElement selectElement = getSelectElementBasedOnLabel(label);
		//WebElement selectElement = getSelectElementBasedOnLabelDiv(label);
		WebElement selectElement = null;
		if (sectionName.equalsIgnoreCase("label style")){
			//div[@id='fe-style-selector-field-style']//div[div[text()='label style']]
			selectElement = getSelectElementBasedOnLabelDiv(selectFormStylLabelStyleSelectDiv,label);
		}
		else if (sectionName.equalsIgnoreCase("Input Text Style")){
			selectElement = getSelectElementBasedOnLabelDiv(selectFormStylInputTextStylSelectDiv,label);
		}else if (sectionName.equalsIgnoreCase("sub text style")){
			selectElement = getSelectElementBasedOnLabelDiv(selectFormStylSubTextStyleSelectDiv,label);
		}
	//	selectElement = getSelectElementBasedOnLabelDiv(selectFormStylParentElementsDiv,selectFormStylParentElementsLabel,label);
		
		return Common.verifySelectDropDownValue(selectElement, expectedValue);	
	}

	
}
