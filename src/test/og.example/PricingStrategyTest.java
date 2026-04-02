package og.example;

import og.example.PricingStrategy.IndividualPricingStrategy;
import og.example.PricingStrategy.PricingStrategy;
import og.example.PricingStrategy.ProfessionalPricingStrategy;
import og.example.cart.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PricingStrategyTest {
    @Test
    void testIndividualPricingStrategy() {
        PricingStrategy strategy = new IndividualPricingStrategy();

        assertEquals(1500.0, strategy.getPrice(Product.HIGH_END_PHONE));
        assertEquals(800.0, strategy.getPrice(Product.MID_RANGE_PHONE));
        assertEquals(1200.0, strategy.getPrice(Product.LAPTOP));
    }

    @Test
    void testProfessionalMajorPricing() {
        PricingStrategy strategy = new ProfessionalPricingStrategy(15_000_000);

        assertEquals(1000.0, strategy.getPrice(Product.HIGH_END_PHONE));
    }

    @Test
    void testProfessionalSmallPricing() {
        PricingStrategy strategy = new ProfessionalPricingStrategy(5_000_000);

        assertEquals(1150.0, strategy.getPrice(Product.HIGH_END_PHONE));
    }
}

