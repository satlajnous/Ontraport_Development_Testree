package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ontraport.app.tools.Common;

import com.ontraport.app.tools.AbstractPage;

public class FieldEditor extends AbstractPage
{
	@FindBy(how = How.XPATH, using = "//div[@class='jb-ace-scroll-wrapper jb-ace-scroll jb-ace-scroll-orientation-vertical']//div[@class='jb-ace-scroll-scrollbar-middle']")
    private WebElement scrollBar;
	
	@FindBy(how = How.XPATH, using = "//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']")
    private WebElement newSectionButton;
	
	@FindBy(how = How.XPATH, using = "//div[@class='ussr-component-section-titlebar ussr-border-solid-bottom']//span[normalize-space(text())='Untitled']")
    private WebElement title;
	
	@FindBy(how = How.XPATH, using = "//div//div[normalize-space(text())='Section Description']")
    private WebElement sectionDescription;
	
	@FindBy(how = How.CSS, using = "input.ussr-widget-editinplace-input")
    private WebElement input;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")
    private WebElement save;

	
	public FieldEditor scrollDown () throws Exception
    {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions dragger = new Actions(driver);
		for (int i=10;i<2000;i=i+100){
	    	try{
	    		
	   			//try { if (isElementPresent(By.xpath("//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']"))) break; } catch (Exception e) {}
	        	
	   			dragger.moveToElement(scrollBar).clickAndHold().moveByOffset(0,100).release().perform();
	   			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Contact Information']")));	    
	   		}catch(Exception e1){}
    	}
        return PageFactory.initElements(driver, FieldEditor.class);
    }
	public FieldEditor newSection () throws Exception
    {
		newSectionButton.click();
        return PageFactory.initElements(driver, FieldEditor.class);
    }
	public Contact_Settings SaveASection (String name, String description) throws Exception
    {
		title.click();
		input.sendKeys(name);
		sectionDescription.click();
		input.sendKeys(description);
		save.click();
        return PageFactory.initElements(driver, Contact_Settings.class);
    }
	public Contact_Settings Save () throws Exception
    {
		save.click();
        return PageFactory.initElements(driver, Contact_Settings.class);
    }
}
