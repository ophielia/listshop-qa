package hellocucumber.meg.listshop.uitests.stepsDefinitions;

import hellocucumber.meg.listshop.uitests.framework.PageProvider;
import hellocucumber.meg.listshop.uitests.framework.PageType;
import hellocucumber.meg.listshop.uitests.framework.WithNavbarBasePage;
import hellocucumber.meg.listshop.uitests.pages.dashboard.AccountPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.ChoicePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.OnboardingBasePage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;

// Possibly useful later when more navigation will be necessary.  For now, not used.

public class NavigationStepDefinitions {

    @Given("User navigates to list management page")
    public void userNavigatesToListManagementPage() {
        WithNavbarBasePage anyNavbar = (WithNavbarBasePage) PageProvider.getPage(PageType.AnyNavbar);
        anyNavbar.goToListManagement();
    }


}
