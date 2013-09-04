package com.ontraport.app.parts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class ActionsMenu extends AbstractPart
{	
	
	@FindBy(how = How.XPATH, using = "//div[@id='ussr-chrome-panel-pane']//a[normalize-space(.)='Delete API KEY']")
    private WebElement deleteAPI;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Choose an Permission Exception']]/descendant::button")
    private WebElement permissionExceptionDropDown;
	
	@FindBy(how = How.XPATH, using = "//div[input[@placeholder='Choose an Permission Exception']]/descendant::li/div[text()='Can View Contacts']")
    private WebElement canViewContacts;
	
	@FindBy(how = How.XPATH, using = "//div[input[normalize-space(@placeholder)='Select Can View Contacts...']]/descendant::button")
    private WebElement viewContactsDropDown;
	
	@FindBy(how = How.XPATH, using = "//div[input[@placeholder='Select Can View Contacts...']]/descendant::li/div[.='All)']")
    private WebElement allSelect;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Add Exception']")
    private WebElement addException;
	
    @FindBy(how = How.XPATH, using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer ')]")
    private WebElement actionsMenu;

    @FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_group_actions']/span[text()='Actions']")
    protected WebElement      linkActionsMenu;

    @FindBy(how = How.XPATH, using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer ')]//a/text()[contains(.,'Send E-Mail')]/..")
    private WebElement linkSendEmail;

    @FindBy(how = How.XPATH, using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer ')]//a/text()[contains(.,'Send SMS')]/..")
    private WebElement linkSendSms;

    @FindBy(how = How.XPATH, using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer ')]//a/text()[contains(.,'Send Postcard')]/..")
    private WebElement linkSendPostcard;

    @FindBy(how = How.XPATH, using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer ')]//a/text()[contains(.,'Delete Contacts')]/..")
    private WebElement linkDeleteContacts;

    @FindBy(how = How.XPATH, using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer ')]//a/text()[contains(.,'Sequences')]/..")
    private WebElement linkSequences;

    @FindBy(how = How.XPATH, using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer ')]//a/text()[contains(.,'Add/Remove Tags')]/..")
    private WebElement linkAddRemoveTags;

    @FindBy(how = How.XPATH, using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer ')]//a/text()[contains(.,'Change Field Value')]/..")
    private WebElement linkChangeFieldValue;

    @FindBy(how = How.XPATH, using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer ')]//a/text()[contains(.,'Send Double Opt In Confirmation')]/..")
    private WebElement linkSendDoubleOptInConfirmation;

    @FindBy(how = How.XPATH, using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer ')]//a/text()[contains(.,'Export Contacts')]/..")
    private WebElement linkExportContacts;
    
    @FindBy(how = How.XPATH, using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer ')]//a/text()[contains(.,'Delete Router')]/..")
    private WebElement linkDeleteRouter;
  
    @FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_group_edit']//span[.='Manage Groups']")
    private WebElement linkManageGroups;
  
    @FindBy(how = How.XPATH, using = "//div[@class='group_editor_name']/span/div/div/input")
    private WebElement groupNameInput;
    
    @FindBy(how = How.XPATH, using = "//div[@class='group_editor_public']//button[normalize-space(.)='<br>']")
    private WebElement permissionDropDown;
    
    @FindBy(how = How.XPATH, using = "//ul[@class='ussr-component-drilldownselect-ul']//div[.='Everyone can view & Edit']")
    private WebElement everyoneCanViewAndEdit;
    
    @FindBy(how = How.XPATH, using = "//tr[@class='sem_condition_row']//button[normalize-space(.)='<br>']")
    private WebElement fieldDropDown;
    
    @FindBy(how = How.XPATH, using = "//tr[@class='sem_condition_row']//div[.='First Name']")
    private WebElement nameField;
    
    @FindBy(how = How.XPATH, using = "//tr[@class='sem_condition_row']/td[2]/span/div/div/button")
    private WebElement conditionDropDown;
    
    @FindBy(how = How.XPATH, using = "//ul[@class='ussr-component-drilldownselect-ul']//div[.='equals']")
    private WebElement equalsCondition;
    
    @FindBy(how = How.XPATH, using = "//ul[@class='ussr-component-drilldownselect-ul']//div[.='contains']")
    private WebElement containsCondition;
    
    @FindBy(how = How.CSS, using = "input.ussr-border-solid-all")
    private WebElement valueInput;
    
    @FindBy(how = How.XPATH, using = "//div[@class='group-editor-button-wrapper-left']//button[.='Save']")
    private WebElement saveButton;
    
    @FindBy(how = How.XPATH, using = "//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='<br>']")
    private WebElement groupDropDown;
    
    @FindBy(how = How.XPATH, using = "//ul[@class='ussr-component-drilldownselect-ul']//div[.='Group: All']")
    private WebElement groupAll;
    
    @FindBy(how = How.XPATH, using = "//div[@class='group-editor-button-wrapper-right']//button[.='Delete Group']")
    private WebElement deleteGroup;
    
    public AbstractPage close () throws Exception
    {
        linkActionsMenu.click();
        return null;
    }
    public AbstractPage createPermission () throws Exception
    {
    	permissionExceptionDropDown.click();
    	canViewContacts.click();
    	viewContactsDropDown.click();
    	allSelect.click();
    	addException.click();
    	return null;
    }
    public AbstractPage createGroup (String groupName, String value) throws Exception
    {
        linkManageGroups.click();
        groupNameInput.click();
        groupNameInput.clear();
        groupNameInput.sendKeys(groupName);
        permissionDropDown.click();
        everyoneCanViewAndEdit.click();
        fieldDropDown.click();
        nameField.click();
        conditionDropDown.click();
        containsCondition.click();
        valueInput.click();
        valueInput.clear();
        valueInput.sendKeys(value);
        saveButton.click();
        return null;
    }
    public AbstractPage selectGroupAll () throws Exception
    {
        groupDropDown.click();
        groupAll.click();
        return null;
    }
    public AbstractPage clickGroupDropDown () throws Exception
    {
        groupDropDown.click();
        return null;
    }
    public AbstractPage deleteGroup () throws Exception
    {
        linkManageGroups.click();
        deleteGroup.click();
        return null;
    }
    public AbstractPage clickDeleteContact () throws Exception
    {
    	linkDeleteContacts.click();
        return null;
    }
    public AbstractPage clickDeleteRouter () throws Exception
    {
    	linkDeleteRouter.click();
        return null;
    }
    public AbstractPage clickDeleteAPI () throws Exception
    {
    	deleteAPI.click();
        return null;
    }
    public Boolean isVisible ()
    {
        return actionsMenu.isDisplayed();
    }
    
    public AbstractPage save()throws Exception{
    	saveButton.click();
    	return null;
    }
}
