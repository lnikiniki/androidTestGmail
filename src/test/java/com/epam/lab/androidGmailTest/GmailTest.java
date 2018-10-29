package com.epam.lab.androidGmailTest;

import com.epam.lab.androidGmailTest.businessObject.GmailBO;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class GmailTest {
    private static MobileDriver driver;

    @BeforeClass
    public static void setUp(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.google.android.gm");
        capabilities.setCapability("appActivity", ".ui.MailActivityGmail");
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void gmailTest(){
        String username = "lnitesttesttest@gmail.com";
        String password = "lnikiniki";
        GmailBO gmailBO = new GmailBO(driver);
        gmailBO.signIn(username, password);
        gmailBO.startUsing();
        Assert.assertEquals(username, gmailBO.getEmail());
    }
}
