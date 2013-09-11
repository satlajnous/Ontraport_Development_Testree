package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Sequence_ListAll extends AbstractPage
{

    protected String   url = "/#!/sequence/listAll";

    @FindBy(how = How.XPATH, using = "//div[@id='ontraport_panel_action_new']")
    private WebElement linkNewSequence;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ussr-dialog-buttons']//span[normalize-space(text())='Ok']/parent::button")
	private WebElement buttonDialogOK;

	@FindBy(how = How.LINK_TEXT, using = "Copy Sequences")
	private WebElement linkCopySeq;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ussr-chrome-panel-pane']/div[1]/div[1]")
    private WebElement displayPageHeader;

    public Sequence_TypeSelection clickNewSequence () throws Exception
    {	
    	linkNewSequence.click();
        return PageFactory.initElements(driver, Sequence_TypeSelection.class);
    }
    
    public Sequence_Edit editSequence (String seqName) throws Exception{
    	driver.findElement(By.xpath("//*[normalize-space(text())='" + (seqName) +"']")).click();
    	Thread.sleep(1000);
    	return PageFactory.initElements(driver, Sequence_Edit.class);
    }
    
    public Sequence_Edit copySequences(String seqName) throws Exception {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement chkBox= driver.findElement(By.xpath("//a[normalize-space(text())='"+(seqName)+"']/parent::span"));
		chkBox.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		linkCopySeq.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		buttonDialogOK.click();
		Thread.sleep(3000);
		return PageFactory.initElements(driver, Sequence_Edit.class);
	}
    
    public String getTextHomePage () throws Exception{
    	String pageHeader= displayPageHeader.getText().trim();
    	System.out.println("Home Page Header: "+pageHeader);
    	return pageHeader;
    }
}