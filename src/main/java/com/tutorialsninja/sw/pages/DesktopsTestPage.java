package com.tutorialsninja.sw.pages;

import com.tutorialsninja.sw.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DesktopsTestPage extends Utility {
    By mouseHoverOnLapTopAndNotebookTab = By.linkText("Laptops & Notebooks");
    By clickOnLapTopAndNotebookTab = By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]");
    By mouseHoverOnComponentTab = By.linkText("Components");
    By clickOnAllComponentTab = By.linkText("Show All Components");



    public void selectByAtoZ(){
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (A - Z)");


    }


    public void selectByIndex() {
        Select productOrder = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        productOrder.selectByIndex(2);
    }

    public void setMouseHoverOnLapTopAndNotebookTab(){
        clickOnElement(mouseHoverOnLapTopAndNotebookTab);
    }
    public void setClickOnLapTopAndNotebookTab(){
        clickOnElement(clickOnLapTopAndNotebookTab);
    }
    public void setMouseHoverOnComponentTab(){
        clickOnElement(mouseHoverOnComponentTab);
    }
    public void setClickOnAllComponentTab(){
        clickOnElement(clickOnAllComponentTab);
    }
    public void dateSelection(){
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }

    }
}
