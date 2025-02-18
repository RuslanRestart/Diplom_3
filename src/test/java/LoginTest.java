import org.example.PageObjects.BasePage;
import org.example.PageObjects.ForgotPasswordPage;
import org.example.PageObjects.LoginPage;
import org.example.PageObjects.RegisterPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void loginByLoginButtonTest(){
        BasePage basePage = new BasePage(driver);
        basePage.clickLoginButton();
        UserUtil userUtil = new UserUtil();
        userUtil.createUserFromApi();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginPage(userUtil.getEmail(), userUtil.getPassword());
        basePage.waitForCreateOrderButtonIsDisplayed();
        assertTrue(loginPage.isCreateOrderButtonDisplayed());
    }

    //TODO подумаь над единичным использование тестового юзера и надо это ли?
    @Test
    public void loginByPersonAccButtonTest(){
        BasePage basePage = new BasePage(driver);
        basePage.clickPersonAccButton();
        UserUtil userUtil = new UserUtil();
        userUtil.createUserFromApi();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginPage(userUtil.getEmail(), userUtil.getPassword());
        basePage.waitForCreateOrderButtonIsDisplayed();
        assertTrue(loginPage.isCreateOrderButtonDisplayed());
    }

    @Test
    public void loginByLoginButtonOnRegisterPageTest(){
        BasePage basePage = new BasePage(driver);
        basePage.clickPersonAccButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();
        new RegisterPage(driver).clickLoginButton();
        UserUtil userUtil = new UserUtil();
        userUtil.createUserFromApi();
        loginPage.fillLoginPage(userUtil.getEmail(), userUtil.getPassword());
        basePage.waitForCreateOrderButtonIsDisplayed();
        assertTrue(loginPage.isCreateOrderButtonDisplayed());
    }

    @Test
    public void loginByForgotPasswordButtonTest(){
        BasePage basePage = new BasePage(driver);
        basePage.clickPersonAccButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPassword();
        new ForgotPasswordPage(driver).clickLoginButton();
        UserUtil userUtil = new UserUtil();
        userUtil.createUserFromApi();
        loginPage.fillLoginPage(userUtil.getEmail(), userUtil.getPassword());
        basePage.waitForCreateOrderButtonIsDisplayed();
        assertTrue(loginPage.isCreateOrderButtonDisplayed());
    }
}
