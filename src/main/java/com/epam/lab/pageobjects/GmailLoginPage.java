package com.epam.lab.pageobjects;


import com.epam.lab.control.elements.Button;
import com.epam.lab.control.elements.TextInput;
import com.epam.lab.driver.Driver;
import com.epam.lab.utils.property.ConfigProperty;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage extends WebPageObject {
    private Boolean statusLoad;

    @FindBy(css = "input[type='email']")
    private TextInput emailInput;

    @FindBy(css = ".V.j.od")
    private Button composeButton;

    @FindBy(css = "input[name='password']")
    private TextInput passwordInput;

    public void openLoginPage() {
        ConfigProperty configProperty = new ConfigProperty();
        Driver.getDriver().get(configProperty.getGmailLink());
    }

    public void enterEmail(String mail) {
        emailInput.sendKeys(mail + Keys.ENTER);
    }

    public void enterPassword(String pass) {
        passwordInput.sendKeys(pass + Keys.ENTER);
    }

    public boolean checkLoadInbox() {
        if ((new WebDriverWait(Driver.getDriver(), 60)).until(ExpectedConditions.elementToBeClickable(composeButton)) != null) {
            statusLoad = true;
        }
        return statusLoad;
    }
}
