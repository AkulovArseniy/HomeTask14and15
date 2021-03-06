package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Driver;
import utils.Log;

import java.time.Duration;

import static locators.MainPageLocators.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest {
    protected WebDriver driver = Driver.getChromeDriver();


    @Test
    public void setUp(){
        Log.info("Открываем adress book");
        driver.get("http://a.testaddressbook.com/sign_in");
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/sign_in",currentURL,"Открыта неправльная страница");
        Log.info("Log in");
        driver.findElement(EMAIL_FIELD).sendKeys(EMAIL);
        driver.findElement(PASSWORD_FIELD).sendKeys(PASSWORD);
        driver.findElement(LOGIN).click();
    }
    @AfterEach
    public void afterEachTestMethod(){
        Log.info("Некоторый код выполяется после каждого метода");
    }

    @AfterAll
    public void tearDown() {

        Log.info("Закрываем браузер");
        driver.quit();

    }
}
