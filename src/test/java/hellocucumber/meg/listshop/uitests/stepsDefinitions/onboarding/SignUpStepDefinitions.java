package hellocucumber.meg.listshop.uitests.stepsDefinitions.onboarding;

import hellocucumber.meg.listshop.uitests.framework.AppiumWrapper;
import hellocucumber.meg.listshop.uitests.framework.PageProvider;
import hellocucumber.meg.listshop.uitests.framework.PageType;
import hellocucumber.meg.listshop.uitests.pages.dashboard.AccountPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.ChoicePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignInPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignUpPage;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Date;
import java.util.UUID;

public class SignUpStepDefinitions {

    private String randomUsername;
    private final String randomPassword = "pppppppppp";

    @BeforeStep("@resetApp")
    public void resetApp() {
    AppiumWrapper.resetApp();
}

    @Given("User navigates to sign up page")
    public void userNavigatesToSignUpPage() throws InterruptedException {
        ChoicePage page = PageProvider.getChoicePage();
        if ( page.currentlyOnOnboardingPage()) {
            PageProvider.getChoicePage().clickOnSignUpButton();
            return;
        }

    }

    
    
    @And("User submits signup")
    public void userSubmitsSignup() throws InterruptedException {
    PageProvider.getSignUpPage().clickOnSignUpButton();
        
    }

    @When("User enters random username")
    public void userEntersRandomUsername() {
        String random = UUID.randomUUID().toString();
        randomUsername = random.substring(1,4) + new Date().getTime() +  "@test.com";
        PageProvider.getSignUpPage().enterUsername(randomUsername);
    }

    @And("User enters default password and verification")
    public void userEntersPasswordAndVerfication() throws InterruptedException {
        SignUpPage signUpPage = PageProvider.getSignUpPage();
        Thread.sleep(1000);
        signUpPage.enterPassword(randomPassword);
        Thread.sleep(1000);
        signUpPage.enterPasswordConfirmation(randomPassword);

    }

    @Then("User logs in with random user")
    public void userLogsInWithRandomUser() throws InterruptedException {
        PageProvider.getChoicePage().clickOnSignInButton();
        SignInPage signInPage = PageProvider.refreshSignInPage();

        signInPage.enterUsername(randomUsername);
        signInPage.enterPassword("passw0rd");
        signInPage.clickOnSubmit();
    }

    @When("User enters invalid username")
    public void userEntersInvalidRandomUsername() {
        PageProvider.getSignUpPage().enterUsername("longinvalidemail");
    }


    @And("User logs out")
    public void userLogsOut() throws InterruptedException {
        AccountPage page = PageProvider.getAccountPage();
        page.goToDashboard();
        page.clickOnLogoutButton();
        Thread.sleep(1000);

    }

    @And("User creates new account")
    public boolean userCreatesNewAccount() throws InterruptedException {
        ChoicePage page = PageProvider.getChoicePage();
        if (!page.currentlyOnOnboardingPage()) {
            return false;
        }
        PageProvider.getChoicePage().clickOnSignUpButton();
        SignUpPage signUpPage = PageProvider.getSignUpPage();
        String random = UUID.randomUUID().toString();
        randomUsername = random.substring(1, 4) + new Date().getTime() + "@test.com";

        boolean isSuccess = false;
        int safety = 0;
        while (!isSuccess && safety < 50) {
            Thread.sleep(1000);
            signUpPage.enterUsername(randomUsername);
            Thread.sleep(3000);
            signUpPage.enterPassword(randomPassword);
            Thread.sleep(3000);
            signUpPage.enterPasswordConfirmation(randomPassword);

            signUpPage.clickOnSignUpButton();
            isSuccess = !signUpPage.errorsDisplayed();
            safety++;
        }
        return true;
    }
}
