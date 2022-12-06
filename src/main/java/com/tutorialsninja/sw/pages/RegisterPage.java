package com.tutorialsninja.sw.pages;

import com.tutorialsninja.sw.utility.Utility;
import org.openqa.selenium.By;

public class RegisterPage extends Utility {
    By firstNameField = By.xpath("//input[@id='input-firstname']");
    By lastNameField = By.xpath("//input[@id='input-lastname']");
    By emailIdField = By.xpath("//input[@id='input-email']");
    By phoneNumberField = By.xpath("//input[@id='input-telephone']");
    By passwordField = By.xpath("//input[@id='input-password']");
    By passwordConfirmField = By.xpath("//input[@id='input-confirm']");
    By radioButton = By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[2]/input[1]");
    By privacyPolicy =By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]");
    By continueButton =By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]");
    By accountCreated =By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"); //Your Account Has Been Created!
    By continueButtonLink = By.xpath("//a[contains(text(),'Continue')]");
    By myAccountLink = By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]");
    By logOut =By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]");

    public void enterFirstNameField(String firstname){sendTextToElement(firstNameField,firstname);}
    public void enterLastNameField(String lastName){sendTextToElement(lastNameField,lastName);}
    public void enterEmailIdField(String emailId){sendTextToElement(emailIdField,emailId );}
    public void enterPhoneNumberField(String phoneNumber){sendTextToElement(phoneNumberField,phoneNumber);}
    public void enterPasswordField (String password){sendTextToElement(passwordField,password);}
    public void enterPasswordConfirmField(String passwordConfirm){sendTextToElement(passwordConfirmField,passwordConfirm);}
    public void clickOnRadioButton(){clickOnElement(radioButton);}
    public void clickOnPrivacyPolicy(){clickOnElement(privacyPolicy);}
    public void clickOnContinueButton(){clickOnElement(continueButton);}
    public void verifyAccountCreated(){verifyTextFromElements(accountCreated,"Your Account Has Been Created!");}
    public void clickOnContinueButtonLink(){clickOnElement(continueButtonLink);}
    public void clickOnMyAccountLin(){clickOnElement(myAccountLink);}
    public void clickOnLogOut(){clickOnElement(logOut);}



}
