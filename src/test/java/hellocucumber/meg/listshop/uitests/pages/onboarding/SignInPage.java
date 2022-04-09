package hellocucumber.meg.listshop.uitests.pages.onboarding;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends OnboardingBasePage {


    @FindBy(name="email")
    private MobileElement emailEntry;
    @FindBy(name="password")
    private MobileElement passwordEntry;

    @FindBy(name="Sign In")
    private MobileElement signInButton;

    public boolean verifyTitleDisplayed(){
        return isElementDisplayed(signInTitle);
    }

    public void clickOnBackButton() throws InterruptedException {
        tapOn(signInButton);
        Thread.sleep(1000);
    }

    public void enterUsername(String username) {
        tapOn(emailEntry);
        setValue(emailEntry, username);
    }

    public void enterPassword(String password) {
        tapOn(passwordEntry);
        setValue(passwordEntry, password);
    }

    public void clickOnSubmit() {
        tapOn(signInButton);
    }
}
