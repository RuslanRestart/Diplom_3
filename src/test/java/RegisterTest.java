import org.example.PageObjects.BasePage;
import org.example.PageObjects.LoginPage;
import org.example.PageObjects.RegisterPage;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {

    @Test
    public void registerTest(){
        BasePage page = new BasePage(driver);
        page.clickPersonAccButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillRegisterPage("stellarBurgerLover", UserUtil.generateEmail(), "testPass");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe(LoginPage.LOGIN_PAGE_URL));
        assertEquals("Страница авторизации не открылась! Проверь url!", LoginPage.LOGIN_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    public void cannotRegisterWithPasswordLessThanSixCharsTest(){
        BasePage page = new BasePage(driver);
        page.clickPersonAccButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillRegisterPage("stellarBurgerLover", "stellarUser" + new Random().nextInt(10000000) + "@ya.ru", "5char");
        assertTrue(registerPage.incorrectPasswordErrorIsDisplayed());
    }

}
