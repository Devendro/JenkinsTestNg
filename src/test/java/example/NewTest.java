package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
    private ChromeDriver driver;

    @Test
    public void testYouTubeTitle() {
        driver.get("https://www.youtube.com/");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("YouTube"));
    }

    @BeforeTest
    public void beforeTest() {
        String chromeDriverPath = "src/Driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        
        // Initialize ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
