package utils;

import driver.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Utils extends DriverHelper {

    public Utils click(By clickSmth) {
        driver().findElement(clickSmth).click();
        return this;
    }

    public Utils enter(By enterSmth, String  value) {
        driver().findElement(enterSmth).sendKeys(value);
        return this;
    }

    public String getText(By field) {
        return driver().findElement(field).getText();
    }


    public int countOfElements(By list) {
        return driver().findElements(list).size();
    }

    public Utils hoveringMouse(By element) {
        Actions action = new Actions(driver());
        WebElement we = driver().findElement(element);
        action.moveToElement(we).moveToElement(driver().findElement(element)).build().perform();
        return this;
    }

    public void waitForElement(By elementToBePresent) {
        waitWD().until(ExpectedConditions.visibilityOfElementLocated(elementToBePresent));
    }
}
