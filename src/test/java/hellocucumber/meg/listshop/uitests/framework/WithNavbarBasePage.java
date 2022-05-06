package hellocucumber.meg.listshop.uitests.framework;

import hellocucumber.meg.listshop.uitests.pages.onboarding.OnboardingBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

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
        return checkElementDisplayed(gotoListScreenButton, 2);
    }

    public void goToDashboard() {
        tapOn(gotoDashboardScreenButton);
    }

    public void goToListManagement() {
        tapOn(gotoListManagementScreenButton);
    }


}
