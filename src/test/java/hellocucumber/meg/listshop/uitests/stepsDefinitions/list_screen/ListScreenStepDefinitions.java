package hellocucumber.meg.listshop.uitests.stepsDefinitions.list_screen;

import hellocucumber.meg.listshop.uitests.framework.PageProvider;
import hellocucumber.meg.listshop.uitests.pages.list.ListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.HashSet;
import java.util.Set;


public class ListScreenStepDefinitions {

    private int swipedListCount = 0;

    @Given("User navigates to toolbar {string}")
    public void userNavigatesToToolbar(String toolbarHandle) {
        PageProvider.getListPage().navigateToToolbar(toolbarHandle);
    }

    @Then("Toolbar  {string} should be displayed")
    public void toolbarShouldBeDisplayed(String toolbarHandle) {
        PageProvider.getListPage().toolbarIsDisplayed(toolbarHandle);
    }

    @Given("User swipes through all lists")
    public void userSwipesThroughAllLists() {
        ListPage listPage = PageProvider.getListPage();
        Set<String> names = new HashSet<>();
        String startName = listPage.displayedListName();
        if (startName == null) {
            return;
        }
        names.add(startName);
        listPage.swipeToNextList();

        String listName = listPage.displayedListName();
        while (!startName.equals(listName)) {
            names.add(listName);
            listPage.swipeToNextList();
            listName = listPage.displayedListName();
        }

        swipedListCount = names.size();
    }

    @Then("User should have seen at least {int} lists")
    public boolean userShouldHaveSeenAtLeastLists(int minimumListCount) {
        return swipedListCount >= minimumListCount;
    }

    @And("User should have seen exactly {int} list")
    public boolean userShouldHaveSeenExactlyList(int exactCountLists) {
        return swipedListCount == exactCountLists;
    }

    @Given("User navigates to shopping list {string}")
    public void userNavigatesToShoppingList(String shoppingListName) {
        ListPage listPage = PageProvider.getListPage();
        Set<String> names = new HashSet<>();
        String startName = listPage.displayedListName();
        if (startName == null || startName.equalsIgnoreCase(shoppingListName)) {
            return;
        }
        names.add(startName);
        listPage.swipeToNextList();

        String listName = listPage.displayedListName();
        while (!shoppingListName.equals(listName)) {
            names.add(listName);
            listPage.swipeToNextList();
            listName = listPage.displayedListName();
        }

        swipedListCount = names.size();

    }

    @And("User reveals legend view")
    public void userRevealsLegendView() throws InterruptedException {
        PageProvider.getListPage().tapOnLegendHandle();
    }

    @Then("User should see legend view")
    public boolean userShouldSeeLegendView() {
        return PageProvider.getListPage().legendIsShown();
    }

    @Then("User should not see legend handle")
    public boolean userShouldNotSeeLegendHandle() {
        return !PageProvider.getListPage().legendHandleIsShown();
    }


}
