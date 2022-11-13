package hellocucumber.meg.listshop.uitests.pages.dashboard;

import hellocucumber.meg.listshop.uitests.framework.WithNavbarBasePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.OnboardingBasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends WithNavbarBasePage  {
    @FindBy(name="Sign Up")
    private MobileElement gotoSignupButton;
    @FindBy(name="Logout")
    private MobileElement logoutButton;

    public void goToLandingPage() {
        tapOn(gotoSignupButton);
    }


    public void clickOnLogoutButton() {
        tapOn(logoutButton);
    }

    public void logout() throws InterruptedException {
        goToDashboard();
        clickOnLogoutButton();
        Thread.sleep(500);
    }
}
