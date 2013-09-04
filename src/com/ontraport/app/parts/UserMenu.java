package com.ontraport.app.parts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.User_Edit;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class UserMenu extends AbstractPart
{	
	@FindBy(how = How.XPATH, using = "//div[@id='ussr-chrome-wrapper']//*[@class='ussr-corner-bl']//a[normalize-space(text())='Personal Settings']")
    private WebElement personalSettings;
	
	@FindBy(how = How.XPATH, using = "//li[@class='ussr-header-nav-option-user']//a[.='Admin']")
    private WebElement Admin;
	
	public User_Edit clickPersonalSettings () throws Exception
    {
        personalSettings.click();
        return PageFactory.initElements(driver, User_Edit.class);
    }
	public Account_View clickAdmin () throws Exception
    {
        Admin.click();
        return PageFactory.initElements(driver, Account_View.class);
    }
}
