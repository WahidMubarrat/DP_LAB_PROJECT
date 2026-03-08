package racing.car;

/**
 * Roadster - abstract sub-category of Car.
 * Porsche Boxster and Ferrari 812 belong to this category.
 */
public abstract class Roadster extends Car {

    @Override
    public String getCategory() {
        return "Roadster";
    }
}
