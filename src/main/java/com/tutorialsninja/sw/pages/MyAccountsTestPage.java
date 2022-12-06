package com.tutorialsninja.sw.pages;

import com.tutorialsninja.sw.utility.Utility;
import org.openqa.selenium.By;

public class MyAccountsTestPage extends Utility {
    // verifyUserShouldNavigateToRegisterPageSuccessfully
    By myAccountLink = By.xpath("//span[contains(text(),'My Account')]");
    By registerLink = By.xpath("//a[contains(text(),'Register')]");
    By registerAccount = By.xpath("//h1[contains(text(),'Register Account')]");

    public void clickOnMyAccountLink(){clickOnElement(myAccountLink);}
    public void clickOnRegisterLink(){clickOnElement(registerLink);}
    public void verifyRegisterAccount(){verifyTextFromElements(registerAccount,"Register Account");}


    By loginLink = By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]");
    By returnCustomer = By.xpath("//h2[contains(text(),'Returning Customer')]");
    public void clickOnLoginLink (){clickOnElement(loginLink);}
    public void verifyReturnCustomer(){verifyTextFromElements(returnCustomer,"Returning Customer");}

}
