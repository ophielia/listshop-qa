package hellocucumber.meg.listshop.uitests.stepsDefinitions.onboarding;

import hellocucumber.meg.listshop.uitests.framework.WithNavbarBasePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.ChoicePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignInPage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.SignUpPage;

public class OnboardingPageStepDefinitionsBase {

    ChoicePage homePage = new ChoicePage();
    SignUpPage signUpPage = new SignUpPage();
    SignInPage signInPage = new SignInPage();
    WithNavbarBasePage anyNavbarPage = new WithNavbarBasePage();


}
