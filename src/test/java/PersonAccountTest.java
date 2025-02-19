import io.qameta.allure.Description;
import org.example.PageObjects.BasePage;
import org.example.PageObjects.LoginPage;
import org.example.PageObjects.ProfilePage;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonAccountTest extends BaseTest{

    @Test
    @Description("Переход в личный кабинет по кнопке \"Личный кабинет\"")
    public void goToPersonAccTest(){
        createUserFromApi();
        BasePage basePage = new BasePage(driver);
        basePage.clickPersonAccButton();
        doAuthorization();
        basePage.clickPersonAccButton();
        assertTrue(new ProfilePage(driver).isProfileButtonDisplayed());
    }

    @Test
    @Description("Выход из аккаунта по кнопке \"Выйти\" в личном кабинете")
    public void logoutTest(){
        createUserFromApi();
        BasePage basePage = new BasePage(driver);
        basePage.clickPersonAccButton();
        doAuthorization();
        basePage.clickPersonAccButton();
        new ProfilePage(driver).clickLogoutButton();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe(LoginPage.LOGIN_PAGE_URL));
        assertEquals("Страница авторизации не открылась! Проверь url!", LoginPage.LOGIN_PAGE_URL, driver.getCurrentUrl());
    }
}
