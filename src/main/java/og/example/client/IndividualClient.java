package og.example.client;

public record IndividualClient(
        String clientId,
        String firstName,
        String lastName
) implements Client {

    @Override
    public String getClientId() {
        return clientId;
    }
}
