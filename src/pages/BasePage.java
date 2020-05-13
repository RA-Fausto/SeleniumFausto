package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    // Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    // Click Method
    public void click (WebElement element){
        element.click();
    }

    public void writeText(WebElement element, String text){
        element.sendKeys(text);
    }

    public String readText (WebElement element){
        return element.getText();
    }

    public void assertequals (WebElement element, String expectedText){
        assertEquals(expectedText, readText(element) );
    }
}
