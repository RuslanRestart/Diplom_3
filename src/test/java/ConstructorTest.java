import io.qameta.allure.Description;
import org.example.PageObjects.BasePage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @Description("Переход из Личного кабинета в \"Конструктор\"")
    public void goToConstructorFromProfileAccTest() {
        BasePage basePage = new BasePage(driver);
        basePage.clickPersonAccButton();
        createUserFromApi();
        doAuthorization();
        basePage.clickPersonAccButton();
        basePage.clickConstructorButton();
        assertTrue(basePage.isCreateOrderButtonDisplayed());
    }

    @Test
    @Description("Переход к разделу \"Булки\"")
    public void goToBunTabTest() {
        assertTrue(new BasePage(driver).isBunTabSelected());
    }

    @Test
    @Description("Переход к разделу \"Соусы\"")
    public void goToSauceTabTest() {
        assertTrue(new BasePage(driver).isSauceTabSelected());
    }

    @Test
    @Description("Переход к разделу \"Начинки\"")
    public void goToFillingTabTest() {
        assertTrue(new BasePage(driver).isFillingTabSelected());
    }
}
