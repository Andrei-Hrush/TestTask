package driver;

import configs.Configs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverHelper {
    public static WebDriver driver;
    private static final Configs configs = new Configs();

    public static void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", configs.getProperty("pathToDriver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    public static WebDriver getInstance(){
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver driver() {
        WebDriver driver = DriverHelper.getInstance();
        return driver;
    }

    public static WebDriverWait waitWD() {
        return new WebDriverWait(driver(),20);
    }

    public void switchToIframe(By element) {
        driver().switchTo().frame(driver().findElement(element));
    }

    public void switchToDefaultContent() {
        driver().switchTo().defaultContent();
    }

}
