package org.example.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    protected WebDriver driver;

    protected By personAccButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    protected By constructorButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");

    protected By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Войти в аккаунт']");
    protected By createOrderButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Оформить заказ']");

    protected By selectedIngredientTab = By.cssSelector("div.tab_tab__1SPyG.tab_tab_type_current__2BEPc.pt-4.pr-10.pb-4.pl-10.noselect");
    protected By sauceTab = By.xpath("//span[@class='text text_type_main-default' and text()='Соусы']");
    protected By fillingTab = By.xpath("//span[@class='text text_type_main-default' and text()='Начинки']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPersonAccButton(){
        driver.findElement(personAccButton).click();
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }

    public boolean isCreateOrderButtonDisplayed(){
        return driver.findElement(createOrderButton).isDisplayed();
    }

    public void waitForCreateOrderButtonIsDisplayed(){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
    }

    public boolean isBunTabSelected(){
        return driver.findElement(selectedIngredientTab).isDisplayed();
    }

    public boolean isSauceTabSelected(){
        driver.findElement(sauceTab).click();
        return driver.findElement(selectedIngredientTab).isDisplayed();
    }

    public boolean isFillingTabSelected(){
        driver.findElement(fillingTab).click();
        return driver.findElement(selectedIngredientTab).isDisplayed();
    }
}
