package Utils;

import com.sun.deploy.net.proxy.WFirefoxProxyConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public WebDriver driver;

    @Before
    public void setUp() {
    WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.currys.co.uk/gbuk/index.html");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


