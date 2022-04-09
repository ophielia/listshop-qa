package hellocucumber.meg.listshop.uitests.framework;

import hellocucumber.meg.listshop.uitests.util.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumWrapper {

    private static AppiumDriver appiumDriver;
    private static AppiumDriver appiumResinstallDriver;

    private static boolean useReinstallDriver = false;
    /**
     * This method initializes the appium driver object on default mobile device specified in the config file
     *
     * @throws MalformedURLException
     */
    private static void intializeAppiumDriver(boolean withReinstall) throws MalformedURLException {
        if (withReinstall) {
            appiumResinstallDriver = buildAppiumDriver(withReinstall);
            appiumResinstallDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } else {
            appiumDriver = buildAppiumDriver(withReinstall);
            // This is used in cases where fluent wait is not applied (fluentWait() at BaseWebPage class)
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }


    }


    //IOS and Android AppiumDriver
    private static AppiumDriver buildAppiumDriver(boolean withReinstall) throws MalformedURLException {
        ConfigReader configReader = new ConfigReader();
        AppiumDriver appiumDriver = null;
        String appiumServerURL = "http://0.0.0.0:4723/wd/hub";
        String platformName = configReader.getMobilePlatformName();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, configReader.getMobileAutomationName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, configReader.getMobileDeviceName());
        capabilities.setCapability(MobileCapabilityType.APP, configReader.getMobileAppPath());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 190000);

        if (withReinstall) {
            capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        } else {
            capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        }
        if (platformName.equalsIgnoreCase("ios")) {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, configReader.getMobileVersion());
            appiumDriver = new IOSDriver(new URL(appiumServerURL), capabilities);
        } else if (platformName.equals("android")) {
            appiumDriver = new AndroidDriver(new URL(appiumServerURL), capabilities);
        } else {
            throw new UnsupportedOperationException("Invalid Platform Name" + platformName);
        }
        return appiumDriver;
    }

    /**
     * This will start an Appium server and return an Appium driver (or initialize it if it's not initialized)
     * Only 1 driver and server will be started/initialized per run
     *
     * @return Appium driver
     */
    public static AppiumDriver getAppiumDriver() {
        if (useReinstallDriver) {
            return getAppiumReinstallDriver();
        }
        return getStandardAppiumDriver();
    }

    public static AppiumDriver getStandardAppiumDriver() {
        if (appiumDriver == null) {
            try {
                // the start appium server may be called multiple times, since only 1 instance is created
                intializeAppiumDriver(false);
            } catch (MalformedURLException e) {
                Assertions.fail("Unable to initialize Appium driver due to invalid Server URL or there server is already in use");

            }
        }

        return appiumDriver;
    }

    public static AppiumDriver getAppiumReinstallDriver() {
        if (appiumResinstallDriver == null) {
            try {
                // the start appium server may be called multiple times, since only 1 instance is created
                intializeAppiumDriver(true);
            } catch (MalformedURLException e) {
                Assertions.fail("Unable to initialize Appium driver due to invalid Server URL or there server is already in use");

            }
        }

        return appiumResinstallDriver;
    }

    @After("@mobile")
    public static void resetApp() {
       getAppiumDriver().resetApp();
    }

    @Before("@anonymoususer")
    public static void setReinstallDriver() {
        useReinstallDriver = true;
    }

    /**
     * This method is used to quit the Appium driver if it is not null
     */
    //@After("@mobile")
    public static void quitAppiumDriver() {
        if (appiumDriver != null) {
            System.out.println("    Quitting Appium..");
            appiumDriver.quit();
            System.out.println("Quitting Appium - Done");
            appiumDriver = null;
        }
    }
}
