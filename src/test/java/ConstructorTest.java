import org.example.PageObjects.BasePage;
import org.example.PageObjects.LoginPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    public void goToConstructorFromProfileAccTest() {
        BasePage basePage = new BasePage(driver);
        basePage.clickPersonAccButton();
        UserUtil userUtil = new UserUtil();
        userUtil.createUserFromApi();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginPage(userUtil.getEmail(), userUtil.getPassword());
        basePage.clickPersonAccButton();
        basePage.clickConstructorButton();
        assertTrue(loginPage.isCreateOrderButtonDisplayed());
    }

    @Test
    public void goToBunTabTest() {
        assertTrue(new BasePage(driver).isBunHeaderDisplayed());
    }

    @Test
    public void goToSauceTabTest() {
        BasePage basePage = new BasePage(driver);
        basePage.clickSauceTab();
        assertTrue(basePage.isSauceHeaderDisplayed());
    }

    //TODO при проверке надо смотреть, выделилась ли нажатая вкладка
    @Test
    public void goToFillingTabTest() {
        BasePage basePage = new BasePage(driver);
        basePage.clickFillingTab();
        assertTrue(basePage.isFillingHeaderDisplayed());
    }
}
