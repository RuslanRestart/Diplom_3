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
    public void goToPersonAccTest(){
        UserUtil userUtil = new UserUtil();
        userUtil.createUserFromApi();
        BasePage basePage = new BasePage(driver);
        basePage.clickPersonAccButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginPage(userUtil.getEmail(), userUtil.getPassword());
        basePage.clickPersonAccButton();
        assertTrue(new ProfilePage(driver).isProfileButtonDisplayed());
    }

    @Test
    public void logoutTest(){
        UserUtil userUtil = new UserUtil();
        userUtil.createUserFromApi();
        BasePage basePage = new BasePage(driver);
        basePage.clickPersonAccButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginPage(userUtil.getEmail(), userUtil.getPassword());
        basePage.clickPersonAccButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoutButton();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe(LoginPage.LOGIN_PAGE_URL));
        assertEquals("Страница авторизации не открылась! Проверь url!", LoginPage.LOGIN_PAGE_URL, driver.getCurrentUrl());
    }


}
