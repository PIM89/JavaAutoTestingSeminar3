package org.example.pom;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class LoginPage {
    @FindBy(css = "form#login input[type='text']")
    private SelenideElement usernameField;
    @FindBy(css = "form#login input[type='password']")
    private SelenideElement passwordField;
    @FindBy(css = "form#login button")
    private SelenideElement loginButton;
    @FindBy(css = "div.error-block")
    private SelenideElement errorBlock;

    public void login(String username, String password) {
        typeUsernameInField(username);
        typePasswordInField(password);
        clickLoginButton();
    }

    public void typeUsernameInField(String username) {
        usernameField.shouldBe(visible).sendKeys(username);
    }

    public void typePasswordInField(String password) {
        passwordField.shouldBe(visible).sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.shouldBe(visible).click();
    }

    public String getErrorBlockText() {
        return errorBlock.shouldBe(visible).text().replace("\n", " ");
    }
}
