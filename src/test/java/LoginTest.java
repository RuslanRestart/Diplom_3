import io.qameta.allure.Description;
import org.example.PageObjects.BasePage;
import org.example.PageObjects.ForgotPasswordPage;
import org.example.PageObjects.LoginPage;
import org.example.PageObjects.RegisterPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @Description("Вход по кнопке \"Войти в аккаунт\" на главной странице")
    public void loginByLoginButtonTest() {
        BasePage basePage = new BasePage(driver);
        basePage.clickLoginButton();
        createUserFromApi();
        doAuthorization();
        basePage.waitForCreateOrderButtonIsDisplayed();
        assertTrue(basePage.isCreateOrderButtonDisplayed());
    }

    @Test
    @Description("Вход по кнопке \"Личный Кабинет\"")
    public void loginByPersonAccButtonTest() {
        BasePage basePage = new BasePage(driver);
        basePage.clickPersonAccButton();
        createUserFromApi();
        doAuthorization();
        basePage.waitForCreateOrderButtonIsDisplayed();
        assertTrue(basePage.isCreateOrderButtonDisplayed());
    }

    @Test
    @Description("Вход по кнопке \"Войти\" со страницы регистрации")
    public void loginByLoginButtonOnRegisterPageTest() {
        BasePage basePage = new BasePage(driver);
        basePage.clickPersonAccButton();
        new LoginPage(driver).clickRegisterButton();
        new RegisterPage(driver).clickLoginButton();
        createUserFromApi();
        doAuthorization();
        basePage.waitForCreateOrderButtonIsDisplayed();
        assertTrue(basePage.isCreateOrderButtonDisplayed());
    }

    @Test
    @Description("Вход по кнопке \"Войти\" со страницы восстановления пароля")
    public void loginByForgotPasswordButtonTest() {
        BasePage basePage = new BasePage(driver);
        basePage.clickPersonAccButton();
        new LoginPage(driver).clickForgotPassword();
        new ForgotPasswordPage(driver).clickLoginButton();
        createUserFromApi();
        doAuthorization();
        basePage.waitForCreateOrderButtonIsDisplayed();
        assertTrue(basePage.isCreateOrderButtonDisplayed());
    }
}
