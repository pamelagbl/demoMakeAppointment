package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class basePageLogin {

    WebDriver driver;

    @FindBy(id = "txt-username")
    WebElement userNameField;

    @FindBy(id = "txt-password")
    WebElement userPassField;

    @FindBy(id = "btn-login")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id='login']/div/div/div[1]/p[2]")
    WebElement errorMessage;

    public basePageLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFullName(String username) {
        userNameField.sendKeys(username);
    }

    public void enterPassword(String email) {
        userPassField.sendKeys(email);
    }

    public void clickSubmit() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);

        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).click().perform();

    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }


}
