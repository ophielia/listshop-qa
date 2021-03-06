package hellocucumber.meg.listshop.uitests.stepsDefinitions.onboarding;

import hellocucumber.meg.listshop.uitests.framework.PageProvider;
import hellocucumber.meg.listshop.uitests.framework.PageType;
import hellocucumber.meg.listshop.uitests.pages.onboarding.ChoicePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.ForgotPasswordPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.PasswordResetSuccessPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ForgotPasswordStepDefinitions {

    public ForgotPasswordStepDefinitions() {

    }
    @Given("User navigates to forgot password page")
    public void userNavigatesToForgotPasswordPage() throws InterruptedException {
        ((ChoicePage) PageProvider.getPage(PageType.Choice)).clickOnSignInButton();
        ((SignInPage) PageProvider.getPage(PageType.SignIn)).clickOnForgotPassword();
    }

    @Given("User resets password with username {string}")
    public void userResetsPasswordWithUsername(String userName) {
        ((ForgotPasswordPage) PageProvider.getPage(PageType.ForgotPassword)).enterUsername(userName);
        ((ForgotPasswordPage) PageProvider.getPage(PageType.ForgotPassword)).clickOnRequestReset();
    }

    @Then("User sees password reset success page")
    public void userSeesPasswordResetSuccessPage() {
        ((PasswordResetSuccessPage) PageProvider.getPage(PageType.PasswordResetSuccess)).verifyTitleDisplayed();
    }

    @Then("User remains on forgot password page")
    public void userRemainsOnForgotPasswordPage() {
        ((ForgotPasswordPage) PageProvider.getPage(PageType.ForgotPassword)).verifyTitleDisplayed();
    }

    @And("User sees forgot password error message")
    public void userSeesForgotPasswordErrorMessage() {
        ((ForgotPasswordPage) PageProvider.getPage(PageType.ForgotPassword)).errorPanelIsDisplayed();
    }
}
