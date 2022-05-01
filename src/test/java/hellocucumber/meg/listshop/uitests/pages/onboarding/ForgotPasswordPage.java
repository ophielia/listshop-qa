package hellocucumber.meg.listshop.uitests.pages.onboarding;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends OnboardingBasePage {


    @FindBy(name="email")
    private MobileElement emailEntry;

    @FindBy(name="Request Password Reset")
    private MobileElement submitRequest;

    @FindBy(name="Error Panel")
    private MobileElement errorPanel;

    public boolean verifyTitleDisplayed(){
        return isElementDisplayed(forgotPasswordTitle);
    }

    public void enterUsername(String username) {
        tapOn(emailEntry);
        setValue(emailEntry, username);
    }

    public void clickOnRequestReset() {
        tapOn(submitRequest);
    }

    public boolean errorPanelIsDisplayed() {
        return isElementDisplayed(errorPanel);
    }
}
