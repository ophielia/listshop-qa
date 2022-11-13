package hellocucumber.meg.listshop.uitests.pages.onboarding;

import hellocucumber.meg.listshop.uitests.framework.MobileBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;

public class OnboardingBasePage extends MobileBasePage {

    @FindBy(name = "TitleSignIn")
    MobileElement signInTitle;
    //@iOSXCUITFindBy(accessibility = "TitleChoosePage")
    @FindBy(name = "TitleChoosePage")
    MobileElement choosePageTitle;
    @FindBy(name = "TitleSignUp")
    MobileElement signUpTitle;
    @FindBy(name = "TitleForgotPassword")
    MobileElement forgotPasswordTitle;

    @FindBy(name = "Done!")
    MobileElement passwordResetTitle;
    @FindBy(name = "@backarrow")
    MobileElement backButton;


    public boolean verifyTitleDisplayed() {
        return isElementDisplayed(signInTitle);
    }

    public void clickOnBackButton() throws InterruptedException {
        tapOn(backButton);
        Thread.sleep(1000);
    }

    public boolean currentlyOnOnboardingPage() {
        // if on choice page return true
        return checkElementDisplayed(choosePageTitle, 2) ||
                checkElementDisplayed(signUpTitle, 2) ||
                checkElementDisplayed(signInTitle, 2);
    }

    public boolean currentlyOnSignUpSignInOrForgot() {
        // if on choice page return true
        return checkElementDisplayed(signUpTitle, 2) ||
                checkElementDisplayed(signInTitle, 2);
    }

    public boolean currentlyOnForgotPasswordSuccessPage() {
        // if on choice page return true
        return checkElementDisplayed(passwordResetTitle, 2);
    }

}
