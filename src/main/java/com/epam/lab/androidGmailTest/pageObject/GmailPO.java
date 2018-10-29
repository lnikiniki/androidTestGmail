package com.epam.lab.androidGmailTest.pageObject;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GmailPO {
    private MobileDriver driver;
    private WebDriverWait wait;

    @AndroidFindBy(id = "com.google.android.gm:id/welcome_tour_got_it")
    private MobileElement gotItButton;

    @AndroidFindBy(id = "com.google.android.gm:id/setup_addresses_add_another")
    private MobileElement addAnotherButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout")
    private MobileElement gmailButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.EditText")
    private MobileElement userNameInput;

    @AndroidFindBy(id = "password")
    private MobileElement passwordInput;

    @AndroidFindBy(id = "passwordNext")
    private MobileElement passwordNextButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[4]/android.widget.Button")
    private MobileElement nextButton;

    @AndroidFindBy(id = "com.google.android.gm:id/action_done")
    private MobileElement takeMeToGmailButton;

    @AndroidFindBy(id = "signinconsentNext")
    private MobileElement iAgreeButton;

    @AndroidFindBy(id = "com.google.android.gms:id/next_button")
    private MobileElement moreButton;

    @AndroidFindBy(id = "com.google.android.gms:id/next_button")
    private MobileElement acceptButton;

    @AndroidFindBy(id = "com.google.android.gm:id/owner")
    private MobileElement ownerLabel;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
    private MobileElement menuButton;

    @AndroidFindBy(id = "com.google.android.gm:id/account_address")
    private MobileElement emailLabel;

    public GmailPO(MobileDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
    }

    public void menuButtonClick() {
        menuButton.click();
    }

    public String email() {
        return emailLabel.getText();
    }

    public void moreAndAcceptButtonsClick() {
        wait.until(ExpectedConditions.elementToBeClickable(moreButton));
        moreButton.click();
        acceptButton.click();
    }

    public void iAgreeButtonClick() {
        iAgreeButton.click();
    }

    public void addAnotherButtonClick() {
        addAnotherButton.click();
    }

    public void gmailButtonClick() {
        gmailButton.click();
    }

    public void printUsername(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.sendKeys(username);
    }

    public void nextButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    public void inputPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.sendKeys(password);
    }

    public void passwordNextButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(passwordNextButton));
        passwordNextButton.click();
    }

    public void takeMeToGmailClick() {
        wait.until(ExpectedConditions.visibilityOf(ownerLabel));
        wait.until(ExpectedConditions.elementToBeClickable(takeMeToGmailButton));
        takeMeToGmailButton.click();
    }

    public void gotItButtonClick() {
        gotItButton.click();
    }
}
