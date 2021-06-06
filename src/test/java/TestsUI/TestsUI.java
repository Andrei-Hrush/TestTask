package TestsUI;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsUI extends BaseTest {

    @Test
    public void loginWithCorrectCredentials() {
        loginPage.enterUsername(configs.getProperty("username"));
        loginPage.clickContinueButton();
        loginPage.enterPassword(configs.getProperty("password"));
        loginPage.clickSignInButton();
        Assert.assertEquals(mainPage.checkUsername(),"test.andrei777@gmail.com", "The user is not logged in, or the username does not match");
    }

    @Test
    public void loginWithoutCredentials() {
        loginPage.clickContinueButton();
        Assert.assertEquals(loginPage.getTextFromErrorMessage(),"Required data missing", "The error text doesn't match the expected result");
    }

    @Test
    public void checkCreatedNote() {
        loginPage.enterUsername(configs.getProperty("username"));
        loginPage.clickContinueButton();
        loginPage.enterPassword(configs.getProperty("password"));
        loginPage.clickSignInButton();
        int countOfNotes = mainPage.checkCountOfCreatedNotes();
        System.out.println(countOfNotes);
        mainPage.createNewNote();
        mainPage.clickLogout();
        loginPage.clickLogInButton();
        loginPage.enterUsername(configs.getProperty("username"));
        loginPage.clickContinueButton();
        loginPage.enterPassword(configs.getProperty("password"));
        loginPage.clickSignInButton();
        Assert.assertEquals(mainPage.checkCountOfCreatedNotes(),countOfNotes + 1, "Count of elements found doesn't match the expected result");
    }

    @Test
    public void checkCreatedTable() {
        loginPage.enterUsername(configs.getProperty("username"));
        loginPage.clickContinueButton();
        loginPage.enterPassword(configs.getProperty("password"));
        loginPage.clickSignInButton();
        mainPage.createNewNote();
        mainPage.createTable();
        mainPage.addRowToTable();
        mainPage.addColumnToTable();
        Assert.assertEquals(mainPage.checkCountOfRowsInTable(),3, "Count of rows found doesn't match the expected result");
        Assert.assertEquals(mainPage.checkCountOfColumnsInTable(),3, "Count of columns found doesn't match the expected result");
    }
}
