package com.pages.n26.pages;

import com.pages.n26.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class Account extends BasePage {

    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewName")
    public List<MobileElement> addBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewAmount")
    public List<MobileElement> accountAmount;

    @AndroidFindBy(id = "com.monefy.app.lite:id/editTextCategoryName")
    public MobileElement nameField;

    @AndroidFindBy(id = "com.monefy.app.lite:id/accountCurrency")
    public MobileElement currencyField;

    @AndroidFindBy(id = "com.monefy.app.lite:id/initialAmount")
    public MobileElement initialAmountField;

    @AndroidFindBy(id = "com.monefy.app.lite:id/imageView")
    public List<MobileElement> accountType;

    @AndroidFindBy(id = "com.monefy.app.lite:id/save")
    public MobileElement addAccountBtn;

    public Account(AppiumDriver driver) {
        super(driver);
    }

    public void clickAddBtn() {
        clickOnElement(addBtn.get(0));
    }

    public void enterUserName(String name) {
        setValueInTextField(nameField, name);
    }

    public void enterCurrency(String currency) {
        setValueInTextField(currencyField, currency);
    }

    public void enterInitialAmount(String name) {
        setValueInTextField(initialAmountField, name);
    }

    public void btnAccountType() {
        clickOnElement(accountType.get(0));
    }

    public void btnSaveData() {
        clickOnElement(addAccountBtn);
    }
}