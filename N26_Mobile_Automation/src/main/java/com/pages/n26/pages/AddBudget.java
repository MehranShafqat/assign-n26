package com.pages.n26.pages;

import com.pages.n26.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddBudget extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.EditText")
    public MobileElement enterBudget;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
    public MobileElement okBtn;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]")
    public MobileElement cancelBtn;

    public AddBudget(AppiumDriver driver) {
        super(driver);
    }

    public void enterBudget(String value){
        setValueInTextField(enterBudget,value);
    }

    public void clickOkBtn(){
        clickOnElement(okBtn);
    }
}
