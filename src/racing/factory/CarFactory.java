package racing.factory;

import racing.car.Car;

/*
  Abstract Factory Pattern - CarFactory interface.
  Concrete factories (CoupeFactory, RoadsterFactory) produce cars
  from their respective category.
 */
public interface CarFactory {

    /* Creates and returns a Car based on the player's numeric choice.
     */
    Car createCar(int choice);

    /** Displays the menu of cars available in this factory. */
    void printCarMenu();

  
    static CarFactory getCoupeFactory() {
        return new CoupeFactory();
    }

    static CarFactory getRoadsterFactory() {
        return new RoadsterFactory();
    }
}
