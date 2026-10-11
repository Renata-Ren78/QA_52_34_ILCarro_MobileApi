package utils;


import dto.User;
import net.datafaker.Faker;

public class UserFactory {
    static Faker faker = new Faker();

//    public static void main(String[] args) {
//        String firstName = faker.name().firstName();
//        System.out.println(firstName);
//        String lastName = faker.name().lastName();
//        System.out.println(lastName);
//        String email = faker.internet().emailAddress();
//        System.out.println(email);
//    }

    public static User positiveUser(){
        User user = User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .username(faker.internet().emailAddress())
                .password("Wdgfhtyr1234!")
                .build();
        return user;
    }


}
