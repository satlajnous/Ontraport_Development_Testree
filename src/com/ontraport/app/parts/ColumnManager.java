package com.ontraport.app.parts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractPart;

public class ColumnManager extends AbstractPart
{
	@FindBy(how = How.XPATH, using = "//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[2]/table/thead/tr/th/div/div/button")
    private WebElement columnDropDown;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ussr-chrome-panel-pane']//div[.='Zip Code']")
    private WebElement zipCode;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[2]/div/div/a[1]/span")
    private WebElement check;
	
	@FindBy(how = How.CSS, using = "span.ussr-icon.ussr-icon-trashcan")
    private WebElement trash;
	
	public Contact_ListAll addZipCode () throws InterruptedException
    {
    	columnDropDown.click();
    	zipCode.click();
    	check.click();
    	return PageFactory.initElements(driver, Contact_ListAll.class);
    }
	public Contact_ListAll delete () throws InterruptedException
    {
    	trash.click();
    	return PageFactory.initElements(driver, Contact_ListAll.class);
    }
}
