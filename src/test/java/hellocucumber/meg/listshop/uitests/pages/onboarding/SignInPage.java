package hellocucumber.meg.listshop.uitests.pages.onboarding;

import hellocucumber.meg.listshop.uitests.framework.MobileBasePage;
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

}
