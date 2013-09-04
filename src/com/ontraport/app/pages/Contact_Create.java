package com.ontraport.app.pages;
/*
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
*/
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;

public class Contact_Create extends AbstractPage
{
    @FindBy(how = How.XPATH, using = "//label[text()='First Name']/following-sibling::div/input")
    private WebElement inputFirstName;

    @FindBy(how = How.XPATH, using = "//label[text()='Last Name']/following-sibling::div/input")
    private WebElement inputLastName;

    @FindBy(how = How.XPATH, using = "//label[text()='Email']/following-sibling::div/input")
    private WebElement inputEmail;

    @FindBy(how = How.XPATH, using = "//button//span[text()='Save']")
    private WebElement buttonSave;

    public Contact_Create ()
    {
/*
        try
        {
            Properties properties = new Properties();
            Integer count = 10;
            while (count-- > 0)
            {
                String ts = String.valueOf(System.nanoTime());
                properties.setProperty("first_name." + count, "Selenium" + ts);
                properties.setProperty("last_name." + count, "Tester" + ts);
            }
            File file = new File("contacts.xml");
            FileOutputStream fileOut = new FileOutputStream(file);
            properties.storeToXML(fileOut, "Contacts");
            fileOut.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
*/
    }
    public Contact_ListAll saveContact (String firstName, String lastName, String email) throws InterruptedException
    {
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputEmail.sendKeys(email);
        buttonSave.click();
        return PageFactory.initElements(driver, Contact_ListAll.class);
    }
}
