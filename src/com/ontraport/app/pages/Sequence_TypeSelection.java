package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Sequence_TypeSelection extends AbstractPage
{

    protected String   url = "/#!/sequence/typeSelection";

    @FindBy(how = How.XPATH, using = "//div[div[*/text()='Step Sequence']]/descendant::button[*[normalize-space(text())='Create']]")
    private WebElement linkCreateStepSeq;
    
    @FindBy(how = How.XPATH, using = "//div[div[*/text()='Date Sequence']]/descendant::button[*[normalize-space(text())='Create']]")
    private WebElement linkCreateDateSeq;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-chrome-panel-pane-header-back']")
    private WebElement linkBack;
  

    public Sequence_CreateStep clickCreateStepSeq () throws Exception
    {	
    	linkCreateStepSeq.click();
        return PageFactory.initElements(driver, Sequence_CreateStep.class);
    }
    
    public Sequence_CreateDate clickCreateDateSeq () throws Exception
    {	
    	linkCreateDateSeq.click();
        return PageFactory.initElements(driver, Sequence_CreateDate.class);
    }
    
    public Sequence_ListAll clickBack () throws Exception
    {	
    	linkBack.click();
        return PageFactory.initElements(driver, Sequence_ListAll.class);
    }
    
}
