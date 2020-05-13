import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RandomWikiTest
{
    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();

        // visit wikipedia homepage
        driver.get("https://en.wikipedia.org");

        // find random article link
        driver.findElement(By.cssSelector("#n-randompage")).click();
        Thread.sleep(5000);

        // print random page title
        //System.out.println(driver.getTitle());

        //print first heading
        String firstHeading = driver.findElement(By.cssSelector(".firstHeading")).getText();
        System.out.println("First Heading: " + firstHeading);

        //View Page info
        driver.findElement(By.linkText("Page information")).click();
        Thread.sleep(5000);

        // New Search
        driver.findElement(By.name("search")).sendKeys("Selenium (software)" + Keys.RETURN);
        Thread.sleep(5000);

        // Xpath logo Click
        String xpath = "/html/body/div[5]/div[2]/div[1]/a";
        driver.findElement(By.xpath(xpath));
        driver.quit();


    }
}