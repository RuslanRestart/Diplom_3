import org.example.PageObjects.BasePage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp(){
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        ChromeOptions options = new ChromeOptions();

        if (browser.equals("yandex")){
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver-25.2.0.2123-win64\\yandexdriver.exe");
            options.setBinary("C:\\Program Files (x86)\\Yandex\\YandexBrowser\\Application\\browser.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver-win64\\chromedriver.exe");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BasePage.BASE_URL);
    }

    @After
    public void tearDown(){
        //TODO clear comments
        //TODO удалить тестового юзера через апи
        if (driver != null){
            driver.quit();
        }
    }
}
