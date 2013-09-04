package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class ApiSettings_Create extends AbstractPage
{

    protected String   url = "/#!/api_settings/create";
    
    @FindBy(how = How.XPATH, using = "//div[@id='ussr-chrome-panel-pane']/div[3]/div[1]/div[3]/div/div/div/input")
    private WebElement apiName;
  
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-form-column']//button[normalize-space(.)='<br>']")
    private WebElement contactOwnerDropDown;
    
    @FindBy(how = How.CSS, using = "div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")
    private WebElement firstDropDown;
    
    @FindBy(how = How.XPATH, using = "//div[@class='component-api-generate-target-add']/div/div/div/a/span[1]")
    private WebElement addCheckbox;
    
    @FindBy(how = How.XPATH, using = "//div[@class='component-api-generate-target-delete']/div/div/div/a/span[1]")
    private WebElement deleteCheckbox;
    
    @FindBy(how = How.XPATH, using = "//div[@class='component-api-generate-target-create-key']/div/div/div/a/span[1]")
    private WebElement createCheckbox;
    
    @FindBy(how = How.XPATH, using = "//div[@class='component-api-generate-target-search']/div/div/div/a/span[1]")
    private WebElement searchCheckbox;
    
    @FindBy(how = How.XPATH, using = "//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")
    private WebElement saveButton;
    
    @FindBy(how = How.XPATH, using = "//body")
    private WebElement body;

    public ApiSettings_Create sample () throws Exception
    {
        return PageFactory.initElements(driver, ApiSettings_Create.class);
    }
    
    public ApiSettings_ListAll createKey (String APIName) throws Exception
    {
    	apiName.click();
    	apiName.clear();
    	apiName.sendKeys(APIName);
    	contactOwnerDropDown.click();
    	firstDropDown.click();
    	addCheckbox.click();
    	deleteCheckbox.click();
    	createCheckbox.click();
    	searchCheckbox.click();
    	saveButton.click();
        return PageFactory.initElements(driver, ApiSettings_ListAll.class);
    }

}