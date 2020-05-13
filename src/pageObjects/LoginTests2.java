package pageObjects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AuthPage;

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
        AuthPage authPage = new AuthPage(driver);
        String expectedMessage = "Welcome back,\n" + "registeredUser";
        authPage.authenticate("registeredUser", "1234")
                .verifyLogin(expectedMessage);
        Thread.sleep(5000);
        this.driver.quit();
    }

    @Test
    public void loginTest2_testLoginFail_void() throws InterruptedException {
        // Sad Path Test - login fails
        AuthPage authPage = new AuthPage(driver);

        String expectedMessage = "Account not found. Please sign up by clicking the link below";
        String expectedHeader = "Create an Account";
        authPage.authenticate("otherUser", "qwerty1234")
                .verifyLogin(expectedMessage)
                .clickCreateAccount()
                .verifySignupPage(expectedHeader);
        this.driver.quit();
    }
}
