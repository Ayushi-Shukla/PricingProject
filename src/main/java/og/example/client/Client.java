package og.example.client;

public sealed interface Client
        permits IndividualClient, ProfessionalClient
{
    String getClientId();
}
