package com.test.n26.tests;

import com.pages.n26.pages.*;
import com.test.n26.base.BaseTest;
import com.test.n26.listeners.TestListener;
import com.test.n26.utils.TestUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddExpenseIncome extends BaseTest {

    AppLanding onBoardingPage;
    AppHome homePage;
    ExpenseAndIncome addIncomePage;
    MenuBar menuBarPage;
    TestUtils utils;
    SearchExpense resultsPage;

    JSONObject jsonObject;

    @BeforeClass
    public void beforeClass() throws IOException, ParseException {
        onBoardingPage = new AppLanding(getDriver());
        homePage = new AppHome(getDriver());
        addIncomePage = new ExpenseAndIncome(getDriver());
        utils = new TestUtils();
        menuBarPage = new MenuBar(getDriver());
        resultsPage = new SearchExpense(getDriver());
        jsonObject = utils.readJSONFileData();
    }

    @Test(priority = 1)
    public void addIncome() {

        utils.closeStartingDialogs(onBoardingPage);

        homePage.clickAddIncomeBtn();
        TestListener.info("Add Income button clicked.");

        addIncomePage.enterNote("Testing note.");
        TestListener.info("Note added.");

        addIncomePage.clickThree();
        TestListener.info("3 button clicked.");
        addIncomePage.clickFive();
        TestListener.info("5 button clicked.");
        addIncomePage.clickZero();
        TestListener.info("0 button clicked.");
        addIncomePage.clickZero();
        TestListener.info("0 button clicked.");

        addIncomePage.clickChooseCategoryBtn();
        TestListener.info("Choose Category button clicked.");

        addIncomePage.clickChooseIncomeCategoryType(1);
        TestListener.info("Savings button clicked.");

        Assert.assertEquals(homePage.incomeAmountTxt.getText(), jsonObject.get("totalIncome"));

    }

    @Test(priority = 2)
    public void addExpense() {

        homePage.clickAddExpenseBtn();
        TestListener.info("Add Income button clicked.");

        addIncomePage.clickThree();
        TestListener.info("3 button clicked.");
        addIncomePage.clickZero();
        TestListener.info("0 button clicked.");
        addIncomePage.clickZero();
        TestListener.info("0 button clicked.");

        addIncomePage.clickChooseCategoryBtn();
        TestListener.info("Choose Category button clicked.");

        addIncomePage.clickChooseIncomeCategoryType(1);
        TestListener.info("Car expense button clicked.");

        Assert.assertEquals(homePage.expenseAmountTxt.getText(), jsonObject.get("expense"));

        Assert.assertEquals(homePage.balanceAmountTxt.getText(), jsonObject.get("balance"));

    }

    @Test(priority = 3)
    public void searchExpenses() {

        menuBarPage.clickSearchIcon();
        TestListener.info("Search Icon button clicked.");

        menuBarPage.searchRecords("Car");
        TestListener.info("Car entered to search.");

        menuBarPage.clickSearchResult();
        TestListener.info("Search result clicked.");

        Assert.assertEquals(resultsPage.itemTitle.getText(), jsonObject.get("item"));
        Assert.assertEquals(resultsPage.itemPrice.getText(), jsonObject.get("expense"));
        assert (resultsPage.itemDate).isDisplayed();
        TestListener.info("Item date is displayed.");

    }

    @Test(priority = 4)
    public void updateExpense() {

        resultsPage.clickTitleView();
        TestListener.info("Car expense button clicked.");

        addIncomePage.clickClearBalanceBtn();
        addIncomePage.clickClearBalanceBtn();
        TestListener.info("Expense remove button clicked.");

        addIncomePage.clickFive();
        TestListener.info("5 button clicked.");
        addIncomePage.clickZero();
        TestListener.info("0 button clicked.");

        addIncomePage.clickChooseCategoryBtn();
        TestListener.info("Car expense button clicked.");

        addIncomePage.clickChooseIncomeCategoryType(1);
        TestListener.info("Car button clicked.");

        resultsPage.clickBackBtn();
        TestListener.info("Back button clicked");

        Assert.assertEquals(homePage.balanceAmountTxt.getText(), jsonObject.get("newBalance"));
        TestListener.info("Car expense button clicked.");

    }

    @Test(priority = 5)
    public void deleteExpense() {

        menuBarPage.clickSearchIcon();
        TestListener.info("Search Icon button clicked.");

        menuBarPage.searchRecords("Car");
        TestListener.info("Car entered to search.");

        menuBarPage.clickSearchResult();
        menuBarPage.clickSearchResult();
        TestListener.info("Search result clicked.");

        Assert.assertEquals(resultsPage.itemTitle.getText(), jsonObject.get("item"));
        Assert.assertEquals(resultsPage.itemPrice.getText(), jsonObject.get("newExpense"));
        assert (resultsPage.itemDate).isDisplayed();
        TestListener.info("Item date is displayed.");

        resultsPage.clickTitleView();
        TestListener.info("Car expense title clicked.");

        resultsPage.clickDeleteIcon();
        TestListener.info("Car expense delete button clicked.");

    }
}