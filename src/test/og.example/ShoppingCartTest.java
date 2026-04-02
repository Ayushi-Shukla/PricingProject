package og.example;


import og.example.PricingStrategy.IndividualPricingStrategy;
import og.example.PricingStrategy.PricingStrategy;
import og.example.PricingStrategy.PricingStrategyFactory;
import og.example.PricingStrategy.ProfessionalPricingStrategy;
import og.example.cart.Product;
import og.example.cart.ShoppingCart;
import og.example.client.Client;
import og.example.client.IndividualClient;
import og.example.client.ProfessionalClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void testIndividualClient() {
        Client client = new IndividualClient("1", "Ayushi", "Shukla");

        ShoppingCart cart = new ShoppingCart(client);
        cart.addProduct(Product.HIGH_END_PHONE, 1);
        cart.addProduct(Product.LAPTOP, 1);

        assertEquals(2700.0, cart.calculateTotal());
    }

    @Test
    void testMajorProfessionalClient() {
        Client client = new ProfessionalClient("2", "Capco", "VAT123", "REG123", 15000000);

        ShoppingCart cart = new ShoppingCart(client);
        cart.addProduct(Product.MID_RANGE_PHONE, 2);

        assertEquals(1100.0, cart.calculateTotal());
    }

    @Test
    void testSmallProfessionalClient() {
        Client client = new ProfessionalClient("3", "Startup", null, "REG456", 5000000);

        ShoppingCart cart = new ShoppingCart(client);
        cart.addProduct(Product.LAPTOP, 1);

        assertEquals(1000.0, cart.calculateTotal());
    }

    @Test
    void testInvalidQuantity() {
        Client client = new IndividualClient("1", "Ayushi", "Shukla");
        ShoppingCart cart = new ShoppingCart(client);

        assertThrows(IllegalArgumentException.class, () ->
                cart.addProduct(Product.LAPTOP, 0)
        );
    }

    @Test
    void testEmptyCart() {
        Client client = new IndividualClient("1", "Ayushi", "Shukla");
        ShoppingCart cart = new ShoppingCart(client);

        assertEquals(0.0, cart.calculateTotal());
    }

    @Test
    void testFactoryForIndividualClient() {
        Client client = new IndividualClient("1", "A", "B");

        PricingStrategy strategy = PricingStrategyFactory.getStrategy(client);

        assertTrue(strategy instanceof IndividualPricingStrategy);
    }

    @Test
    void testFactoryForProfessionalClient() {
        Client client = new ProfessionalClient("2", "Comp", "VAT", "REG", 20000000);

        PricingStrategy strategy = PricingStrategyFactory.getStrategy(client);

        assertTrue(strategy instanceof ProfessionalPricingStrategy);
    }
}