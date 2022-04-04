package hellocucumber.meg.listshop.uitests.framework;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static hellocucumber.meg.listshop.uitests.framework.AppiumWrapper.*;

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
        try {
            return mobileElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

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
