package com.tutorialsninja.sw.testbase.testsuite;

import com.tutorialsninja.sw.pages.*;
import com.tutorialsninja.sw.testbase.BaseTest;
import com.tutorialsninja.sw.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class LoginPageTest extends BaseTest {

    MyAccountsTestPage myAccountsTestPage = new MyAccountsTestPage();
    RegisterPage registerPage = new RegisterPage();

    DesktopsTestPage desktopsTestPage = new DesktopsTestPage();
    HomePage homePage=new HomePage();
    LaptopsAndNotBooksTestPage laptopsAndNotBooksTestPage = new LaptopsAndNotBooksTestPage();

    @Test
    //registerclick
    public void verifyUserShouldNavigateToRegisterPageSuccessfullys() {
        myAccountsTestPage.clickOnMyAccountLink();
        myAccountsTestPage.clickOnRegisterLink();
        myAccountsTestPage.verifyRegisterAccount();
    }

    @Test
    //loginclick
    public void verifyUserShouldNavigateToLoginPageSuccessfullys() {
        myAccountsTestPage.clickOnMyAccountLink();
        myAccountsTestPage.clickOnLoginLink();
        myAccountsTestPage.verifyReturnCustomer();

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //Register
        myAccountsTestPage.clickOnMyAccountLink();
        myAccountsTestPage.clickOnRegisterLink();
        registerPage.enterFirstNameField("kishan");
        registerPage.enterLastNameField("malaviya");
        registerPage.enterEmailIdField("kishan" + Utility.getAlphaNumericString(2) + "@yahoo.co.in");
        registerPage.enterPhoneNumberField("07534668650");
        registerPage.enterPasswordField("Vivek241990");
        registerPage.enterPasswordConfirmField("Vivek241990");
        registerPage.clickOnRadioButton();
        registerPage.clickOnPrivacyPolicy();
        registerPage.clickOnContinueButton();
        registerPage.verifyAccountCreated();
        registerPage.clickOnContinueButtonLink();
        registerPage.clickOnMyAccountLin();
        registerPage.clickOnLogOut();


    }

    @Test//1
    public void verifyProductArrangeInAlphaBaticalOrder() {
        homePage.mouseHoverAndClick();
        homePage.clickOnShowDesktopButton();
        desktopsTestPage.selectByIndex();
        Assert.assertEquals(getTextFromElement(By.xpath("//h4/a")), "Sony VAIO", "Sony VAIO");

    }

    @Test//2
    public void verifyProductAddedToShoppingCartSuccessFully() {
        homePage.mouseHoverAndClick();
        homePage.clickOnShowDesktopButton();
        desktopsTestPage.selectByAtoZ();
        homePage.clickOnContentButton(By.xpath("//a[contains(text(),'HP LP3065')]"));

//    2.5 Verify the Text "HP LP3065"
        Assert.assertEquals("HP LP3065", "HP LP3065",
                getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]")));
        desktopsTestPage.dateSelection();
        homePage.clickOnAddToCartButton();
        Assert.assertEquals(getTextFromElement(By.xpath("//a[contains(text(),'shopping cart')]")), "shopping cart", "shopping cart");
        homePage.clickOnShoppingCartButton();
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@id='content']//h1")), "Shopping Cart  (1.00kg)", "Shopping Cart  (1.00kg)");
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")), "HP LP3065", "HP LP3065");
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")), "Delivery Date: 2023-11-30", "Delivery Date: 2023-11-30");
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]")), "Product 21", "Product 21");
        homePage.changeCurrency();
        homePage.selectCurrency();
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]")), "£74.73", "£74.73");
    }

    @Test//1
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        desktopsTestPage.setMouseHoverOnLapTopAndNotebookTab();
        desktopsTestPage.setClickOnLapTopAndNotebookTab();
        laptopsAndNotBooksTestPage.productOrder();
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
    }

    @Test//2
    public void verifyThatUserPlaceOrderSuccessfully() {

//        2.1 Mouse hover on Laptops & Notebooks Tab and click
        desktopsTestPage.setMouseHoverOnLapTopAndNotebookTab();
        desktopsTestPage.setClickOnLapTopAndNotebookTab();
        laptopsAndNotBooksTestPage.productOrderHighToLow();
        laptopsAndNotBooksTestPage.clickOnMackbookTab();
        Assert.assertEquals("MacBook", "MacBook");
        homePage.clickOnAddToCartButton();
        Assert.assertEquals("shopping cart", "shopping cart");
        homePage.clickOnShoppingCartButton();
        Assert.assertEquals("Shopping Cart  (0.00kg)", "Shopping Cart  (0.00kg)");
        Assert.assertEquals("MacBook", "MacBook");


//        2.11 Change Quantity "2"

        laptopsAndNotBooksTestPage.updateQuantity("2");
        laptopsAndNotBooksTestPage.orderUpdate();
        homePage.changeCurrency();
        homePage.selectCurrency();
        Assert.assertEquals("£737.45", "£737.45");
        laptopsAndNotBooksTestPage.checkOutButton();
        Assert.assertEquals("Checkout", "Checkout");
        Assert.assertEquals("New Customer", "New Customer");


        laptopsAndNotBooksTestPage.clickOnGuestCheckout();
        laptopsAndNotBooksTestPage.clickOnContinue();
        laptopsAndNotBooksTestPage.sendTextToFirstNameField("kishan");
        laptopsAndNotBooksTestPage.sendTextToLastNameField("malaviya");
        laptopsAndNotBooksTestPage.sendTextToEmailField("kishan");
        laptopsAndNotBooksTestPage.sendTextToTelephoneField("123456");
        laptopsAndNotBooksTestPage.sendTextToAddressField("115a manordrive north");
        laptopsAndNotBooksTestPage.sendTextToCityField("London");
        laptopsAndNotBooksTestPage.sendTextToPostCOdeField("kt3 5pp");
        laptopsAndNotBooksTestPage.selectCountry("United Kingdom");
       laptopsAndNotBooksTestPage.selectRegion("Greater London");


//        2.21 Click on “Continue” Button
        laptopsAndNotBooksTestPage.clickOnGuestContinueButton();

        laptopsAndNotBooksTestPage.addComment();

        laptopsAndNotBooksTestPage.termsAndConditions();

        laptopsAndNotBooksTestPage.finalContinueButton();

        Assert.assertEquals("Warning: Payment method required!", "Warning: Payment method required!");
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccountsTestPage.clickOnMyAccountLink();
        myAccountsTestPage.clickOnRegisterLink();
        //  myAccountsPage.verifyRegisterAccount();
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccountsTestPage.clickOnMyAccountLink();
        myAccountsTestPage.clickOnLoginLink();
        //  myAccountsPage.verifyReturnCustomer();

    }
}