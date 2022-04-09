package hellocucumber.meg.listshop.uitests.stepsDefinitions.dashboard;

import hellocucumber.meg.listshop.uitests.framework.WithNavbarBasePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.ChoicePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignInPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class OnboardingPageStepDefinitionsBase {

    ChoicePage homePage = new ChoicePage();
    SignUpPage signUpPage = new SignUpPage();
    SignInPage signInPage = new SignInPage();
    WithNavbarBasePage anyNavbarPage = new WithNavbarBasePage();


}
