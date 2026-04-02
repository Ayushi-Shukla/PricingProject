package og.example.cart;

import og.example.PricingStrategy.PricingStrategy;
import og.example.PricingStrategy.PricingStrategyFactory;
import og.example.client.Client;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private final Client client;
    private final Map<Product, Integer> items = new HashMap<>();

    public ShoppingCart(Client client) {
        this.client = client;
    }

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }
        items.merge(product, quantity, Integer::sum);
    }

    public double calculateTotal() {
        PricingStrategy strategy = PricingStrategyFactory.getStrategy(client);

        return items.entrySet().stream()
                .mapToDouble(entry ->
                        strategy.getPrice(entry.getKey()) * entry.getValue()
                )
                .sum();
    }
}

