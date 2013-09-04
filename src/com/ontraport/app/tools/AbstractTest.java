package com.ontraport.app.tools;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public abstract class AbstractTest
{

    protected static WebDriver driver;
    protected Common           common             = new Common();
    protected ContactInfo      contactInfo        = new ContactInfo();
    
    @Rule
    public Screenshot          screenshotTestRule = new Screenshot();

    public AbstractTest ()
    {
        driver = AbstractSuite.getDriver();
    }

    @BeforeClass
    public static void beforeTest ()
    {
    }

    @Before
    public void beforeEachTest ()
    {
    }

    @After
    public void afterEachTest ()
    {
    }

    @AfterClass
    public static void afterTest ()
    {
    }
    
    class Screenshot implements MethodRule
    {
        public Statement apply ( final Statement statement, final FrameworkMethod frameworkMethod, final Object o )
        {
            return new Statement()
            {
                @Override
                public void evaluate () throws Throwable
                {
                    try
                    {
                        statement.evaluate();
                    }
                    catch (Throwable t)
                    {
                        captureScreenshot(frameworkMethod.getName());
                        throw t;
                    }
                }

                public void captureScreenshot ( String fileName )
                {
                    try
                    {
                        new File("screenshots/").mkdirs();
                        FileOutputStream out = new FileOutputStream("screenshots/failure-" + fileName + ".png");
                        out.write(( (TakesScreenshot) driver ).getScreenshotAs(OutputType.BYTES));
                        out.close();
                    }
                    catch (Exception e)
                    {
                    }
                }
            };
        }
    }
}
