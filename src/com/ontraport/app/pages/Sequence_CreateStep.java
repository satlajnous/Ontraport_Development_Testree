package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Sequence_CreateStep extends AbstractPage
{

    protected String   url = "/#!/sequence/create&type=step";

    @FindBy(how = How.XPATH, using = "//div[@class='ussr-pane-editor-name ussr-pane-editor-name']//input[@type='text']")
    private WebElement inputSeqName;
  
    @FindBy(how = How.XPATH, using = "//span[@class='ussr-theme-sequence-email']//span[normalize-space(text())='Email']")
    private WebElement buttonEmail;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-form-input-wrapper']//input[@placeholder='Select mail from']")
    private WebElement selectMailFrom;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-component-drilldownselect-listview sem-listview jb-ace-scroll-target']//li[@data-searchable='1']")
    private WebElement selectMailFromEntry;
    
    @FindBy(how = How.XPATH, using = "//div[@id='ussr-chrome-panel-pane']//span[normalize-space(text())='Save']")
    private WebElement buttonSave;
    
    public Sequence_ListAll createStepSeq (String seqName) throws Exception
    {	Thread.sleep(6000);
    	inputSeqName.clear();
    	inputSeqName.sendKeys(seqName);
    	Thread.sleep(3000);
    	buttonEmail.click();
    	selectItemBasedOnIndex("Select e-mail", 2);
    	selectMailFrom.click();
    	selectMailFromEntry.click();
    	selectItemBasedOnIndex("Select Send From...", 1);
    	buttonSave.click();
        return PageFactory.initElements(driver, Sequence_ListAll.class);
    } 
}