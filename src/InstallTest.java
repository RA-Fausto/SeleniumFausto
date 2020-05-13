import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InstallTest
{
    public static void main (String [] args) throws InterruptedException{
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://google.com");

        //locate the search box element
        WebElement searchBox = driver.findElement(By.name("q"));
        Thread.sleep(5000);

        //type in our search query into search box
        searchBox.sendKeys("selenium" + Keys.RETURN);

        Thread.sleep(10000);
        System.out.println("Title: " +driver.getTitle());
        driver.quit();

    }
}
