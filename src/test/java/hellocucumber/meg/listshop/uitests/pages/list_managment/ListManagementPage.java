package hellocucumber.meg.listshop.uitests.pages.list_managment;

import hellocucumber.meg.listshop.uitests.framework.AppiumWrapper;
import hellocucumber.meg.listshop.uitests.framework.Direction;
import hellocucumber.meg.listshop.uitests.framework.SwipeButtonCollection;
import hellocucumber.meg.listshop.uitests.framework.WithNavbarBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static io.appium.java_client.touch.offset.PointOption.point;

public class ListManagementPage extends WithNavbarBasePage {

    @FindBy(name="List Management Table")
    private MobileElement contentTable;

    @FindBy(name="Add List")
    private MobileElement addListButton;

    @iOSXCUITFindBy(accessibility = "Change Name")
    private MobileElement changeNameButton;

    @FindBy(name="Make Starter List")
    private MobileElement makeStarterListButton;

    @FindBy(name="Do Change List Name")
    private MobileElement changeNameActionButton;

    @FindBy(name="Change Name Entry")
    private MobileElement changeNameEntry;

    @FindBy(name="Clear Text")
    private MobileElement clearTextButton;
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCell'")
    private List<MobileElement> listCells;

    private SwipeButtonCollection swipeButtonCollection = new SwipeButtonCollection(Arrays.asList("more", "remove"));
    private int countBeforeAction = 0;
    private int countAfterAction = 0;



    public void clickOnAddListButton() throws InterruptedException {
        countBeforeAction = getListCount();
        tapOn(addListButton);
        Thread.sleep(1000);
        countAfterAction = getListCount();
    }

    public boolean listsContainListWithName(String listName) {
        List<MobileElement> nameTags = ((IOSElement) contentTable).findElementsByIosNsPredicate("type == 'XCUIElementTypeStaticText'");
        for (MobileElement element : nameTags) {
            if (element.getText().equals(listName)) {
                return true;
            }
        }
        return false;
    }

    public boolean listsContainsNoListWithName(String listName) {
        List<MobileElement> nameTags = ((IOSElement) contentTable).findElementsByIosNsPredicate("type == 'XCUIElementTypeStaticText'");
        for (MobileElement element : nameTags) {
            if (element.getText().equals(listName)) {
                return false;
            }
        }
        return true;
    }

    public int getListCount() {
        List<MobileElement> listElements = ((IOSElement) contentTable).findElementsByIosNsPredicate("type == 'XCUIElementTypeCell'");
        return listElements.size();
    }

    public boolean listChangeAfterAction(int delta) {
        return (countAfterAction - countBeforeAction) == delta;
    }

    private MobileElement getTableCellByListName(String listName) {
        for (MobileElement cell : listCells) {
            MobileElement textLabel = ((IOSElement) cell).findElementByIosNsPredicate("type == 'XCUIElementTypeStaticText'");
            if (textLabel.getText().equals(listName)) {
                return cell;
            }
        }
        return null;
    }
    public boolean examples() throws InterruptedException {
        /*List<MobileElement> test = ((IOSElement) contentTable).findElementsByIosNsPredicate("type == 'XCUIElementTypeCell'");

        List<MobileElement> fountFromTable = ((IOSElement) contentTable).findElementsByIosNsPredicate("name == 'Ace Hardware'");
        List<MobileElement> fountFromTab = ((IOSElement) contentTable).findElementsByIosNsPredicate("type == 'XCUIElementTypeCell'");
        List<MobileElement> nameTags = ((IOSElement) contentTable).findElementsByIosNsPredicate("type == 'XCUIElementTypeStaticText'");
        MobileElement fountFromTable2 = ((IOSElement) contentTable).findElementByName("Ace Hardware");
boolean ret = checkElementDisplayed(fountFromTable2, 3);

boolean withNameGeorgeExists = false;
List<String> nameList = new ArrayList<>();
for (MobileElement element : nameTags) {
    nameList.add(element.getText());
    if (element.getText().equals("Shopping List")) {
        withNameGeorgeExists = true;
    }

}
    MobileElement element = getTableCellByListName("Shopping List");

     mobileSwipeElementIOS(element, Direction.LEFT);
        MobileElement afterSwipe = getTableCellByListName("Shopping List");
        MobileElement textLabel = ((IOSElement) afterSwipe).findElementByIosNsPredicate("type == 'XCUIElementTypeStaticText'");
        String beep = textLabel.getText();
        List<MobileElement> containedAfterSwipt = ((IOSElement) afterSwipe).findElementsByIosNsPredicate("visible == 1");
        for (MobileElement ttt : containedAfterSwipt) {
            System.out.println(ttt.getText() + ": " + ttt.getAttribute("type"));
        }

        Rectangle rect = element.getRect();
        Point point = rect.getPoint();
        return element != null;
        clickOnMore("Shopping List");
        tapOn(changeNameButton);
        Thread.sleep(500);
        tapOn(changeNameEntry);
        setValue(changeNameEntry, " Purple Haze");
        boolean test = checkElementDisplayed(changeNameActionButton, 1);
        //tapOn(changeNameActionButton);
        tapOn(changeNameActionButton);
        return true;*/
        return false;
    }

    public void clickOnRemoveList(String list) throws InterruptedException {
        countBeforeAction = getListCount();
        MobileElement toRemove = getTableCellByListName(list);
        // swipe on cell
        swipeElement(toRemove, Direction.LEFT);
        // get coordinates
        Point removePoint = swipeButtonCollection.getTapCoordinates("remove", toRemove.getRect());
        tapActionByCoordinates(removePoint);
        Thread.sleep(500);
        countAfterAction = getListCount();
    }

    public void clickOnMore(String list) throws InterruptedException {
        countBeforeAction = getListCount();
        MobileElement toRemove = getTableCellByListName(list);
        // swipe on cell
        swipeElement(toRemove, Direction.LEFT);
        // get coordinates
        Point removePoint = swipeButtonCollection.getTapCoordinates("more", toRemove.getRect());
        tapActionByCoordinates(removePoint);
        Thread.sleep(500);
        countAfterAction = getListCount();
    }


    public void addToListName(String listSuffix, String listName) throws InterruptedException {
        clickOnMore(listName);
        tapOn(changeNameButton);
        Thread.sleep(500);
        tapOn(changeNameEntry);
        setValue(changeNameEntry, listSuffix);
        tapOn(changeNameActionButton);
    }
    public void replaceListName(String newName, String existingName) throws InterruptedException {
        clickOnMore(existingName);
        tapOn(changeNameButton);
        Thread.sleep(500);
        tapOn(clearTextButton);
        tapOn(changeNameEntry);
        setValue(changeNameEntry, newName);
        tapOn(changeNameActionButton);
    }

    public void selectList(String shoppingList) {
        MobileElement listCell = getTableCellByListName(shoppingList);
        tapOn(listCell);
    }
}