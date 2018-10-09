import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Tests103 {
    private WebDriver driver;

    @BeforeMethod
    public void start(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        driver.get("https://www.103.by/");
    }

    @AfterMethod
    public void finish(){
        driver.quit();
    }

    @Test
    public void canReachSite_hardAsserts(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.103.by/",
                "URL is correct");

        Assert.assertTrue(driver.getTitle().contains("103.by"), "Header contains 103.by");
        driver.getCurrentUrl();
    }

    @Test
    public void canReachSite_softAssert(){
        SoftAssert softAssertion= new SoftAssert();

        softAssertion.assertEquals(driver.getCurrentUrl(), "ttps://www.103.by/",
                "URL is correct");

        softAssertion.assertTrue(driver.getTitle().contains("203.by"),
                "Header contains 103.by");

        softAssertion.assertAll();
    }

    @Test
    public void canFindDrug(){
        driver.findElement(By.className("SearchContainer"))
                .findElement(By.tagName("div")).click();

        int d = 0;
    }
}
