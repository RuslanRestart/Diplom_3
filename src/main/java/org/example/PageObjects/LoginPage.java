package org.example.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final String LOGIN_PAGE_URL = BASE_URL + "login";

    protected By registerButton = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']");
    protected By forgotPasswordButton = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Восстановить пароль']");
    protected By emailPlaceholder = By.xpath(".//label[@class='input__placeholder text noselect text_type_main-default' and text()='Email']");
    protected By emailInput = By.xpath("(.//input[@class='text input__textfield text_type_main-default'])[1]");
    protected By passwordPlaceholder = By.xpath(".//label[@class='input__placeholder text noselect text_type_main-default' and text()='Пароль']");
    protected By passwordInput = By.xpath("(.//input[@class='text input__textfield text_type_main-default'])[2]");
    protected By loginButton = By.cssSelector("button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

    public void setEmail(String email) {
        driver.findElement(emailPlaceholder).click();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordPlaceholder).click();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void fillLoginPageAndSubmit(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButtonOnLoginPage();
    }

    public void clickLoginButtonOnLoginPage(){
        driver.findElement(loginButton).click();
    }

    public void clickForgotPassword(){
        driver.findElement(forgotPasswordButton).click();
    }
}
