package og.example.PricingStrategy;

import og.example.cart.Product;

import java.util.Map;

public class IndividualPricingStrategy implements PricingStrategy {

    private static final Map<Product, Double> PRICE_MAP = Map.of(
            Product.HIGH_END_PHONE, 1500.0,
            Product.MID_RANGE_PHONE, 800.0,
            Product.LAPTOP, 1200.0
    );

    @Override
    public double getPrice(Product product) {
        return PRICE_MAP.get(product);
    }
}

