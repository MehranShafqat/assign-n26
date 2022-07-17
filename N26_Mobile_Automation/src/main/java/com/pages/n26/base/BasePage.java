package com.pages.n26.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void waitForVisibilityOfItem(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForElementToBeAbleToClick(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(e)));
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public void setValueInTextField(MobileElement e, String txt) {
        waitForVisibilityOfItem(e);
        e.clear();
        e.sendKeys(txt);
    }

    public void clickOnElement(MobileElement e) {
        waitForVisibilityOfItem(e);
        waitForElementToBeAbleToClick(e);
        e.click();
    }
}