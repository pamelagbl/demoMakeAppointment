package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class basePageMakeAppointment {

    WebDriver driver;

    @FindBy(id = "btn-make-appointment")
    WebElement submitButton;

    public basePageMakeAppointment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickSubmit() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);

        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).click().perform();


    }

}
