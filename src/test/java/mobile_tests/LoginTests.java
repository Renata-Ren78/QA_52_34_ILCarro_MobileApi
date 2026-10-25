package mobile_tests;

import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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


}
