package com.ontraport.app.parts;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractPart;

public class DialogBox extends AbstractPart
{
	@FindBy(how = How.XPATH, using = "//*[@class='ussr-dialog-buttons']/button/span[normalize-space(text())='Ok']")
    private WebElement okDialogButton;

	@FindBy(how = How.XPATH, using = "//div[@class='ussr-dialog-buttons']//button[.='OK']")
    private WebElement okDialogButton2;
	
	public AbstractPart acceptMessage () throws InterruptedException
    {
    	okDialogButton.click();
        return null;

    }
	public Contact_ListAll acceptMessageToContact () throws InterruptedException
    {
    	okDialogButton2.click();
    	return PageFactory.initElements(driver, Contact_ListAll.class);
    }
}
