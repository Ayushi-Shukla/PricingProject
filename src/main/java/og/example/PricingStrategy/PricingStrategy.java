package og.example.PricingStrategy;

import og.example.cart.Product;

public interface PricingStrategy {
    double getPrice(Product product);
}
