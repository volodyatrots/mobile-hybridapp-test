package com.epam.lab;

import com.epam.lab.businessobjects.BrowserBO;
import com.epam.lab.businessobjects.GmailLoginBO;
import com.epam.lab.driver.Driver;
import com.epam.lab.models.UserModel;
import com.epam.lab.utils.provider.TestProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class TestHybridApp {
    private GmailLoginBO gmailLoginBO;
    private BrowserBO browserBO;

    @BeforeMethod
    public void setUp() {
        gmailLoginBO = new GmailLoginBO();
        browserBO=new BrowserBO();

    }

    @Test(dataProvider = "getUsersData", dataProviderClass = TestProvider.class)
    public void testBrowserwithWebGmail(UserModel userModel){
        browserBO.showCurrentTabs();
        browserBO.openMenu();
        browserBO.createNewTab();
        gmailLoginBO.openLoginPage();
        Driver.getDriver().switchTo().window("WebView");
        gmailLoginBO.loginAS(userModel);
        assertTrue(gmailLoginBO.checkLoginSuccess());
    }

    @AfterMethod
    public void closeDriver() {
        Driver.close();
    }
}