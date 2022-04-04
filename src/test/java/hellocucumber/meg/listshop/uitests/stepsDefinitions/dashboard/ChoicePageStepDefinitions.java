package hellocucumber.meg.listshop.uitests.stepsDefinitions.dashboard;

import hellocucumber.meg.listshop.uitests.framework.AppiumWrapper;
import hellocucumber.meg.listshop.uitests.framework.WithNavbarBasePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.ChoicePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.OnboardingBasePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignInPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignUpPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ChoicePageStepDefinitions {

    ChoicePage homePage = new ChoicePage();
    SignUpPage signUpPage = new SignUpPage();
    SignInPage signInPage = new SignInPage();
    WithNavbarBasePage anyNavbarPage = new WithNavbarBasePage();



    @When("User clicks on the signup button")
    public void userClicksOnTheSignupButton() throws InterruptedException {
        homePage.clickOnSignUpButton();
    }

    @When("User clicks on the signin button")
    public void userClicksOnTheSigninButton() throws InterruptedException {
        homePage.clickOnSignInButton();
    }

    @When("User clicks on the skip login button")
    public void userClicksOnTheSkipLoginButton() throws InterruptedException {
        homePage.clickOnSkipButton();
    }

    @Then("I should be see the skip button")
    public void iShouldBeSeeTheSkipButton() {
        Assertions.assertTrue(homePage.verifySkipButtonIsVisible());
    }
    @Then("I should see the signin button")
    public void iShouldSeeTheSigninButton() {
        Assertions.assertTrue(homePage.verifySignInButtonIsVisible());
    }
    @Then("I should see the signup button")
    public void iShouldSeeTheSignupButton() {
        Assertions.assertTrue(homePage.verifySignUpButtonIsVisible());
    }
    @Then("User sees the signup page")
    public void userSeesTheSignupPage() {
        Assertions.assertTrue(signUpPage.verifyTitleDisplayed());
    }

    @Then("User sees the signin page")
    public void userSeesTheSigninPage() {
        Assertions.assertTrue(signInPage.verifyTitleDisplayed());
    }

    @Then("User sees the list screen page")
    public void userSeesTheListScreenPage() {
        Assertions.assertTrue(anyNavbarPage.isOnPageWithNavbar());
    }
}
