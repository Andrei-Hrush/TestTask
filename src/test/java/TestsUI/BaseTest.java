package TestsUI;

import configs.Configs;
import driver.DriverHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.MainPage;

import java.io.IOException;

public class BaseTest {
    protected static JavascriptExecutor js;
    protected WebDriver driver;
    protected LoginPage loginPage = new LoginPage();
    protected MainPage mainPage = new MainPage();
    protected Configs configs = new Configs();

    @BeforeMethod
    public void before() throws IOException {
        driver = DriverHelper.getInstance();
        driver.manage().window().maximize();
        driver.get(configs.getProperty("url"));

    }

    @AfterMethod
    public static void closeWindow(){
        DriverHelper.close();
    }
}
