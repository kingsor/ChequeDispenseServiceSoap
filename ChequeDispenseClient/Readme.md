# ChequeDispenseClient

This is a console app that use the SOAP Service

It includes the `ChequeDispenseService.cs` file generated from SpringSoap service.

That file contains different object.

The `ChequeDispenseServicePortClient` class is the client that exposes the proxy methods to call the Soap Service.

Here is an example to call `GetTransactionID` method on the service.


```csharp

var client = new ChequeDispenseServicePortClient();

var request = new GetTransactionIDRequest();

var detailsRequest = new TransactionIDDetailsRequestDTO
{
    CardMagData1 = "AAAA",
    CardMagData2 = "BBBB",
    CardMagData3 = "CCCC",
    EncryptedPinBlock = "1234"
};

request.DetailsRequest = detailsRequest;

var response = client.GetTransactionID(request);

var json = JsonConvert.SerializeObject(response, Formatting.Indented);

transactionID = response.DetailsResponse.TransactionID;

Console.WriteLine(json);

```

