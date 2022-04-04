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

    public boolean verifyTitleDisplayed(){
        return isElementDisplayed(signUpTitle);
    }

    public void clickOnSignUpButton() throws InterruptedException {
        tapOn(signUpButton);
        Thread.sleep(1000);
    }

}
