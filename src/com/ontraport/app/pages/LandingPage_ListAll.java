package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class LandingPage_ListAll extends AbstractPage
{

    protected String   url = "/#!/landing_page/listAll";

    @FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_new']")
    private WebElement clickNewLandingPage;
    
    @FindBy(how = How.XPATH, using = "//*[@class='ussr-dialog-buttons']/button/span[normalize-space(text())='Ok']")
    private WebElement buttonDialogOK;
    
    @FindBy(how = How.LINK_TEXT, using = "Copy")
    private WebElement linkCopy;
    
    @FindBy(how = How.CSS, using = "span.ussr-icon.ussr-icon-checkbox-empty")
	private WebElement checkBox;
    
    public LandingPage_TypeSelection clickNewLandingPage () throws Exception
    {	
    	clickNewLandingPage.click();
        return PageFactory.initElements(driver, LandingPage_TypeSelection.class);
    }
    
    public LandingPage_Edit editLandingPage (String lpName) throws Exception{
    	driver.findElement(By.xpath("//*[normalize-space(text())='" + (lpName) +"']")).click();
    	Thread.sleep(1000);
    	return PageFactory.initElements(driver, LandingPage_Edit.class);
    }
    
    public LandingPage_Edit copyLP (String lpName) throws Exception{
    	//WebElement chkBox = driver.findElement(By.xpath("//tr[td[span[normalize-space(text())='" + lpName + "']]]/descendant::td[3]"));
    	WebElement chkBox1 = driver.findElement(By.xpath("//tr[td[span[normalize-space(text())='SelLP1378546630868']]]/descendant::td[3]"));
    	 
    	chkBox1.click();
    	
    	/*Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']//a[.='"+lpName+"']"))).click().build().perform();
		builder.moveToElement(checkBox).click().build().perform();*/
    	Thread.sleep (2000);
    	linkCopy.click();
    	buttonDialogOK.click();
    	return PageFactory.initElements(driver, LandingPage_Edit.class);
    }
}