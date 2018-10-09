import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new FirefoxDriver();
//        WebDriver driver = new InternetExplorerDriver();
//        WebDriver driver = new EdgeDriver();

        driver.get("https://market.yandex.by");
        driver.findElement(By.id("header-search")).sendKeys("Hello world");
        driver.findElement(By.className("search2__button")).click();
        for (WebElement productTitle:driver.findElements(By.xpath("//div[contains(@class, 'applied-results')]//a[contains(@title, 'Hello, World')]"))) {
            System.out.println(productTitle.getAttribute("title"));
        }

        driver.quit();

    }
}
