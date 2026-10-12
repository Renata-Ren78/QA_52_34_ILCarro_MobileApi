package api_rest_tests;

import controlers.AuthController;
import dto.TokenDto;
import dto.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesReader;

import static utils.UserFactory.*;

public class RegistrationLoginTests extends AuthController {
    @Test
    public void registrationPositiveTest(){
        User  user = positiveUser();
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL)
                .getStatusCode(),200);
    }

    // HW_15_01
    @Test
    public void registrationEmptyFirstNameNegativeTest(){
        User user = positiveUser();
        user.setFirstName("");
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL)
                .getStatusCode(),400);
    }

    // HW_15_02
    @Test
    public void registrationEmptyLastNameNegativeTest(){
        User user = positiveUser();
        user.setLastName("");
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL)
                .getStatusCode(),400);
    }

    // HW_15_03
    @Test
    public void registrationEmptyUsernameNegativeTest(){
        User user = positiveUser();
        user.setUsername("");
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL)
                .getStatusCode(),400);
    }

    // HW_15_04
    @Test
    public void registrationEmptyPasswordNegativeTest(){
        User user = positiveUser();
        user.setPassword("");
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL)
                .getStatusCode(),400);
    }

    // HW_15_05
    @Test
    public void registrationInvalidUsernameFormatNegativeTest(){
        User user = positiveUser();
        user.setUsername("retrs@@gmail.com");
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL)
                .getStatusCode(),400);
    }

    // HW_15_06
    @Test
    public void registrationInvalidPasswordTooShortNegativeTest(){
        User user = positiveUser();
        user.setPassword("Ab1@xy7");
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL)
                .getStatusCode(),400);
    }

    // HW_15_07
    @Test
    public void registrationInvalidPasswordWithoutDigitsNegativeTest(){
        User user = positiveUser();
        user.setPassword("Abs@xy!");
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL)
                .getStatusCode(),400);
    }

    // HW_15_08
    @Test
    public void registrationInvalidPasswordWithoutUppercaseNegativeTest(){
        User user = positiveUser();
        user.setPassword("abcdef1@");
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL)
                .getStatusCode(),400);
    }

    // HW_15_09
    @Test
    public void registrationInvalidPasswordWithoutLowercaseNegativeTest(){
        User user = positiveUser();
        user.setPassword("ASDFGH1@");
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL)
                .getStatusCode(),400);
    }

    // HW_15_10
    @Test
    public void registrationDuplicateUserNegativeTest() {
        User user = positiveUser();

        Response response = registrationLogin(user, REGISTRATION_URL);
        Assert.assertEquals(response.getStatusCode(), 200);

        Response responseDuplicate = registrationLogin(user, REGISTRATION_URL);

        System.out.println("Status code: " + responseDuplicate.getStatusCode());
        System.out.println("Response: " + responseDuplicate.asString());

        Assert.assertEquals(responseDuplicate.getStatusCode(), 400);
        Assert.assertTrue(responseDuplicate.asString().contains("User already exists"));
    }

    @Test
    public void loginPositiveTest(){
        User user = User.builder()
                .username(PropertiesReader.getProperty
                        ("base.properties","email"))
                .password(PropertiesReader.getProperty
                        ("base.properties","password"))
                .build();
        Response response = registrationLogin(user,LOGIN_URL);
//        System.out.println(response.getBody().asString());
//        TokenDto tokenDto = response.getBody().as(TokenDto.class);
//        System.out.println(tokenDto.getAccessToken());
        Assert.assertEquals(response.getStatusCode(),200);
    }

    // HW_15_11
    @Test
    public void loginEmptyUsernameNegativeTest(){
        User user = User.builder()
                .username("")
                .password(PropertiesReader.getProperty
                        ("base.properties","password"))
                .build();
        Response response = registrationLogin(user,LOGIN_URL);

        Assert.assertEquals(response.getStatusCode(),401);
    }

    // HW_15_12
    @Test
    public void loginUnregisteredUsernameNegativeTest(){
        User user = User.builder()
                .username("Metra@gmail.com")
                .password(PropertiesReader.getProperty
                        ("base.properties","password"))
                .build();
        Response response = registrationLogin(user,LOGIN_URL);

        Assert.assertEquals(response.getStatusCode(),401);
    }

    // HW_15_13
    @Test
    public void loginEmptyPasswordNegativeTest(){
        User user = User.builder()
                .username(PropertiesReader.getProperty
                        ("base.properties","email"))
                .password("")
                .build();
        Response response = registrationLogin(user,LOGIN_URL);

        Assert.assertEquals(response.getStatusCode(),401);
    }

    // HW_15_14
    @Test
    public void loginWrongPasswordNegativeTest(){
        User user = User.builder()
                .username(PropertiesReader.getProperty
                        ("base.properties","email"))
                .password("ren_CER$456")
                .build();
        Response response = registrationLogin(user,LOGIN_URL);

        Assert.assertEquals(response.getStatusCode(),401);
    }

}
