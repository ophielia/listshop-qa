package hellocucumber.meg.listshop.uitests.stepsDefinitions.onboarding;

import hellocucumber.meg.listshop.uitests.framework.AppiumWrapper;
import hellocucumber.meg.listshop.uitests.framework.PageProvider;
import hellocucumber.meg.listshop.uitests.framework.PageType;
import hellocucumber.meg.listshop.uitests.pages.onboarding.ChoicePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

    @Given("User navigates to sign in page")
    public void userNavigatesToSignInPage() throws InterruptedException {
        ((ChoicePage) PageProvider.getPage(PageType.Choice)).clickOnSignInButton();
    }

    @When("User enters username {string}")
    public void userEntersUsername(String username) {
        PageProvider.getSignInPage().enterUsername(username);
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        PageProvider.getSignInPage().enterPassword(password);
    }

    @And("User clicks on the submit button")
    public void userClicksOnTheSubmitButton() {
        PageProvider.getSignInPage().clickOnSubmit();
    }

    @And("User sees error message")
    public void userSeesErrorMessage() {
        PageProvider.getSignInPage().errorsDisplayed();
    }

    @And("User reopens app")
    public void userReopensApp() {
        AppiumWrapper.reopenApp();
    }

    @And("User resets app")
    public void userResetsApp() {
        AppiumWrapper.resetApp();
    }



}
