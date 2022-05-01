package hellocucumber.meg.listshop.uitests.pages.onboarding;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class PasswordResetSuccessPage extends OnboardingBasePage {


    @FindBy(name="Done!")
    private MobileElement titleLabel;



    public boolean verifyTitleDisplayed(){
        return isElementDisplayed(forgotPasswordTitle);
    }


}
