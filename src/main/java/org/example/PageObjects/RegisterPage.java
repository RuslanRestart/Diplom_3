package org.example.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    protected By namePlaceholder = By.xpath(".//label[@class='input__placeholder text noselect text_type_main-default' and text()='Имя']");
    protected By nameInput = By.xpath(".//input[@class='text input__textfield text_type_main-default']");
    protected By emailPlaceholder = By.xpath(".//label[@class='input__placeholder text noselect text_type_main-default' and text()='Email']");
    protected By emailInput = By.xpath("(.//input[@class='text input__textfield text_type_main-default'])[2]");
    protected By passwordPlaceholder = By.xpath(".//label[@class='input__placeholder text noselect text_type_main-default' and text()='Пароль']");
    protected By passwordInput = By.cssSelector("input.text.input__textfield.text_type_main-default[name='Пароль']");
    protected By registerButton = By.cssSelector("button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");
    protected By incorrectPasswordError = By.cssSelector("p.input__error.text_type_main-default");
    protected By loginButton = By.cssSelector("a.Auth_link__1fOlj");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void setName(String name) {
        driver.findElement(namePlaceholder).click();
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(emailPlaceholder).click();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordPlaceholder).click();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void fillRegisterPage(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public boolean incorrectPasswordErrorIsDisplayed(){
        return driver.findElement(incorrectPasswordError).isDisplayed();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
