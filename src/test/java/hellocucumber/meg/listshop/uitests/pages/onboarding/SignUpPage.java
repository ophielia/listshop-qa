package hellocucumber.meg.listshop.uitests.pages.onboarding;

import hellocucumber.meg.listshop.uitests.framework.MobileBasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends OnboardingBasePage {


    @FindBy(name="email")
    private MobileElement emailEntry;
    @FindBy(name="password")
    private MobileElement passwordEntry;
    @FindBy(name="password confirmation")
    private MobileElement passwordConfirmationEntry;
    @FindBy(name="Sign Up")
    private MobileElement signUpButton;

    @FindBy(name="Error Panel")
    private MobileElement errorPanel;

    public boolean verifyTitleDisplayed(){
        return isElementDisplayed(signUpTitle);
    }

    public void clickOnBackButton() throws InterruptedException {
        tapOn(signUpButton);
        Thread.sleep(1000);
    }

    public void enterUsername(String username) {
        tapOn(emailEntry);
        setValue(emailEntry, username, true);
    }

    public void enterPassword(String password) throws InterruptedException {
        tapOn(passwordEntry);
        Thread.sleep(500);
        setValue(passwordEntry, "", true);
        Thread.sleep(500);
        setValue(passwordEntry, password, false);
    }

    public void enterPasswordConfirmation(String password) throws InterruptedException {
        tapOn(passwordConfirmationEntry);
        Thread.sleep(500);
        setValue(passwordConfirmationEntry, "", true);
        Thread.sleep(500);
        setValue(passwordConfirmationEntry, password, false);
    }


    public void clickOnSignUpButton() throws InterruptedException {
        tapOn(signUpButton);
        Thread.sleep(1000);
    }

    public boolean errorsDisplayed() {
        return checkElementDisplayed(errorPanel, 1);
    }

}
