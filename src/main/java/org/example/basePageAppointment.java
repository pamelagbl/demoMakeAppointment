package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class basePageAppointment {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "combo_facility")
    WebElement inputSelectFacility;

    @FindBy(xpath = "//*[@id='combo_facility']/option[1]")
    WebElement option1;

    @FindBy(xpath = "//*[@id='combo_facility']/option[2]")
    WebElement option2;

    @FindBy(xpath = "//*[@id='combo_facility']/option[3]")
    WebElement option3;

    @FindBy(id = "radio_program_medicare")
    WebElement radioButtomMedicare;

    @FindBy(id = "radio_program_medicaid")
    WebElement radioButtomMedicaid;

    @FindBy(id = "radio_program_none")
    WebElement radioButtomNone;

    @FindBy(id = "txt_visit_date")
    WebElement inputDate;

    @FindBy(id = "txt_comment")
    WebElement comment;

    @FindBy(id = "btn-book-appointment")
    WebElement buttonAppointment;


    public basePageAppointment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Métodos para campo select

    public void setSelectOption(String value) {
        Select select = new Select(inputSelectFacility);
        select.selectByValue(value);
    }

    public String getSelectOption() {
        Select select = new Select(inputSelectFacility);
        return select.getFirstSelectedOption().getText();
    }


    // Métodos radio buttom

    public void setRadioButtomMedicareRadio() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", radioButtomMedicare);

        Actions actions = new Actions(driver);
        actions.moveToElement(radioButtomMedicare).click().perform();
    }

    public void setRadioButtomMedicaid() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", radioButtomMedicaid);

        Actions actions = new Actions(driver);
        actions.moveToElement(radioButtomMedicaid).click().perform();
    }

    public void setRadioButtomNone() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", radioButtomNone);

        Actions actions = new Actions(driver);
        actions.moveToElement(radioButtomNone).click().perform();
    }

    public boolean isMedicareProgramSelected() {
        return radioButtomMedicare.isSelected();
    }

    public boolean isMedicaidProgramSelected() {
        return radioButtomMedicaid.isSelected();
    }

    public boolean isNoneProgramSelected() {
        return radioButtomNone.isSelected();
    }


    // Método para campo fecha

    public void enterDate(String date) {
        wait.until(ExpectedConditions.visibilityOf(inputDate));
        inputDate.clear();
        inputDate.sendKeys(date);
    }

    public boolean requireDatePicker() {
        return inputDate.getAttribute("required") != null;
    }

    // Método para comment

    public void enterComment(String comentarios) {
        comment.sendKeys(comentarios);
    }

    public void setButtonAppointment() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", buttonAppointment);

        Actions actions = new Actions(driver);
        actions.moveToElement(buttonAppointment).click().perform();
    }


}
