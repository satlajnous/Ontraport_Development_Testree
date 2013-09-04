package com.ontraport.app.parts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractPart;

public class SearchBox extends AbstractPart
{
	@FindBy(how = How.XPATH, using = "//input[@type='search']")
    private WebElement searchInput;
	
	@FindBy(how = How.XPATH, using = "//span[@class='ussr-icon ussr-icon-search']")
    private WebElement searchButton;
	
	@FindBy(how = How.CSS, using = "a.ussr-form-input-type-search-clear.position-absolute-right > span.ussr-icon.ussr-icon-close")
    private WebElement closeButton;
	
	public AbstractPart search (String search) throws InterruptedException
    {
    
        searchInput.clear();
        searchInput.sendKeys(search);
        searchButton.click();
        return PageFactory.initElements(driver, this.getClass());
    }
	public AbstractPart clearSearch () throws InterruptedException
    {
        closeButton.click();
        return PageFactory.initElements(driver, this.getClass());
    }
    
}