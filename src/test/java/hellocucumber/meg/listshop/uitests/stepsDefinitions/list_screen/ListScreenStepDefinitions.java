package hellocucumber.meg.listshop.uitests.stepsDefinitions.list_screen;

import hellocucumber.meg.listshop.uitests.framework.PageProvider;
import hellocucumber.meg.listshop.uitests.pages.list.ListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.HashSet;
import java.util.Set;


public class ListScreenStepDefinitions {

    private int swipedListCount = 0;

    @Given("User navigates to list screen page")
    public void playground() throws InterruptedException {
        ListPage listPage = PageProvider.getListPage();
        listPage.navigateToToolbar(ListPage.ADD_DISH_HANDLE);

        // get current list name
        Set<String> names = new HashSet<>();
        String startName = listPage.displayedListName();
        if (startName == null) {
            return;
        }
        names.add(startName);
        listPage.swipeToNextList();
        listPage.checkPageSource();

        String listName = listPage.displayedListName();
        while (!startName.equals(listName)) {
            names.add(listName);
            listPage.swipeToNextList();
            listName = listPage.displayedListName();
        }

        listPage.navigateToToolbar(ListPage.ADD_DISH_HANDLE);
    }


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
}
