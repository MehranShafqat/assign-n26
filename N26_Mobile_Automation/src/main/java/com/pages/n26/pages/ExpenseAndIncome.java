package com.pages.n26.pages;

import com.pages.n26.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class ExpenseAndIncome extends BasePage {

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard0")
    public MobileElement zeroKeyWord;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard1")
    public MobileElement oneKeyWord;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard2")
    public MobileElement twoKeyWord;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard3")
    public MobileElement threeKeyWord;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard4")
    public MobileElement fourKeyWord;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard5")
    public MobileElement fiveKeyWord;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard6")
    public MobileElement sixKeyWord;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard7")
    public MobileElement sevenKeyWord;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard8")
    public MobileElement eightKeyWord;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard9")
    public MobileElement nineKeyWord;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardClear")
    public MobileElement clearInputFieldBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewNote")
    public MobileElement addNoteField;

    @AndroidFindBy(id = "com.monefy.app.lite:id/keyboard_action_button")
    public MobileElement chooseCategoryBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/textCategoryName")
    public List<MobileElement> categoryTypeBtn;

    public ExpenseAndIncome(AppiumDriver driver) {
        super(driver);
    }

    public void clickOne() {
        clickOnElement(oneKeyWord);
    }

    public void clickTwo() {
        clickOnElement(twoKeyWord);
    }

    public void clickThree() {
        clickOnElement(threeKeyWord);
    }

    public void clickFour() {
        clickOnElement(fourKeyWord);
    }

    public void clickFive() {
        clickOnElement(fiveKeyWord);
    }

    public void clickSix() {
        clickOnElement(sixKeyWord);
    }

    public void clickSeven() {
        clickOnElement(sevenKeyWord);
    }

    public void clickEight() {
        clickOnElement(eightKeyWord);
    }

    public void clickNine() {
        clickOnElement(nineKeyWord);
    }

    public void clickZero() {
        clickOnElement(zeroKeyWord);
    }

    public void clickChooseCategoryBtn() {
        clickOnElement(chooseCategoryBtn);
    }

    public void clickChooseIncomeCategoryType(int item) {
        clickOnElement(categoryTypeBtn.get(item));
    }

    public void clickClearBalanceBtn() {
        clickOnElement(clearInputFieldBtn);
    }

    public void enterNote(String note) {
        setValueInTextField(addNoteField, note);
    }
}