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
        return checkElementDisplayed(choosePageTitle) ||
                checkElementDisplayed(signUpTitle) ||
                checkElementDisplayed(signInTitle);
    }

    public boolean currentlyOnChoicePage() {
        // if on choice page return true
        return checkElementDisplayed(choosePageTitle);
    }

    public  void goToChoicePage() throws InterruptedException {
        // if on sign in or sign up page click on back button
        if (checkElementDisplayed(signInTitle) ||
                checkElementDisplayed(signUpTitle)) {
            clickOnBackButton();
            return;
        }
        // if on forgot password page, click on back button, and then click on back button

    }
   /*


    public static void goToChoicePage(OnboardingBasePage page, WithNavbarBasePage navbarBasePage) throws InterruptedException {
        // if on sign in or sign up page click on back button
        if (page.checkElementDisplayed(page.signInTitle) ||
                page.checkElementDisplayed(page.signUpTitle)) {
            page.clickOnBackButton();
            return;
        }
        // if on forgot password page, click on back button, and then click on back button

        // if on a navbar page
        if (navbarBasePage.isOnPageWithNavbar()) {
            // go to onboarding
            WithNavbarBasePage.goToDashboardRoot(navbarBasePage);

        }
    }

    public static boolean currentlyOnChoicePage(OnboardingBasePage page) {
        return page.checkElementDisplayed(page.choosePageTitle);
    }

    */
}
