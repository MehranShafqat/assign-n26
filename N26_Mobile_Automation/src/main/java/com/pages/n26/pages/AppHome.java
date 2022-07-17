package com.pages.n26.pages;

import com.pages.n26.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class AppHome extends BasePage {

    @AndroidFindBy(id = "com.monefy.app.lite:id/pts_main")
    public MobileElement dateTimeTxt;

    @AndroidFindBy(id = "com.monefy.app.lite:id/expense_button")
    public MobileElement addExpenseBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/income_button")
    public MobileElement addIncomeBtn;

    @AndroidFindBy(id = "com.monefy.app.lite:id/balance_amount")
    public MobileElement balanceAmountTxt;

    @AndroidFindBy(id = "com.monefy.app.lite:id/income_amount_text")
    public MobileElement incomeAmountTxt;

    @AndroidFindBy(id = "com.monefy.app.lite:id/expense_amount_text")
    public MobileElement expenseAmountTxt;

    @AndroidFindBy(id = "android.widget.ImageView")
    public List<MobileElement> expenseItemsList;

    public void clickAddExpenseBtn() {
        clickOnElement(addExpenseBtn);
    }

    public void clickAddIncomeBtn() {
        clickOnElement(addIncomeBtn);
    }

    public void clickExpenseItemsList(int item) {
        clickOnElement(expenseItemsList.get(item));
    }

    public AppHome(AppiumDriver driver) {
        super(driver);
    }
}