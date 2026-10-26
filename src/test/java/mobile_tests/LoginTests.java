package mobile_tests;

import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ErrorScreen;
import screens.LoginScreen;
import screens.SearchScreen;
import screens.SplashScreen;
import static  utils.PropertiesReader.*;

public class LoginTests extends TestBase{
    SearchScreen searchScreen;
    LoginScreen loginScreen;
    User user;

    @BeforeMethod
    public void goToLoginScreen(){
        new SplashScreen(driver).goToSearchScreen();
        searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnLogin();
        loginScreen = new LoginScreen(driver);
        user = User.builder()
                .username(getProperty("base.properties","email"))
                .password(getProperty("base.properties","password"))
                .build();
    }

    @Test
    public  void loginPositiveTest(){
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnYallaLogin();
        Assert.assertTrue(searchScreen
                .validatePopUpLoginSuccess("Login success!"));
    }

    // HW 17_01
    @Test
    public void loginEmptyAllFieldsNegativeTest(){
        user.setUsername("");
        user.setPassword("");
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnYallaLogin();
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("All fields must be filled and agree terms"));
    }

    // HW 17_02
    @Test
    public void loginEmptyUsernameFieldNegativeTest(){
        user.setUsername("");
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnYallaLogin();
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("All fields must be filled and agree terms"));
    }

    // HW 17_03
    @Test
    public void loginEmptyPasswordFieldNegativeTest(){
        user.setPassword("");
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnYallaLogin();
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("All fields must be filled and agree terms"));
    }

    // HW 17_04
    @Test
    public void loginUnregisteredUserNegativeTest(){
        user.setUsername("reenatae_test_new@gmail.com");
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnYallaLogin();
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("Login or Password incorrect"));
    }


}
