package og.example.PricingStrategy;

import og.example.cart.Product;

import java.util.Map;

public class ProfessionalPricingStrategy implements PricingStrategy {

    private final boolean isMajor;
    private static final long MAJOR_THRESHOLD = 10000000;

    public ProfessionalPricingStrategy(long revenue) {
        this.isMajor = revenue > MAJOR_THRESHOLD;
    }

    private static final Map<Product, Double> MAJOR_PRICE = Map.of(
            Product.HIGH_END_PHONE, 1000.0,
            Product.MID_RANGE_PHONE, 550.0,
            Product.LAPTOP, 900.0
    );

    private static final Map<Product, Double> SMALL_PRICE = Map.of(
            Product.HIGH_END_PHONE, 1150.0,
            Product.MID_RANGE_PHONE, 600.0,
            Product.LAPTOP, 1000.0
    );

    @Override
    public double getPrice(Product product) {
        return (isMajor ? MAJOR_PRICE : SMALL_PRICE).get(product);
    }
}
