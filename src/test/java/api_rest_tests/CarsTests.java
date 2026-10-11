package api_rest_tests;

import controlers.CarController;
import dto.Car;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CarFactory;

public class CarsTests extends CarController {

    @Test
    public void addNewCarPositiveTest(){
        Car car = CarFactory.positiveCar();

        Assert.assertEquals(addNewCar(car).getStatusCode(),200);

    }

    @Test
    public void addNewCarPositiveTest3() {
        Car car = CarFactory.positiveCar();

        var response = addNewCar(car);
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void addNewCarPositiveTest2() {
        Car car = CarFactory.positiveCar();

        var response = addNewCar(car);

        int statusCode = response.getStatusCode();

        System.out.println("Status code: " + statusCode);
        System.out.println("Response body: " + response.getBody().asString());

        Assert.assertEquals(statusCode, 200);
    }


}
