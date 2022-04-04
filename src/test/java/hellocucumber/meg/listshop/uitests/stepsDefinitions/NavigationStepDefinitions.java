package hellocucumber.meg.listshop.uitests.stepsDefinitions;

import hellocucumber.meg.listshop.uitests.framework.WithNavbarBasePage;
import hellocucumber.meg.listshop.uitests.pages.dashboard.AccountPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.ChoicePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.OnboardingBasePage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;

// Possibly useful later when more navigation will be necessary.  For now, not used.

public class NavigationStepDefinitions {

    OnboardingBasePage landingPage = new OnboardingBasePage();
    WithNavbarBasePage anyNavbarPage = new WithNavbarBasePage();

  //  @Given("user is on choice page")
    public void userIsOnChoicePage() throws InterruptedException {
        boolean onLandingPage = landingPage.currentlyOnOnboardingPage();
        if (onLandingPage &&
        landingPage.currentlyOnChoicePage()) {
            System.out.println("userIsOnChoicePage: on landing choice page, returning");
            return;
        }
        if (onLandingPage) {
            System.out.println("userIsOnChoicePage: on other onboarding page, moving to choice page");
            landingPage.goToChoicePage();
            return;
        }
        // possibly on a navbar page
        if (anyNavbarPage.currentlyOnNavbarPage()) {
            System.out.println("userIsOnChoicePage: on navbar page, moving to choice page");
            anyNavbarPage.goToDashboard();
            AccountPage accountPage = new AccountPage();
            accountPage.goToLandingPage();
            landingPage.goToChoicePage();
        }


        Assertions.assertTrue(landingPage.verifyTitleDisplayed());
    }

}
