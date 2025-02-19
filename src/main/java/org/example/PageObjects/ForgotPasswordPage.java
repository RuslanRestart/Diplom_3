package org.example.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {

    protected By loginButton = By.cssSelector("a.Auth_link__1fOlj");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
