package hellocucumber.meg.listshop.uitests.stepsDefinitions.list_management;

import hellocucumber.meg.listshop.uitests.framework.PageProvider;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ListManagementStepDefinitions {

    public ListManagementStepDefinitions() {

    }

    @Given("User sees lists")
    public boolean userSeesLists() throws InterruptedException {
        return userSeesAtMinimumListCount(1);
    }


    @Then("User sees at least {int} list")
    public boolean userSeesAtMinimumListCount(int expectedListMinimum) {
        int currentListCount = PageProvider.getListManagementPage().getListCount();
        return currentListCount >= expectedListMinimum;
    }

    @When("User adds a list")
    public void userAddsAList() throws InterruptedException {
        PageProvider.getListManagementPage().clickOnAddListButton();
    }

    @Then("User sees an additional list")
    public void userSeesAnAdditionalList() {
        Assertions.assertTrue(PageProvider.getListManagementPage().listChangeAfterAction(1));
    }

    @And("One of the lists is called {string}")
    public boolean oneOfTheListsIsCalled(String listName) {
        return PageProvider.getListManagementPage().listsContainListWithName(listName);
    }

    @When("User removes list {string}")
    public void userRemovesList(String listToRemove) throws InterruptedException {
        PageProvider.getListManagementPage().clickOnRemoveList(listToRemove);

    }

    @Then("User no longer sees list {string}")
    public boolean userNoLongerSeesList(String listName) {
            return PageProvider.getListManagementPage().listsContainsNoListWithName(listName);
    }

    @And("User sees {int} fewer lists")
    public void userSeesFewerLists(int delta) {
        Assertions.assertTrue(PageProvider.getListManagementPage().listChangeAfterAction(delta * -1));
    }

    @When("User adds {string} to list named {string}")
    public void userAddsToListNamed(String listSuffix, String listName) throws InterruptedException {
        PageProvider.getListManagementPage().addToListName(listSuffix, listName);
    }

    @When("User changes name of {string} to {string}")
    public void userChangesNameOfTo(String existingListName, String newListName) throws InterruptedException {
        PageProvider.getListManagementPage().replaceListName(newListName, existingListName);
    }

    @When("User selects list {string}")
    public void userSelectsList(String shoppingList) {
        PageProvider.getListManagementPage().selectList(shoppingList);
    }

    @Then("User is on list page for list {string}")
    public boolean userIsOnListPageForList(String shoppingList) {
        return PageProvider.getListPage().verifyCurrentListName(shoppingList);
    }
}



/*

MobileElement el8 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTable[@name=\"List Management Table\"]/XCUIElementTypeCell[2]");
el8.click();
MobileElement el9 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"NavBarListManagement\"]/XCUIElementTypeImage");
el9.click();
MobileElement el10 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTable[@name=\"List Management Table\"]/XCUIElementTypeCell[5]");
el10.click();

 */