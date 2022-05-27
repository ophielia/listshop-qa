package hellocucumber.meg.listshop.uitests.pages.list;

import hellocucumber.meg.listshop.uitests.framework.Direction;
import hellocucumber.meg.listshop.uitests.framework.WithNavbarBasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.FindBy;

public class ListPage extends WithNavbarBasePage {

    public static final String ADD_ITEM_HANDLE = "Add Item";
    public static final String ADD_DISH_HANDLE = "Add Dish";
    public static final String ADD_LIST_HANDLE = "Add List";
    public static final String MAIN_TOOLBAR_HANDLE = "Main Toolbar";
    @FindBy(name = "List Title")
    MobileElement listNameLabel;

    @FindBy(name = "List Indicator")
    MobileElement listIndicatorElement;

    @FindBy(name = "Main Toolbar")
    MobileElement mainToolbar;

    @FindBy(name = "Add Item")
    MobileElement addItemToolbar;

    @FindBy(name = "Add List")
    MobileElement addListToolbar;

    @FindBy(name = "Add Dish")
    MobileElement addDishToolbar;

    @FindBy(name = "Legend Toggle")
    MobileElement legendHandle;

    @FindBy(name = "Delete Bucket")
    MobileElement legendDelete;

    public boolean verifyCurrentListName(String shoppingList) {
        return listNameLabel.getText().equals(shoppingList);
    }

    public boolean mainToolbarIsShown() {
        return checkElementDisplayedOnScreen(mainToolbar, 2);
    }

    public boolean addItemToolbarIsShown() {
        return checkElementDisplayedOnScreen(addItemToolbar, 2);
    }

    public boolean addDishToolbarIsShown() {
        return checkElementDisplayedOnScreen(addDishToolbar, 2);
    }

    public boolean addListToolbarIsShown() {
        return checkElementDisplayedOnScreen(addListToolbar, 2);
    }

    public void swipeToNextList() {
        swipeElement(listIndicatorElement, Direction.LEFT);
    }


    public String displayedListName() {
        return listNameLabel.getText();

    }

    public void tapOnLegendHandle() throws InterruptedException {
        // get coordinates
        Point removePoint = legendHandle.getCenter();
        tapActionByCoordinates(removePoint);
    }

    public boolean toolbarIsDisplayed(String toolbarHandle) {
        if (toolbarHandle.equals(ADD_ITEM_HANDLE)) {
            return addItemToolbarIsShown();
        } else if (toolbarHandle.equals(ADD_DISH_HANDLE)) {
            return addDishToolbarIsShown();
        } else if (toolbarHandle.equals(ADD_LIST_HANDLE)) {
            return addListToolbarIsShown();
        } else if (toolbarHandle.equals(MAIN_TOOLBAR_HANDLE)) {
            return mainToolbarIsShown();
        }
        return false;
    }
    public void navigateToToolbar(String toolbarHandle) {
        if (toolbarHandle.equals(ADD_ITEM_HANDLE)) {
            navigateToToolbar(addItemToolbar);
        } else if (toolbarHandle.equals(ADD_DISH_HANDLE)) {
            navigateToToolbar(addDishToolbar);
        } else if (toolbarHandle.equals(ADD_LIST_HANDLE)) {
            navigateToToolbar(addListToolbar);
        } else if (toolbarHandle.equals(MAIN_TOOLBAR_HANDLE)) {
            navigateToToolbar(mainToolbar);
        }
    }

    public boolean legendIsShown() {
        return checkElementDisplayed(legendDelete);
    }

    public boolean legendHandleIsShown() {
        return checkElementDisplayed(legendHandle);
    }

    private void navigateToToolbar(MobileElement element) {
        boolean toolbarShown = (checkElementDisplayedOnScreen(element, 1));
        int safety = 0;
        while (!toolbarShown && safety < 50) {
            MobileElement displayedToolbar = getDisplayedToolbar();
            swipeElement(displayedToolbar, Direction.LEFT);
            toolbarShown = (checkElementDisplayedOnScreen(element, 1));
            safety++;
        }


    }

    private MobileElement getDisplayedToolbar() {
        if (mainToolbarIsShown()) {
            return mainToolbar;
        } else if (addDishToolbarIsShown()) {
            return addDishToolbar;
        } else if (addItemToolbarIsShown()) {
            return addItemToolbar;
        } else if (addListToolbarIsShown()) {
            return addListToolbar;
        }
        return null;
    }


}