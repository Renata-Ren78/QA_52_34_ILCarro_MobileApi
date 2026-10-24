package mobile_tests;

import dto.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreen;
import static utils.UserFactory.*;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void registrationPositiveTest(){
        new SplashScreen(driver).goToSearchScreen();
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        RegistrationScreen registrationScreen =
                new RegistrationScreen(driver);
    }

    //HW_16
    @Test
    public void registrationWithUserPositiveTest(){
        User user = positiveUser();
        RegistrationScreen registrationScreen =
                new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(user);
        registrationScreen.clickCheckBoxIAgree();
        registrationScreen.clickBtnYalla();

    }
}


