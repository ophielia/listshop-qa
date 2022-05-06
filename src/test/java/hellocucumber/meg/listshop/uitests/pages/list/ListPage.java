package hellocucumber.meg.listshop.uitests.pages.list;

import hellocucumber.meg.listshop.uitests.framework.WithNavbarBasePage;
import hellocucumber.meg.listshop.uitests.pages.onboarding.OnboardingBasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ListPage extends WithNavbarBasePage {

    @FindBy(name = "List Title")
    MobileElement listTitleLabel;


    public boolean verifyCurrentListName(String shoppingList) {
        return listTitleLabel.getText().equals(shoppingList);
    }
}