package racing.car;

/**
 * Coupe - abstract sub-category of Car.
 * Toyota GR86 and Subaru BRZ belong to this category.
 */
public abstract class Coupe extends Car {

    @Override
    public String getCategory() {
        return "Coupe";
    }
}
