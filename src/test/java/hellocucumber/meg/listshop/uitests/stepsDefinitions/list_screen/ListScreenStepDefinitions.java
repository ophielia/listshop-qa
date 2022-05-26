package hellocucumber.meg.listshop.uitests.stepsDefinitions.list_screen;

import hellocucumber.meg.listshop.uitests.framework.PageProvider;
import hellocucumber.meg.listshop.uitests.pages.list.ListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class ListScreenStepDefinitions {

    @Given("User navigates to list screen page")
    public void playground() {
        ListPage listPage = PageProvider.getListPage();
        boolean testOnScreen = listPage.mainToolbarIsShown();
        boolean testOnScreen2 = listPage.addDishToolbarIsShown();
        boolean testOnScreen12 = listPage.addItemToolbarIsShown();
        boolean testOnScreen13 = listPage.addListToolbarIsShown();
        listPage.navigateToToolbar(ListPage.ADD_ITEM_HANDLE);
        listPage.navigateToToolbar(ListPage.ADD_LIST_HANDLE);
        listPage.navigateToToolbar(ListPage.MAIN_TOOLBAR_HANDLE);
        listPage.navigateToToolbar(ListPage.ADD_DISH_HANDLE);
        boolean testOnScreen14 = listPage.addListToolbarIsShown();
    }


    @Given("User navigates to toolbar {string}")
    public void userNavigatesToToolbar(String toolbarHandle) {
        PageProvider.getListPage().navigateToToolbar(toolbarHandle);
    }

    @Then("Toolbar  {string} should be displayed")
    public void toolbarShouldBeDisplayed(String toolbarHandle) {
        PageProvider.getListPage().toolbarIsDisplayed(toolbarHandle);
    }
}
