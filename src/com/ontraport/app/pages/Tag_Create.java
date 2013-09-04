package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Tag_Create extends AbstractPage
{

    protected String   url = "/#!/tag/create";

    @FindBy(how = How.XPATH, using = "//label[text()='Name']/following-sibling::div/input")
    private WebElement inputNameField;
    
    @FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
    private WebElement buttonSave;

    public Tag_ListAll newTag (String tagName) throws Exception
    {	
    	inputNameField.sendKeys(tagName);
    	Thread.sleep(500);
    	buttonSave.click();
        return PageFactory.initElements(driver, Tag_ListAll.class);
    }

}