package hellocucumber.meg.listshop.uitests.framework;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static hellocucumber.meg.listshop.uitests.framework.AppiumWrapper.*;
import static io.appium.java_client.touch.offset.PointOption.point;

public class MobileBasePage {

    /**
     * This is a constructor which initializes initPageElements()
     */
    public MobileBasePage() {
        initPageElements();
    }

    /**
     * This method handles wait functionality for mobile actions, which means if the element is not found
     * during test then the app will re-try and wait up to 15 seconds before failing the test step
     */
    protected void initPageElements() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    /**
     * This method is used to tap on element
     *
     * @param mobileElement element to tap on
     */
    protected void tapOn(MobileElement mobileElement) {
        try {
            mobileElement.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
    }

    /**
     * This method is used to set value in text field
     *
     * @param mobileElement
     * @param setValue
     */
    protected void setValue(MobileElement mobileElement, String setValue) {

        try {
            mobileElement.clear();
            mobileElement.sendKeys(setValue);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
    }

    /**
     * This method is used to verify if element is displayed
     * @param mobileElement
     * @return
     */
    protected boolean isElementDisplayed(MobileElement mobileElement) {
       boolean isDisplayed;
        try {
            isDisplayed = mobileElement.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }

        return isDisplayed;
        //return false;
    }

    protected boolean checkElementDisplayed(MobileElement mobileElement) {
        return checkElementDisplayed(mobileElement, 2);

    }

    protected boolean checkElementDisplayed(MobileElement mobileElement, int waitSeconds) {
        try{
            AppiumWrapper.getAppiumDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(AppiumWrapper.getAppiumDriver(), waitSeconds);
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
        }catch(Exception e){
            return false;
        } finally {
            AppiumWrapper.getAppiumDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return true;
    }

    protected boolean checkElementDisplayedOnScreen(MobileElement mobileElement, int waitSeconds) {
        if (!checkElementDisplayed(mobileElement)) {
            return false;
        }

        // now, since it may be off screen - check that it's visible to the user
        Dimension screenDimansion = AppiumWrapper.getAppiumDriver().manage().window().getSize();
        Dimension elementDimension = mobileElement.getSize();
        Point elementOrigin = mobileElement.getLocation();

        if (elementOrigin.getX() < 0 || (elementOrigin.getX() + elementDimension.getWidth()) > screenDimansion.getWidth() ) {
            return false;
        }
        return true;
    }

    protected boolean swipeElement(MobileElement mobileElement, Direction direction ) {
        final int ANIMATION_TIME = 200; // ms
        final HashMap<String, String> scrollObject = new HashMap<String, String>();

        switch (direction) {
            case DOWN: // from up to down (! differs from mobile:scroll)
            case UP: // from down to up  (! differs from mobile:scroll)
            case LEFT: // from right to left  (! differs from mobile:scroll)
            case RIGHT: // from left to right  (! differs from mobile:scroll)
                scrollObject.put("direction", direction.name().toLowerCase());
                break;
            default:
                throw new IllegalArgumentException("mobileSwipeElementIOS(): dir: '" + direction + "' NOT supported");
        }
        scrollObject.put("element", mobileElement.getId());
        try {
            AppiumWrapper.getAppiumDriver().executeScript("mobile:swipe", scrollObject);
            Thread.sleep(ANIMATION_TIME); // always allow swipe action to complete
        } catch (Exception e) {
            System.err.println("mobileSwipeElementIOS(): FAILED\n" + e.getMessage());
            return true;
        }
return true;
    }

    public void tapActionByCoordinates(Point point) throws InterruptedException {
        TouchAction startStop = new TouchAction(AppiumWrapper.getAppiumDriver())
                .tap(point(point.x,point.y));
        startStop.perform();
        Thread.sleep(2500);
    }


    /**
     * This method is used to verify if element is enabled
     * @param mobileElement
     * @return
     */
    protected boolean isElementEnabled(MobileElement mobileElement){
        boolean isEnabled;
        try {
            isEnabled = mobileElement.isEnabled();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
        return isEnabled;
    }



    public void clickOnElement(List<MobileElement> toggleSwitch) throws InterruptedException {
        List<MobileElement> elementsOne = toggleSwitch;
        Thread.sleep(3000);
        System.out.println("hello!");
        for (MobileElement e : elementsOne) {
            System.out.println("Element is selected " + e.isDisplayed() +"other" + e.getAttribute("attribute"));
        }
    }

}
