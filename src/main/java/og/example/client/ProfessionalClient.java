package og.example.client;

public record ProfessionalClient(
        String clientId,
        String companyName,
        String vatNumber,
        String registrationNumber,
        long annualRevenue
) implements Client {

    @Override
    public String getClientId() {
        return clientId;
    }
}
