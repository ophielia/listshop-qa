package hellocucumber.meg.listshop.uitests.pages.dashboard;

import hellocucumber.meg.listshop.uitests.framework.WithNavbarBasePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.OnboardingBasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends WithNavbarBasePage  {


    @FindBy(name="Sign Up")
    private MobileElement gotoSignupButton;


    public void goToLandingPage() {
        tapOn(gotoSignupButton);
    }


}
