package hellocucumber.meg.listshop.uitests.framework;

import hellocucumber.meg.listshop.uitests.pages.onboarding.OnboardingBasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class WithNavbarBasePage extends MobileBasePage {

    @FindBy(name="NavBarList")
    MobileElement gotoListScreenButton;
    @FindBy(name="NavBarListManagement")
    MobileElement gotoListManagementScreenButton;
    @FindBy(name="NavBarDish")
    MobileElement gotoDishScreenButton;
    @FindBy(name="NavBarDashboard")
    MobileElement gotoDashboardScreenButton;

    public boolean isOnPageWithNavbar() {
        return checkElementDisplayed(gotoListScreenButton);
    }

    public static void goToDashboardRoot(WithNavbarBasePage page) throws InterruptedException {
        page.tapOn(page.gotoDashboardScreenButton);
    }

    public boolean currentlyOnNavbarPage() {
        return checkElementDisplayed(gotoListScreenButton);
    }

    public void goToDashboard() {
        tapOn(gotoDashboardScreenButton);
    }


}
