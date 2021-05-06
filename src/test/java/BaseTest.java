import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;



public class BaseTest {
    protected static WebDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeScenario
    public void setUp() throws Exception {
        String baseUrl = "https://www.gittigidiyor.com/";
        ChromeOptions options = new ChromeOptions();
        capabilities = DesiredCapabilities.chrome();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "web_driver/chromedriver1.exe");
        driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @AfterScenario
    public void tearDown() {
        driver.quit();

    }


}
