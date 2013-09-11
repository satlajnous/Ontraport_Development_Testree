package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Sequence_Edit extends AbstractPage
{

    protected String   url = "/#!/sequence/edit&id=";

    @FindBy(how = How.XPATH, using = "//*[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")
    private WebElement getSeqName;
    
    @FindBy(how = How.XPATH, using = "//div[@id='ussr-chrome-panel-pane']//span[normalize-space(text())='Save']")
    private WebElement buttonSave;
    
    public String getSeqName () throws Exception
    {	
    	String seqName= getSeqName.getAttribute("value");
    	System.out.println("Seq Name: "+ seqName);
        return seqName;
    }
    
    public void saveLP() {
		buttonSave.click();
	}

}