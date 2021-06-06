package pages;

import org.openqa.selenium.By;
import utils.Utils;

public class MainPage {

    private final Utils utils = new Utils();

    public static final By USERNAME = By.cssSelector("div[class='_2nB_7KEJsuhQKdDMrrWUp8']");
    public static final By NEW_NOTE_BUTTON = By.cssSelector("button[id='qa-CREATE_NOTE']");
    public static final By SIGN_OUT_BUTTON = By.cssSelector("a[id='qa-ACCOUNT_DROPDOWN_LOGOUT']");
    public static final By EXIT_ANYWAY_BUTTON = By.cssSelector("button[id='qa-LOGOUT_CONFIRM_DIALOG_SUBMIT']");
    public static final By CREATED_NOTES = By.cssSelector("article[role='presentation']");
    public static final By NOTE_SECTION = By.cssSelector("div[id='qa-HOME_NOTE_WIDGET_CREATE_NOTE']");
    public static final By INSERT_DROPDOWN_BUTTON = By.cssSelector("div[title='Insert']>div");
    public static final By TABLE_BUTTON = By.cssSelector("div[data-tooltipmark='formattertable']");
    public static final By ADD_ROW_BUTTON = By.cssSelector("div[data-testid='enTable-rowInsertion-1']");
    public static final By ADD_COLUMN_BUTTON = By.cssSelector("div[data-testid='enTable-columnInsertion-1']");
    public static final By TABLE_ROWS = By.cssSelector("table>tbody>tr");
    public static final By TABLE_COLUMNS = By.cssSelector("table>tbody>tr:first-of-type>td");
    public static final By NOTE_EDITOR_IFRAME = By.cssSelector("iframe[title='Note Editor']");


    public String checkUsername() {
        utils.waitForElement(USERNAME);
        return utils.getText(USERNAME);
    }

    public void createNewNote() {
        utils.waitForElement(NEW_NOTE_BUTTON);
        utils.click(NEW_NOTE_BUTTON);
    }

    public int checkCountOfCreatedNotes() {
        utils.waitForElement(NOTE_SECTION);
        return utils.countOfElements(CREATED_NOTES);
    }

    public int checkCountOfRowsInTable() {
        utils.switchToIframe(NOTE_EDITOR_IFRAME);
        int count = utils.countOfElements(TABLE_ROWS);
        utils.switchToDefaultContent();
        return count;
    }

    public int checkCountOfColumnsInTable() {
        utils.switchToIframe(NOTE_EDITOR_IFRAME);
        int count = utils.countOfElements(TABLE_COLUMNS);
        utils.switchToDefaultContent();
        return count;
    }

    public void clickLogout() {
        utils.waitForElement(USERNAME);
        utils.click(USERNAME);
        utils.waitForElement(SIGN_OUT_BUTTON);
        utils.click(SIGN_OUT_BUTTON);
        utils.waitForElement(EXIT_ANYWAY_BUTTON);
        utils.click(EXIT_ANYWAY_BUTTON);
    }

    public void createTable() {
        utils.waitForElement(INSERT_DROPDOWN_BUTTON);
        utils.click(INSERT_DROPDOWN_BUTTON);
        utils.waitForElement(TABLE_BUTTON);
        utils.click(TABLE_BUTTON);
    }

    public void addRowToTable() {
        utils.switchToIframe(NOTE_EDITOR_IFRAME);
        utils.hoveringMouse(ADD_ROW_BUTTON);
        utils.waitForElement(ADD_ROW_BUTTON);
        utils.click(ADD_ROW_BUTTON);
        utils.switchToDefaultContent();
    }

    public void addColumnToTable() {
        utils.switchToIframe(NOTE_EDITOR_IFRAME);
        utils.hoveringMouse(ADD_COLUMN_BUTTON);
        utils.waitForElement(ADD_COLUMN_BUTTON);
        utils.click(ADD_COLUMN_BUTTON);
        utils.switchToDefaultContent();
    }
}
