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



}
