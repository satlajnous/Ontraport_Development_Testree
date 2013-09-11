package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Sequence_CreateDate extends AbstractPage
{

    protected String   url = "/#!/sequence/create&type=date";

    @FindBy(how = How.XPATH, using = "//div[@class='ussr-pane-editor-name ussr-pane-editor-name']//input[@type='text']")
    private WebElement inputSeqName;
    
    @FindBy(how = How.XPATH, using = "//span[@class='ussr-theme-sequence-email']//button")
    private WebElement buttonEmail;
    
    @FindBy(how = How.XPATH, using = "//div[@class='step_detail_radio']//input[@value='field']")
    private WebElement radioButtonSpecificEvent;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-form-input-wrapper']//input[@placeholder='Select Field...']")
    private WebElement selectField;
    
    @FindBy(how = How.XPATH, using = "//li[@data-val='birthday']")
    private WebElement selectEventValue;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-form-input-wrapper']//input[@placeholder='Select Time To Send...']")
    private WebElement selectTimeToSend;
    
    @FindBy(how = How.XPATH, using = "//li[@data-val='12:00:am']")
    private WebElement selectTimeValue;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-form-input-wrapper']//input[@placeholder='Select mail from']")
    private WebElement selectMailFrom;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-component-drilldownselect-listview sem-listview jb-ace-scroll-target']//li[@data-searchable='1']")
    private WebElement selectMailFromEntry;
    
    @FindBy(how = How.XPATH, using = "//div[@id='ussr-chrome-panel-pane']//span[normalize-space(text())='Save']")
    private WebElement buttonSave;
  
    public Sequence_ListAll createDateSeq (String seqName) throws Exception
    {	
    	Thread.sleep(6000);
    	inputSeqName.clear();
    	inputSeqName.sendKeys(seqName);
    	Thread.sleep(3000);
    	buttonEmail.click();
    	radioButtonSpecificEvent.click();
    	selectField.click();
    	selectEventValue.click();
    	selectTimeToSend.click();
    	selectTimeValue.click();
    	selectItemBasedOnIndex("Select e-mail", 2);
    	selectMailFrom.click();
    	selectMailFromEntry.click();
    	selectItemBasedOnIndex("Select Send From...", 1);
    	buttonSave.click();
        return PageFactory.initElements(driver, Sequence_ListAll.class);
    }

}