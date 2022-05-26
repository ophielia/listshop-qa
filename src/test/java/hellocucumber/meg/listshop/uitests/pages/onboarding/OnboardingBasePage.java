package hellocucumber.meg.listshop.uitests.pages.onboarding;

import hellocucumber.meg.listshop.uitests.framework.MobileBasePage;
import hellocucumber.meg.listshop.uitests.framework.WithNavbarBasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class OnboardingBasePage extends MobileBasePage {

    @FindBy(name="TitleSignIn")
    MobileElement signInTitle;
    @FindBy(name="TitleChoosePage")
    MobileElement choosePageTitle;
    @FindBy(name="TitleSignUp")
    MobileElement signUpTitle;
    @FindBy(name="TitleForgotPassword")
    MobileElement forgotPasswordTitle;
    @FindBy(name="@backarrow")
    MobileElement backButton;


    public boolean verifyTitleDisplayed(){
        return isElementDisplayed(signInTitle);
    }

    public void clickOnBackButton() throws InterruptedException {
        tapOn(backButton);
        Thread.sleep(1000);
    }

    public boolean currentlyOnOnboardingPage() {
        // if on choice page return true
        return checkElementDisplayed(choosePageTitle, 2) ||
                checkElementDisplayed(signUpTitle,2) ||
                checkElementDisplayed(signInTitle,2);
    }

}
