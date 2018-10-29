package com.epam.lab.androidGmailTest.businessObject;

import com.epam.lab.androidGmailTest.pageObject.GmailPO;
import io.appium.java_client.MobileDriver;

public class GmailBO {
    private GmailPO gmail;

    public GmailBO(MobileDriver driver){
        gmail = new GmailPO(driver);
    }

    public void signIn(String username, String password){
        gmail.gotItButtonClick();
        gmail.addAnotherButtonClick();
        gmail.gmailButtonClick();
        gmail.printUsername(username);
        gmail.nextButtonClick();
        gmail.inputPassword(password);
        gmail.passwordNextButtonClick();
    }

    public void startUsing(){
        gmail.iAgreeButtonClick();
        gmail.moreAndAcceptButtonsClick();
        gmail.takeMeToGmailClick();
    }

    public String getEmail(){
        gmail.menuButtonClick();
        return gmail.email();
    }
}
