package screens;

import dto.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class RegistrationScreen extends BaseScreen{
    public RegistrationScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\'com.telran.ilcarro:id/editRegName\']")
    WebElement inputName;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\'com.telran.ilcarro:id/editRegLastName\']")
    WebElement inputLastName;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\'com.telran.ilcarro:id/editRegEmail\']")
    WebElement inputEmail;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\'com.telran.ilcarro:id/editRegPassword\']")
    WebElement inputPassword;
    @AndroidFindBy(xpath = "//android.widget.CheckBox[@resource-id=\'com.telran.ilcarro:id/checkBoxAgree\']")
    WebElement checkBoxIAgree;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\'com.telran.ilcarro:id/regBtn\']")
    WebElement btnYalla;

    public void typeRegistrationForm(User user) {
        inputName.sendKeys(user.getFirstName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
    }

    public void clickCheckBoxIAgree() {
        checkBoxIAgree.click();
    }

    public void clickBtnYalla() {
        btnYalla.click();
    }
}
