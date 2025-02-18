package org.example.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    protected WebDriver driver;

    //header locators
    protected By personAccButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    protected By constructorButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");

    protected By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    protected By createOrderButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    protected By sauceTab = By.xpath("//span[@class='text text_type_main-default' and text()='Соусы']");
    protected By fillingTab = By.xpath("//span[@class='text text_type_main-default' and text()='Начинки']");

    protected By bunHeader = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10'  and text()='Булки']");
    protected By sauceHeader = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10'  and text()='Соусы']");
    protected By fillingHeader = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10'  and text()='Начинки']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPersonAccButton(){
        WebElement profileButtonElement = driver.findElement(personAccButton);
        if (profileButtonElement.isEnabled()){
            profileButtonElement.click();
        }
    }

    public void clickLoginButton(){
        WebElement loginButtonElement = driver.findElement(loginButton);
        if (loginButtonElement.isDisplayed()){
            loginButtonElement.click();
        }
    }

    public void clickConstructorButton(){
        WebElement constructorButtonElement = driver.findElement(constructorButton);
        if (constructorButtonElement.isDisplayed()){
            constructorButtonElement.click();
        }
    }

    public void clickSauceTab(){
        WebElement sauceTabTabElement = driver.findElement(sauceTab);
        if (sauceTabTabElement.isDisplayed()){
            sauceTabTabElement.click();
        }
    }

    public void clickFillingTab(){
        WebElement fillingTabElement = driver.findElement(fillingTab);
        if (fillingTabElement.isDisplayed()){
            fillingTabElement.click();
        }
    }

    public boolean isCreateOrderButtonDisplayed(){
        return driver.findElement(createOrderButton).isDisplayed();
    }

    public void waitForCreateOrderButtonIsDisplayed(){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
    }

    public boolean isBunHeaderDisplayed(){
        return driver.findElement(bunHeader).isDisplayed();
    }

    public boolean isSauceHeaderDisplayed(){
        return driver.findElement(sauceHeader).isDisplayed();
    }

    public boolean isFillingHeaderDisplayed(){
        return driver.findElement(fillingHeader).isDisplayed();
    }




}
