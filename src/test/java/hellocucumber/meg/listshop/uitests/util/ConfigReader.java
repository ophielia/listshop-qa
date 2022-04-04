package hellocucumber.meg.listshop.uitests.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private String mobileAutomationName;
    private String platformName;
    private String mobileDeviceName;
    private String mobileAppPath;
    private String mobileVersion;

    public ConfigReader() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            //mobile
            this.mobileAutomationName = prop.getProperty("mobileAutomationName");
            this.platformName = prop.getProperty("platformName");
            this.mobileDeviceName = prop.getProperty("mobileDeviceName");
            this.mobileAppPath = prop.getProperty("mobileAppPath");
            this.mobileVersion = prop.getProperty("mobileVersion");


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public String getMobileAutomationName() {
        return mobileAutomationName;
    }

    public String getMobilePlatformName() {
        return platformName;
    }

    public String getMobileDeviceName(){
        return mobileDeviceName;
    }

    public String getMobileAppPath(){
        return mobileAppPath;
    }

    public String getMobileVersion(){
        return mobileVersion;
    }
}
