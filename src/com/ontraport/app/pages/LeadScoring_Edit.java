package com.ontraport.app.pages;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.Common;

public class LeadScoring_Edit extends AbstractPage
{

    protected String   url = "/#!/contact/scoreEdit";

    
    @FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
    private WebElement buttonSave;
    
    @FindBy(how = How.XPATH, using = "//div[text()='Add New Condition']")
    private WebElement linkAddCondition;
    
    @FindBy(how = How.XPATH, using = "//div[@class='sem-delete-statement display-inline-block ussr-round-left ussr-texture-flat-light ussr-helper-cursor-pointer ussr-border-solid-all']")
    private WebElement buttonTrashDelete;
    
    @FindBy(how = How.XPATH, using = "//span[@class='ussr-component-rule-statements-generic-target-sub-comp-2 ussr-component ussr-component-form_control_input_text ontraport_components_form_control_input_text ussr-form-cell ussr-component-form-control clearfix input-size-small']//input")
    private WebElement inputNoOfTimes;
    
    @FindBy(how = How.XPATH, using = "//span//input[@placeholder='Enter Value...']")
    private WebElement inputEnterFieldValue;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ontraport_components_rule_editor_score_editor_sentence_wrapper']//input")
    private WebElement inputAssignScore;
    	
    @FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Condition']]/descendant::button")
    private WebElement selectButtonConditionLeadScoring;
	
	@FindBy(how = How.XPATH, using = "//div//input[normalize-space(@placeholder)='Select Condition']")
    private WebElement selectInputConditionLeadScoring;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Condition']]//li/div")
    private List<WebElement> selectListDIVConditionLeadScoring;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Sequence']]/descendant::button")
    private WebElement selectButtonSequence;
	
	@FindBy(how = How.XPATH, using = "//div//input[normalize-space(@placeholder)='Select Sequence']")
    private WebElement selectInputSequence;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Sequence']]//li/div")
    private List<WebElement> selectListDIVSequence;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Landing Page']]/descendant::button")
    private WebElement selectButtonLandingPage;
	
	@FindBy(how = How.XPATH, using = "//div//input[normalize-space(@placeholder)='Select Landing Page']")
    private WebElement selectInputLandingPage;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Landing Page']]//li/div")
    private List<WebElement> selectListDIVLandingPage;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select...']]/descendant::button")
    private WebElement selectButtonRelationalCondition;
	
	@FindBy(how = How.XPATH, using = "//div//input[normalize-space(@placeholder)='Select...']")
    private WebElement selectInputRelationalCondition;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select...']]//li/div")
    private List<WebElement> selectListRelationalCondition;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Field...']]/descendant::button")
    private WebElement selectButtonFieldCondition;
	
	@FindBy(how = How.XPATH, using = "//div//input[normalize-space(@placeholder)='Select Field...']")
    private WebElement selectInputFieldCondition;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Field...']]//li/div")
    private List<WebElement> selectListFieldCondition;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Condition...']]/descendant::button")
    private WebElement selectButtonFieldRelationalCondition;
	
	@FindBy(how = How.XPATH, using = "//div//input[normalize-space(@placeholder)='Select Condition...']")
    private WebElement selectInputFieldRelationalCondition;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Condition...']]//li/div")
    private List<WebElement> selectListFieldRelationalCondition;
	
	@FindBy(how = How.XPATH, using = "//div[@class='ussr-pane-editor-back' and normalize-space(text())='Back']")
    private WebElement buttonBack;
	
	@FindBy(how = How.XPATH, using = "//button//span[text()='Cancel']")
    private WebElement buttonCancel;
	
	//Ravi
	@FindBy(how = How.XPATH, using = "//*[input/@placeholder]")
    private List<WebElement> selectListGenericParentLandingPage;
	
	@FindBy (how = How.XPATH, using = "//div[label[text()='Score value']]//input")
	private WebElement inputScoreValue;
	
	@FindBy (how = How.XPATH, using = "//input[@type='text']")
	private List<WebElement> inputTextBoxCollection;
	
	@FindBy (how = How.XPATH, using = "//a/span[@class='ussr-icon ussr-icon-trashcan']")
	private List<WebElement> deleteIconLink;
	
	@FindBy (how = How.XPATH, using = "//textarea")
	private List<WebElement> inputTextAreaCollection;

	@FindBy (how = How.XPATH, using = "//div[@class='component-score-editor-degredation clearfix ussr-border-solid-tb ussr-texture-flat-light']//input")
	private WebElement inputScoreDegradation;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span")
    private WebElement displayContactScoringConditionsText;

	@FindBy(how = How.XPATH, using = "//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span[1]")
    private WebElement displayContactScoringWithConditionsText;
	
	
	
	//div[@class='component-score-editor-degredation clearfix ussr-border-solid-tb ussr-texture-flat-light']//input
	
	//@FindBy(how = How.XPATH, using = "//input/@placeholder")
	//@FindBy(how = How.XPATH, using = "//input/@placeholder")
    //private List<WebElement> inputBoxesOfselectForAssertions;
	
    
	
	public WebElement getParentWebElementForSelect (String placeHolder) throws Exception {
		System.out.println(selectListGenericParentLandingPage.size());
		for (int i = 0; i < selectListGenericParentLandingPage.size(); i++) {
			WebElement inputElement = selectListGenericParentLandingPage.get(i).findElement(By.xpath(".//input"));
			String placeholderVal = inputElement.getAttribute("placeholder").trim();
			if (placeholderVal.equalsIgnoreCase(placeHolder.trim())){
				return selectListGenericParentLandingPage.get(i);
			}
		}
		
		throw new Exception ("Unable to locate Select drop down element with the attribute:" + placeHolder);
	}
	
	public LeadScoring_Edit clickAddNewCondition (){
	  	linkAddCondition.click();
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return PageFactory.initElements(driver, LeadScoring_Edit.class);
	}
	
	public LeadScoring_Edit assignLeadScoringvalue (String leadScoringPoints){
		inputScoreValue.clear();
		inputScoreValue.sendKeys(leadScoringPoints);
		return PageFactory.initElements(driver, LeadScoring_Edit.class);
	}
	
	public LeadScoring_Edit assignScoreDegradationValue (String leadScoringPoints){
		inputScoreDegradation.clear();
		inputScoreDegradation.sendKeys(leadScoringPoints);
		return PageFactory.initElements(driver, LeadScoring_Edit.class);
	}
	
	public LeadScoring_Edit typeIntoTextBoxBasedOnIndex (int index, String textToBetyped){
		WebElement inputBoxEle = inputTextBoxCollection.get(index-1);
		inputBoxEle.clear();
		inputBoxEle.sendKeys(textToBetyped);
		return PageFactory.initElements(driver, LeadScoring_Edit.class);
	}
	
	
	public LeadScoring_Edit typeIntoTextBoxBasedOnPlaceholder (String placeHolder, String textToBetyped) throws Exception{
		WebElement parentOfSelect = getParentWebElementForSelect (placeHolder);
		WebElement inputTxtBox = parentOfSelect.findElement(By.xpath(".//input"));
		inputTxtBox.clear();
		inputTxtBox.sendKeys(textToBetyped);
		return PageFactory.initElements(driver, LeadScoring_Edit.class);
	}
	
	public Contact_ListAll clickSaveButton() throws Exception  {	
    	buttonSave.click();
    	return PageFactory.initElements(driver, Contact_ListAll.class);
    }
	
	public LeadScoring_Edit typeIntoTextArea (String textToBetyped, int index) throws Exception{
		
		WebElement inputTxtBox = inputTextAreaCollection.get(index-1);
		inputTxtBox.clear();
		inputTxtBox.sendKeys(textToBetyped);
		return PageFactory.initElements(driver, LeadScoring_Edit.class);
	}
	
	public LeadScoring_Edit clearAllConditions (){
		System.out.println("No of delete ikons:" + deleteIconLink.size());
		List<WebElement> deletecollection = deleteIconLink;
		Iterator<WebElement> iterator = deletecollection.iterator();
		while (iterator.hasNext()) {
			WebElement eachDelElement = iterator.next();
			eachDelElement.click();
			if (deletecollection.size()==2){
				break;
			}
			LeadScoring_Edit pgObj = PageFactory.initElements(driver, LeadScoring_Edit.class);
			deletecollection = pgObj.deleteIconLink;
			iterator = deletecollection.iterator(); 
		}
		/*for (int i = 0; i < deleteIconLink.size(); i++) {
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}*/
		Common.waitForPage(driver,3);
		return PageFactory.initElements(driver, LeadScoring_Edit.class);
	}
	
	public LeadScoring_Edit clearAllFields ()throws Exception{
		buttonTrashDelete.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return PageFactory.initElements(driver, LeadScoring_Edit.class);
	}
	
	public LeadScoring_Edit clearScoreDegradation ()throws Exception{
		inputScoreDegradation.clear();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return PageFactory.initElements(driver, LeadScoring_Edit.class);
	}
	
	
	public LeadScoring_Edit selectValueFromDropDown (String placeholder, String valueToBeSelected) throws Exception{

		WebElement parentElement = getParentWebElementForSelect (placeholder);
		WebElement selectBtnElement = parentElement.findElement(By.xpath(".//button"));
		WebElement selectInputElement =  parentElement.findElement(By.xpath(".//input"));
		//List<WebElement> selectDIVListElement =  parentElement.findElements(By.xpath(".//li/div"));
		//selectDropDownByTyping(selectBtnElement, selectInputElement, selectDIVListElement, valueToBeSelected);
		selectDropDownByTyping(parentElement, selectBtnElement, selectInputElement, ".//li/div", valueToBeSelected);
		Common.waitForPage(driver, 5);
		return PageFactory.initElements(driver, LeadScoring_Edit.class);
	}
	
	
	/**
	 * 
	 * @param placeHolder
	 * @param expectedValue
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTheValueInDropDownBasedOnPlaceHolder (String placeHolder, String expectedValue) throws Exception{
		
		WebElement parentOfSelect = getParentWebElementForSelect (placeHolder);
		WebElement inputTxtBox = parentOfSelect.findElement(By.xpath(".//input"));
		
		return Common.verifyTextBoxValue(inputTxtBox, expectedValue);
	}
	
	
	
	
	
    
	/*
	 * trying to combine the @FindBy using collections and reduce the WebElement List
	 */
    
    
    
    
	
	
	/*public WebElement findButton(String placeholder)throws Exception{
		WebElement selectButton = null;
			selectButton= driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='"+placeholder+"']]/descendant::button")); 
			return selectButton;
	}
	
	public WebElement findInput(String placeholder)throws Exception{
		WebElement selectInput= null;
		selectInput= driver.findElement(By.xpath("//div//input[normalize-space(@placeholder)='"+placeholder+"']")); 
		return selectInput;
	}
	
	public List<WebElement> findDIVEntriesList(String placeholder)throws Exception{
		List<WebElement> list=null;
		list= driver.findElements(By.xpath("//div[input[normalize-space(@placeholder)='"+placeholder+"']]//li/div")); 
		return list;
	}
	*/
	
	
	
/*	
    public ContactListAll selectCondition_Sequences (String condition, ) throws Exception
    {	
    	linkAddCondition.click();
    	Thread.sleep(1000);
        selectDropDownByTyping(selectButtonConditionLeadScoring, selectInputConditionLeadScoring, selectListDIVConditionLeadScoring, condition);
    	Thread.sleep(1000);
    	selectDropDownByTyping(selectButtonSequence, selectInputSequence, selectListDIVSequence, "Any Sequence");
    	Thread.sleep(1000);
    	inputAssignScore.clear();
    	inputAssignScore.sendKeys("11");
    	buttonSave.click();
    	return PageFactory.initElements(driver, ContactListAll.class);
    }*/
    
    //Need to be restructured...... Might be this method needs to be dropped 
    public Contact_ListAll selectCondition_VisitLandingPage (String condition, String placeholder1, String placeholder2, String placeholder3) throws Exception
    {	
    	linkAddCondition.click();
    	Thread.sleep(1000);
    	
        /*WebElement selectButtonConditionLeadScoring= findButton(placeholder1);
		WebElement selectInputConditionLeadScoring= findInput(placeholder1);
		List<WebElement> selectListDIVConditionLeadScoring= findDIVEntriesList(placeholder1);*/
		
		selectDropDownByTyping(selectButtonConditionLeadScoring, selectInputConditionLeadScoring, selectListDIVConditionLeadScoring, condition);
    	Thread.sleep(1000);
    	
    	/*WebElement selectButtonLandingPage=findButton(placeholder2);
		WebElement selectInputLandingPage=findInput(placeholder2);
		List<WebElement> selectListDIVLandingPage=findDIVEntriesList(placeholder2);
		*/
		selectDropDownByTyping(selectButtonLandingPage, selectInputLandingPage, selectListDIVLandingPage, "Any Landing Page");
    	Thread.sleep(1000);
    	
    	/*WebElement selectButtonRelationalCondition=findButton(placeholder3);
		WebElement selectInputRelationalCondition=findInput(placeholder3);
		List<WebElement> selectListRelationalCondition=findDIVEntriesList(placeholder3);*/
		
		selectDropDownByTyping(selectButtonRelationalCondition, selectInputRelationalCondition, selectListRelationalCondition, "Equal To");
    	Thread.sleep(1000);
    	inputNoOfTimes.clear();
    	inputNoOfTimes.sendKeys("5");
    	Thread.sleep(1000);
    	inputAssignScore.clear();
    	inputAssignScore.sendKeys("11");
    	Thread.sleep(1000);
    	buttonSave.click();
    	return PageFactory.initElements(driver, Contact_ListAll.class);
    }

    
	public LeadScoring_Edit selectDropDownsBasedOnConditions(String[] placeHolders, String[] selectOptions) {
		LeadScoring_Edit leadScoringEdit = null;
		for (int i = 0; i < placeHolders.length; i++) {
			try {
				leadScoringEdit = selectValueFromDropDown (placeHolders[i], selectOptions[i]);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return leadScoringEdit;
	}
    
   /* public ContactListAll selectCondition_FieldIsThisValue (String condition) throws Exception
    {	
    	linkAddCondition.click();
    	Thread.sleep(1000);
        selectDropDownByTyping(selectButtonConditionLeadScoring, selectInputConditionLeadScoring, selectListDIVConditionLeadScoring, condition);
    	Thread.sleep(1000);
    	selectDropDownByTyping(selectButtonFieldCondition, selectInputFieldCondition, selectListFieldCondition, "First Name");
    	Thread.sleep(1000);
    	selectDropDownByTyping(selectButtonFieldRelationalCondition, selectInputFieldRelationalCondition, selectListFieldRelationalCondition, "Equal To");
    	Thread.sleep(1000);
    	inputEnterFieldValue.clear();
    	inputEnterFieldValue.sendKeys("Selenium");
    	Thread.sleep(1000);
    	inputAssignScore.clear();
    	inputAssignScore.sendKeys("11");
    	Thread.sleep(1000);
    	buttonSave.click();
    	return PageFactory.initElements(driver, ContactListAll.class);
    }*/
	
	
	public boolean verifyValueOfTxtBoxBasedOnIndex (int index, String expectedValue){
		WebElement inputBoxEle = inputTextBoxCollection.get(index-1);
		return Common.verifyTextBoxValue(inputBoxEle, expectedValue);
	}
	
	
	
	public boolean verifyScoreValue (String expectedValue){
		return Common.verifyTextBoxValue(inputAssignScore, expectedValue);
	}
	
	public boolean verifyScoreDegradationValue(String expectedValue){
		return Common.verifyTextBoxValue(inputScoreDegradation, expectedValue);
	}
	
	public Contact_ListAll clickBack() throws Exception{
		buttonBack.click();
		Thread.sleep(1000);
		return PageFactory.initElements(driver,Contact_ListAll.class);
	}
	
	public Contact_ListAll clickCancel() throws Exception {
		buttonCancel.click();
		Thread.sleep(1000);
		return PageFactory.initElements(driver, Contact_ListAll.class);
	}
	
	public boolean contactScoringConditionText(String condition){
        String contactScoringConditionText= displayContactScoringConditionsText.getText().trim();
        if(contactScoringConditionText.equals(condition.trim())){
              return true;
        }
        return false;
  }

	public boolean contactScoringWithConditionText(String condition){
        String contactScoringWithConditionText= displayContactScoringConditionsText.getText().trim();
        if(contactScoringWithConditionText.equals(condition.trim())){
              return true;
        }
        return false;
  }
		
	
}