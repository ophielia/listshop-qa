package hellocucumber.meg.listshop.uitests.stepsDefinitions.onboarding;

import hellocucumber.meg.listshop.uitests.framework.AppiumWrapper;
import hellocucumber.meg.listshop.uitests.pages.dashboard.AccountPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.ChoicePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
    ChoicePage homePage = new ChoicePage();
    SignInPage signInPage = new SignInPage();
    AccountPage navbarAccountPage = new AccountPage();

    @Given("User navigates to sign in page")
    public void userNavigatesToSignInPage() throws InterruptedException {
        homePage.clickOnSignInButton();
    }

    @When("User enters username {string}")
    public void userEntersUsername(String username) {
        signInPage.enterUsername(username);
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        signInPage.enterPassword(password);
    }

    @And("User clicks on the submit button")
    public void userClicksOnTheSubmitButton() {
        signInPage.clickOnSubmit();
    }

    @And("User sees error message")
    public void userSeesErrorMessage() {

    }

    @And("User reopens app")
    public void userReopensApp() {
        AppiumWrapper.reopenApp();

       //getAppiumDriver().launchApp();
    }
}
