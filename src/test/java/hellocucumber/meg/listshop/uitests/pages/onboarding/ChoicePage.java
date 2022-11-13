package hellocucumber.meg.listshop.uitests.pages.onboarding;

import hellocucumber.meg.listshop.uitests.framework.MobileBasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ChoicePage extends OnboardingBasePage {

    @FindBy(name="signin")
    private MobileElement goToSignInButton;
    @FindBy(name = "signup")
    private MobileElement goToSignUpButton;
    @FindBy(name = "Skip for now")
    private MobileElement skipLoginButton;


    public boolean verifyTitleDisplayed() {
        return isElementDisplayed(choosePageTitle);
    }

    public boolean currentlyOnPage() {
        return checkElementDisplayed(goToSignInButton, 2);
    }

    public void clickOnSignInButton() throws InterruptedException {
        tapOn(goToSignInButton);
        Thread.sleep(1000);
    }

    public void clickOnSignUpButton() throws InterruptedException {
        tapOn(goToSignUpButton);
        Thread.sleep(1000);
    }
    public void clickOnSkipButton() throws InterruptedException {
        tapOn(skipLoginButton);
        Thread.sleep(1000);
    }

    public boolean verifySkipButtonIsVisible() {
        return isElementDisplayed(skipLoginButton);
    }

    public boolean verifySignInButtonIsVisible() {
        return isElementDisplayed(goToSignInButton);
    }

    public boolean verifySignUpButtonIsVisible() {
        return isElementDisplayed(goToSignUpButton);
    }
}
/*
public class LandingPage extends MobileBasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='SKIP ']")
    // (xpath = "//android.webkit.WebView/android.widget.TabWidget/)
    //(accessibility = "close share")
    //(className = "android.widget.EditText")
    //(id="android:id/statusBarBackground")
    @iOSFindBy(accessibility = "yesButton")
    private MobileElement yesButton;
 */