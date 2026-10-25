package mobile_tests;

import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ErrorScreen;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreen;
import static utils.UserFactory.*;

public class RegistrationTests extends TestBase{
    SearchScreen searchScreen;
    RegistrationScreen registrationScreen;
    User user;


    @BeforeMethod
    public void goToRegistrationPositiveTest(){
        new SplashScreen(driver).goToSearchScreen();
        searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        registrationScreen = new RegistrationScreen(driver);
        user = positiveUser();
    }

    //HW_16
    @Test
    public void registrationWithUserPositiveTest(){

//        RegistrationScreen registrationScreen =
//                new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(user);
        registrationScreen.clickCheckBoxIAgree();
        registrationScreen.clickBtnYalla();
        Assert.assertTrue(searchScreen
                .validatePopUpRegistrationSuccess("Registration success!"));
    }

    @Test
    public void registrationEmptyFieldNameNegativeTest(){
        user.setFirstName("");
        registrationScreen.typeRegistrationForm(user);
        registrationScreen.clickCheckBoxIAgree();
        registrationScreen.clickBtnYalla();
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("All fields must be filled and agree terms"));

    }



}


