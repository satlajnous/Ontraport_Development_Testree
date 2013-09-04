package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Login extends AbstractPage
{

    public static String url = "/login.html";

   /* @FindBy(how = How.XPATH, using = "//input[@id='username']")
    private WebElement   loginInputUsername;
    */
    @FindBy(how = How.NAME, using = "username")
    private WebElement   loginInputUsername;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    private WebElement   loginInputPassword;

    @FindBy(how = How.XPATH, using = "//input[@id='login_button']")
    private WebElement   loginInputSubmit;

    public Contact_ListAll as ( String username, String password ) throws InterruptedException
    {
        if ( loginInputUsername.isDisplayed() ) loginInputUsername.sendKeys(username);
        if ( loginInputPassword.isDisplayed() ) loginInputPassword.sendKeys(password);
        if ( loginInputSubmit.isDisplayed() ) loginInputSubmit.click();
        
        /*driver.findElement(By.("username")).clear();*/
        return PageFactory.initElements(driver, Contact_ListAll.class); //Page Factory Syntax
    }

}
