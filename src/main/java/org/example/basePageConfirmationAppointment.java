package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class basePageConfirmationAppointment {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[contains(text(),'Go to Homepage')]")
    WebElement buttonGoHomePage;

    @FindBy(xpath = "//h2[contains(text(),'Appointment Confirmation')]")
    WebElement messageConfirmation;

    public basePageConfirmationAppointment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isAppointmentConfirmed() {
        return messageConfirmation.getText().equals("Appointment Confirmation");
    }

    public void buttomGoHomepage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", buttonGoHomePage);

        Actions actions = new Actions(driver);
        actions.moveToElement(buttonGoHomePage).click().perform();
    }


}
