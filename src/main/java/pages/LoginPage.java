package pages;

import org.openqa.selenium.By;
import utils.Utils;

public class LoginPage {

    private final Utils utils = new Utils();

    public static final By USERNAME_FIELD = By.cssSelector("input[id='username']");
    public static final By PASSWORD_FIELD = By.cssSelector("input[id='password']");
    public static final By CONTINUE_BUTTON = By.cssSelector("li[id='submitRow']");
    public static final By LOG_IN_BUTTON = By.xpath("//nav[@class='utility-nav']//a[text()='Log In']");
    public static final By SIGN_IN_BUTTON = By.cssSelector("input[value='Sign in']");
    public static final By ERROR_MESSAGE = By.cssSelector("div[id='responseMessage']");

    public void enterUsername(String username) {
        utils.waitForElement(USERNAME_FIELD);
        utils.enter(USERNAME_FIELD, username);
    }

    public void enterPassword(String password) {
        utils.waitForElement(PASSWORD_FIELD);
        utils.enter(PASSWORD_FIELD, password);
    }

    public void clickContinueButton() {
        utils.waitForElement(CONTINUE_BUTTON);
        utils.click(CONTINUE_BUTTON);
    }

    public void clickLogInButton() {
        utils.waitForElement(LOG_IN_BUTTON);
        utils.click(LOG_IN_BUTTON);
    }

    public void clickSignInButton() {
        utils.waitForElement(SIGN_IN_BUTTON);
        utils.click(SIGN_IN_BUTTON);
    }
    public String getTextFromErrorMessage() {
        utils.waitForElement(ERROR_MESSAGE);
        return utils.getText(ERROR_MESSAGE);
    }
}
