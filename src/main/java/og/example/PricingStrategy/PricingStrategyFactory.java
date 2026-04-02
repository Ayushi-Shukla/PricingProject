package og.example.PricingStrategy;

import og.example.client.Client;
import og.example.client.IndividualClient;
import og.example.client.ProfessionalClient;
import og.example.exception.UnsupportedClientException;

public final class PricingStrategyFactory {

    private PricingStrategyFactory() {

    }

    public static PricingStrategy getStrategy(Client client) {
        if (client == null) {
            throw new UnsupportedClientException("Client cannot be null");
        }

        if (client instanceof ProfessionalClient professionalClient) {
            return new ProfessionalPricingStrategy(professionalClient.annualRevenue());
        }

        if (client instanceof IndividualClient) {
            return new IndividualPricingStrategy();
        }

        throw new UnsupportedClientException("Unsupported client type: " + client.getClass());
    }
}
