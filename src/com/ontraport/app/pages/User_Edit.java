package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.parts.ActionsMenu;
import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.tools.AbstractPage;

public class User_Edit extends AbstractPage
{

    protected String   url = "/#!/user/edit&id=";

    @FindBy(how = How.XPATH, using = "//a/span[text()='Actions']")
    private WebElement actionsButton;
    
    @FindBy(how = How.XPATH, using = "//div[a[span[text()='Actions']]]/descendant::a/span[@class='ussr-icon ussr-icon-mail-closed']")
    private WebElement addPermissionButton;
    
    @FindBy(how = How.XPATH, using = "//div[a[span[text()='Actions']]]/descendant::a/span[@class='ussr-icon ussr-icon-trashcan']")
    private WebElement deletePermissionButton;
    
    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public User_Edit sample () throws Exception
    {
        return PageFactory.initElements(driver, User_Edit.class);
    }
   
    public ActionsMenu addPermision () throws Exception
    {
    	actionsButton.click();
    	addPermissionButton.click();
        return PageFactory.initElements(driver, ActionsMenu.class);
    }
    public DialogBox clickDeletePermision () throws Exception
    {
    	actionsButton.click();
    	deletePermissionButton.click();
        return PageFactory.initElements(driver, DialogBox.class);
    }

}