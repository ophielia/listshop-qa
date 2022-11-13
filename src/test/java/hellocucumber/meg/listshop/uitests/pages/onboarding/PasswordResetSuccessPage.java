package hellocucumber.meg.listshop.uitests.pages.onboarding;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class PasswordResetSuccessPage extends OnboardingBasePage {


    @FindBy(name = "Login")
    private MobileElement loginButton;

    public boolean verifyTitleDisplayed() {
        return isElementDisplayed(passwordResetTitle);
    }


    public void clickOnGotoLogin() {
        tapOn(loginButton);
    }
}
