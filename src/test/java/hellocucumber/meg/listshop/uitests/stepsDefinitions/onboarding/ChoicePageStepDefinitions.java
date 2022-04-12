package hellocucumber.meg.listshop.uitests.stepsDefinitions.onboarding;

import hellocucumber.meg.listshop.uitests.framework.PageProvider;
import hellocucumber.meg.listshop.uitests.framework.PageType;
import hellocucumber.meg.listshop.uitests.framework.WithNavbarBasePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.ChoicePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignInPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ChoicePageStepDefinitions {

    @Given("User is on choice page")
    public void userIsOnChoicePage() {
        boolean onLandingPage = getLandingPage().currentlyOnOnboardingPage();
        Assertions.assertTrue(onLandingPage);
    }

    @When("User clicks on the signup button")
    public void userClicksOnTheSignupButton() throws InterruptedException {
        getLandingPage().clickOnSignUpButton();
    }

    @When("User clicks on the signin button")
    public void userClicksOnTheSigninButton() throws InterruptedException {
        getLandingPage().clickOnSignInButton();
    }

    @When("User clicks on the skip login button")
    public void userClicksOnTheSkipLoginButton() throws InterruptedException {
        getLandingPage().clickOnSkipButton();
    }

    @Then("User should see the skip button")
    public void userShouldBeSeeTheSkipButton() {
        Assertions.assertTrue(getLandingPage().verifySkipButtonIsVisible());
    }

    @Then("User should see the signin button")
    public void userShouldSeeTheSigninButton() {
        Assertions.assertTrue(getLandingPage().verifySignInButtonIsVisible());
    }

    @Then("User should see the signup button")
    public void userShouldSeeTheSignupButton() {
        Assertions.assertTrue(getLandingPage().verifySignUpButtonIsVisible());
    }

    @Then("User sees the signup page")
    public void userSeesTheSignupPage() {
        Assertions.assertTrue(getSignUpPage().verifyTitleDisplayed());
    }

    @Then("User sees the signin page")
    public void userSeesTheSigninPage() {
        Assertions.assertTrue(getSignInPage().verifyTitleDisplayed());
    }

    @Then("User sees the list screen page")
    public void userSeesTheListScreenPage() {
        Assertions.assertTrue(getAnyNavbarPage().isOnPageWithNavbar());
    }


    private ChoicePage getLandingPage() {
        return (ChoicePage) PageProvider.getPage(PageType.Choice);
    }

    private SignUpPage getSignUpPage() {
        return (SignUpPage) PageProvider.getPage(PageType.SignUp);
    }

    private SignInPage getSignInPage() {
        return (SignInPage) PageProvider.getPage(PageType.SignIn);
    }

    private WithNavbarBasePage getAnyNavbarPage() {
        return (WithNavbarBasePage) PageProvider.getPage(PageType.AnyNavbar);
    }
}
