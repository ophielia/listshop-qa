package hellocucumber.meg.listshop.uitests.pages.onboarding;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends OnboardingBasePage {


    @FindBy(name="email")
    private MobileElement emailEntry;

    public boolean verifyTitleDisplayed(){
        return isElementDisplayed(forgotPasswordTitle);
    }

}
