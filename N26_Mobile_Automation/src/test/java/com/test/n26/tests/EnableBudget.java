package com.test.n26.tests;

import com.pages.n26.pages.*;
import com.test.n26.base.BaseTest;
import com.test.n26.utils.TestUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.test.n26.listeners.TestListener.info;

public class EnableBudget extends BaseTest {

    AppLanding onBoardingPage;
    AppSettings settingsPage;
    MenuBar menuBarPage;
    CategoriesList categoriesPage;
    TestUtils generalUtils;
    AppHome home;
    JSONObject jsonObject;

    AddBudget addBudget;

    @BeforeClass
    public void beforeClass() throws IOException, ParseException {
        onBoardingPage = new AppLanding(getDriver());
        settingsPage = new AppSettings(getDriver());
        menuBarPage = new MenuBar(getDriver());
        categoriesPage = new CategoriesList(getDriver());
        generalUtils = new TestUtils();
        home = new AppHome(getDriver());
        jsonObject = generalUtils.readJSONFileData();
        addBudget = new AddBudget(getDriver());
    }

    @AfterMethod
    public void clearApp() {
        getDriver().resetApp();
    }

    @Test
    public void enableBudgetMode() {
        generalUtils.closeStartingDialogs(onBoardingPage);

        menuBarPage.clickSettingsBtn();
        info("Setting button clicked.");

        settingsPage.clickSettingsBtn();
        info("Account Setting button clicked.");

        categoriesPage.enableBudgetMode();
        info("Enable budget button clicked.");

        addBudget.enterBudget(jsonObject.get("addInitialAmount").toString());
        info("Budget amount added.");

        addBudget.clickOkBtn();
        info("OK button clicked.");

        Assert.assertEquals(categoriesPage.budgetAmount.getText(), jsonObject.get("initialAmount").toString());
        info("Budget added successfully and verified.");

        settingsPage.clickSettingsBtn();
        info("Setting button clicked.");

        Assert.assertEquals(home.balanceAmountTxt.getText(), jsonObject.get("budgetBalance").toString());
        info("Budget added successfully and verified from home screen.");
    }
}