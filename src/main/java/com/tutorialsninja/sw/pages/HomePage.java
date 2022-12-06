package com.tutorialsninja.sw.pages;

import com.tutorialsninja.sw.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {

    By mouseHoverAndClick = By.linkText("Desktops");
    By clickOnShowDesktopButton = By.xpath("//a[contains(text(),'Show All Desktops')]");
    By clickOnShowAllDesktopButton = By.xpath("//a[contains(text(),'Show All Desktops')]");
    By clickOnContentButton = By.xpath("//a[contains(text(),'HP LP3065')]");
    By clickOnAddToCartButton = By.xpath("//button[@id='button-cart']");
    By clickOnShoppingCartButton = By.xpath("//a[contains(text(),'shopping cart')]");
    By changeCurrency = By.xpath("//span[contains(text(),'Currency')]");
    By selectCurrency = By.xpath("//button[contains(text(),'£ Pound Sterling')]");




    public void mouseHoverAndClick() {
        clickOnElement(mouseHoverAndClick);
    }

    public void clickOnShowDesktopButton() {
        clickOnElement(clickOnShowDesktopButton);
    }
    public void clickOnContentButton(By xpath){
        clickOnElement(clickOnContentButton);
    }
    public void clickOnShowAllDesktopButton() {
        clickOnElement(clickOnShowAllDesktopButton);
    }
    public void clickOnAddToCartButton(){
        clickOnElement(clickOnAddToCartButton);
    }
    public void clickOnShoppingCartButton(){
        clickOnElement(clickOnShoppingCartButton);
    }
    public void changeCurrency(){
        clickOnElement(changeCurrency);
    }
    public void selectCurrency(){
        clickOnElement(selectCurrency);
    }
}


