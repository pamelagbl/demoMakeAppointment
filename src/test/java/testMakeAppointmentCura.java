import org.example.basePageMakeAppointment;
import org.example.basePageLogin;
import org.example.basePageAppointment;
import org.example.basePageLogout;
import org.example.basePageConfirmationAppointment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class testMakeAppointmentCura {
    WebDriver driver;
    WebDriverWait wait;
    basePageMakeAppointment basePageMakeAppointment;
    basePageLogin basePageLogin;
    basePageAppointment basePageAppointment;
    basePageLogout basePageLogout;
    basePageConfirmationAppointment basePageConfirmartionAppointment;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        basePageLogin = new basePageLogin(driver);
        basePageAppointment = new basePageAppointment(driver);
        basePageMakeAppointment = new basePageMakeAppointment(driver);
        basePageLogout = new basePageLogout(driver);
        basePageConfirmartionAppointment = new basePageConfirmationAppointment(driver);

    }

    @Test
    public void testValidateLogin() {
        basePageMakeAppointment.clickSubmit();
        String fullName = "Invalid";
        String password = "ThisIsNotAPassword";
        String message = "Login failed! Please ensure the username and password are valid.";

        basePageLogin.enterFullName(fullName);
        basePageLogin.enterPassword(password);
        basePageLogin.clickSubmit();

        Assert.assertEquals(basePageLogin.getErrorMessage(), message);

    }

    @Test
    public void makeAppointment() throws InterruptedException {
        basePageMakeAppointment.clickSubmit();
        String fullName = "John Doe";
        String password = "ThisIsNotAPassword";
        String comentarioForm = "Esto es un comentario global";

        basePageLogin.enterFullName(fullName);
        basePageLogin.enterPassword(password);
        basePageLogin.clickSubmit();


        basePageAppointment.setSelectOption("Seoul CURA Healthcare Center");
        basePageAppointment.setRadioButtomMedicaid();
        basePageAppointment.enterDate("02/08/2024");
        basePageAppointment.enterComment(comentarioForm);
        basePageAppointment.setButtonAppointment();

        basePageConfirmartionAppointment.isAppointmentConfirmed();
        Assert.assertTrue(basePageConfirmartionAppointment.isAppointmentConfirmed(), "Appointment confirmation failed.");

        basePageConfirmartionAppointment.buttomGoHomepage();

    }

    @Test
    public void testValidateSelectOptions() {
        basePageMakeAppointment.clickSubmit();
        String fullName = "John Doe";
        String password = "ThisIsNotAPassword";
        String comentarioForm = "Esto es un comentario global";
        basePageLogin.enterFullName(fullName);
        basePageLogin.enterPassword(password);
        basePageLogin.clickSubmit();

        basePageAppointment.setSelectOption("Seoul CURA Healthcare Center");
        Assert.assertEquals(basePageAppointment.getSelectOption(), "Tokyo CURA Healthcare Center");
    }

    @Test
    public void testValidateDatePicker() {
        basePageMakeAppointment.clickSubmit();
        String fullName = "John Doe";
        String password = "ThisIsNotAPassword";
        String comentarioForm = "Esto es un comentario global";
        basePageLogin.enterFullName(fullName);
        basePageLogin.enterPassword(password);
        basePageLogin.clickSubmit();

        basePageAppointment.setSelectOption("Seoul CURA Healthcare Center");
        basePageAppointment.setRadioButtomMedicaid();
        basePageAppointment.enterDate("");
        basePageAppointment.enterComment(comentarioForm);
        basePageAppointment.setButtonAppointment();

        boolean isRequired = basePageAppointment.requireDatePicker();
        Assert.assertTrue(isRequired, "El campo datepicker es obligatorio.");
    }

    @Test
    public void testValidateRadioButtom() {
        basePageMakeAppointment.clickSubmit();
        String fullName = "John Doe";
        String password = "ThisIsNotAPassword";
        String comentarioForm = "Esto es un comentario global";
        basePageLogin.enterFullName(fullName);
        basePageLogin.enterPassword(password);
        basePageLogin.clickSubmit();

        basePageAppointment.setRadioButtomMedicareRadio();
        Assert.assertTrue(basePageAppointment.isMedicareProgramSelected());
        System.out.println("Aserción completada. La respuesta obtenida es la deseada");

        basePageAppointment.setRadioButtomMedicaid();
        Assert.assertTrue(basePageAppointment.isMedicaidProgramSelected());
        System.out.println("Aserción completada. La respuesta obtenida es la deseada");

        basePageAppointment.setRadioButtomNone();
        Assert.assertTrue(basePageAppointment.isNoneProgramSelected());
        System.out.println("Aserción completada. La respuesta obtenida es la deseada");
    }

    @Test
    public void testValidateLogout() {
        basePageMakeAppointment.clickSubmit();
        String fullName = "John Doe";
        String password = "ThisIsNotAPassword";
        String comentarioForm = "Esto es un comentario global";
        basePageLogin.enterFullName(fullName);
        basePageLogin.enterPassword(password);
        basePageLogin.clickSubmit();

        basePageAppointment.setSelectOption("Seoul CURA Healthcare Center");
        basePageAppointment.setRadioButtomMedicaid();
        basePageAppointment.enterDate("05/08/2024");
        basePageAppointment.enterComment(comentarioForm);
        basePageAppointment.setButtonAppointment();

        basePageLogout.setLogout();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
