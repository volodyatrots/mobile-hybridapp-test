package com.epam.lab.pageobjects;

import com.epam.lab.driver.Driver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

class MobilePageObject {
    MobilePageObject() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }
}

