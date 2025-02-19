import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.PageObjects.BasePage;
import org.example.PageObjects.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected WebDriver driver;
    protected User user;
    private StellarBurgerApi stellarBurgerApi;

    @Before
    @Description("Конфигурация WebDriver перед запуском тестов")
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

    @Step("Создаем юзера и устанавливаем ему токен")
    public void createUserFromApi(){
        user = new User(UserUtil.generateEmail(), "testPassword", "stellarBurgerLover");
        stellarBurgerApi = new StellarBurgerApi();
        Response createUserResponse = stellarBurgerApi.createUserFromApi(user);
        UserUtil.setTokenToUser(createUserResponse, user);
    }

    @Step("Авторизация в системе")
    public void doAuthorization(){
        new LoginPage(driver).fillLoginPageAndSubmit(user.getEmail(), user.getPassword());
    }

    @After
    @Description("Выключение драйвера и удаление тестового пользователя")
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }

        if (user != null){
            stellarBurgerApi.deleteUserFromApi(user.getBearerToken()).then().statusCode(202);
        }
    }
}
