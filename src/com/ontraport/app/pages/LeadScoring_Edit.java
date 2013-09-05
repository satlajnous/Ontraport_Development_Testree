package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

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
	
	
    public Contact_ListAll selectCondition_Sequences (String condition) throws Exception
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
    	return PageFactory.initElements(driver, Contact_ListAll.class);
    }
    
    public Contact_ListAll clearFields() throws Exception
    {	
    	buttonTrashDelete.click();
    	buttonSave.click();
    	return PageFactory.initElements(driver, Contact_ListAll.class);
    }
    
    public Contact_ListAll selectCondition_VisitLandingPage (String condition/*, String placeholder1, String placeholder2, String placeholder3*/) throws Exception
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
    
   public Contact_ListAll selectCondition_FieldIsThisValue (String condition) throws Exception
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
    	return PageFactory.initElements(driver, Contact_ListAll.class);
    }

}