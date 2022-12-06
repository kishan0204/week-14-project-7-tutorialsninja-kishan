package com.tutorialsninja.sw.pages;


import com.tutorialsninja.sw.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotBooksTestPage extends Utility {

    By clickOnMackbookTab = By.linkText("MacBook");
    By orderUpdate = By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]");
    By updateCart = By.xpath("//input[contains(@name, 'quantity')]");
    By clearCart = By.xpath("//input[contains(@name, 'quantity')]");
    By checkOutButton = By.xpath("//a[contains(text(),'Checkout')]");
    By clickOnButton = By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]");
    By clickOnContinue = By.xpath("//input[@id='button-account']");
    By clickOnGuestCheckout = By.xpath("//input[@value='guest']");
    By firstName = By.xpath("//input[@id='input-payment-firstname']");
    By lastName = By.xpath("//input[@id='input-payment-lastname']");
    By email = By.xpath("//input[@id='input-payment-email']");
    By telephone = By.xpath("//input[@id='input-payment-telephone']");
    By address = By.xpath("//input[@id='input-payment-address-1']");
    By city = By.xpath("//input[@id='input-payment-city']");
    By postcode = By.xpath("//input[@id='input-payment-postcode']");
    By country = By.xpath("//select[@id='input-payment-country']");
    By region = By.xpath("//select[@id='input-payment-zone']");
    By guestContinueButton = By.cssSelector("#button-guest");
    By termsAndConditions = By.xpath("//input[@name='agree']");
    By addComment = By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]");
    By finalContinueButton = By.xpath("//input[@id='button-payment-method']");
    By quantityField = (By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[4]/div/input"));
    By updateQty = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[4]/div/span/button[1]");

    public void updateQuantity(String qty) {
        //clearTextFromElement(quantityField);
        sendTextToElement(quantityField, qty);
        clickOnElement(updateQty);
    }

    public void finalContinueButton(){
        clickOnElement(finalContinueButton);
    }

    public void addComment(){
        sendTextToElement(addComment,"Can I have delivery before 3PM");
    }
    public void termsAndConditions(){
        clickOnElement(termsAndConditions);
    }

    public void clickOnGuestCheckout(){
        clickOnElement(clickOnGuestCheckout);
    }

    public void clickOnContinue(){
        clickOnElement(clickOnContinue);
    }
    public void clickOnButton(){
        clickOnElement(clickOnButton);
    }

    public void checkOutButton(){
        clickOnElement(checkOutButton);
    }

    public void orderUpdate(){
        clickOnElement(orderUpdate);
    }
    public void updateCart(String item){
        sendTextToElement(updateCart,"2");
    }


    public void productOrderHighToLow(){
        Select productOrder = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        productOrder.selectByIndex(3);
    }

    public void productOrder(){
        Select productOrder = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        productOrder.selectByIndex(4);}

    public void highToLowSelection() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
    }
    public void clickOnMackbookTab(){
        clickOnElement(clickOnMackbookTab);
    }
    public void sendTextToFirstNameField(String fName) {
        sendTextToElement(firstName, fName + getAlphaNumericString(2));
    }

    public void sendTextToLastNameField(String lname) {
        sendTextToElement(lastName, lname + getAlphaNumericString(2));
    }

    public void sendTextToEmailField(String uEmail) {
        sendTextToElement(email, uEmail + getAlphaNumericString(2) + "@gmail.com");
    }

    public void sendTextToTelephoneField(String tele) {
        sendTextToElement(telephone, tele);
    }

    public void sendTextToAddressField(String add) {
        sendTextToElement(address, add);
    }

    public void sendTextToCityField(String uCty) {
        sendTextToElement(city, uCty);
    }
    public void sendTextToPostCOdeField(String pCode) {
        sendTextToElement(postcode, pCode + getAlphaNumericString(1));
    }

    public void selectCountry(String uCountry) {
        selectByVisibleTextFromDropDown(country, uCountry);
    }

    public void selectRegion(String uRegion) {
        selectByVisibleTextFromDropDown(region, uRegion);
    }

    public void clickOnGuestContinueButton() {
        clickOnElement(guestContinueButton);
    }
}
