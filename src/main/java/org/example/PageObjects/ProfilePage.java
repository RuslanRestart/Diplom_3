package org.example.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage {

    protected By profileButton = By.cssSelector("a.Account_link__2ETsJ.text.text_type_main-medium.text_color_inactive.Account_link_active__2opc9");
    protected By logoutButton = By.cssSelector("button.Account_button__14Yp3.text.text_type_main-medium.text_color_inactive");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isProfileButtonDisplayed(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        return driver.findElement(profileButton).isDisplayed();
    }

    public void clickLogoutButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
    }
}
