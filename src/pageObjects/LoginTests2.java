package pageObjects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTests2
{
    public String baseURL = "http://localhost:8080";
    public FirefoxDriver driver;

    @BeforeEach
    public void beforeEach(){
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver/geckodriver.exe");
        this.driver = new FirefoxDriver();
        this.driver.get(baseURL);
    }

    @Test
    public void loginTests2_testLoginSucceed_void() throws InterruptedException
    {
        // Happy Path test - login succeeds
        // Perform Actions with locators
        LoginPage.userName(this.driver).sendKeys("registeredUser");
        LoginPage.password(this.driver).sendKeys("1234");
        LoginPage.submit(driver).click();
        Thread.sleep(5000);
        String message = LoginPage.message(driver).getText();
        String expectedMessage = "Welcome back,\n" + "registeredUser";
        assertEquals(message, expectedMessage);
        this.driver.quit();
    }

    @Test
    public void loginTest2_testLoginFail_void() throws InterruptedException {
        // Sad Path Test - login fails
        // Locate web elements
        LoginPage.userName(this.driver).sendKeys("otherUser");
        LoginPage.password(this.driver).sendKeys(" qwerty1234");
        LoginPage.submit(driver).click();
        Thread.sleep(5000);
        String message = LoginPage.message(driver).getText();
        System.out.println(message);
        String expectedMessage = "Account not found. Please sign up by clicking the link below";
        assertEquals(expectedMessage, message);

        // Create acct
        LoginPage.createAcctLink(driver).click();
        Thread.sleep(5000);
        String header = CreateAcctPage.header(driver).getText();
        System.out.println(header);
        String expectedHeader = "Create an Account";
        assertEquals(expectedHeader, header);
        this.driver.quit();
    }
}
