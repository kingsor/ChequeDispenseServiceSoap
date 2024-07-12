using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChequeDispenseClient
{
    internal class Program
    {
        private static string transactionID = string.Empty;

        static void Main(string[] args)
        {
            var client = new ChequeDispenseServicePortClient();

            TestGetTransactionID(client);

            TestValidateTransactionID(client);

            TestGetBookletDetails(client);

            TestPrintedBooklet(client);

            Console.ReadLine();
        }

        static void TestGetTransactionID(ChequeDispenseServicePortClient client)
        {
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
        }

        static void TestValidateTransactionID(ChequeDispenseServicePortClient client)
        {
            var request = new ValidateTransactionIDRequest();

            request.TransactionDetailsRequest = new ValidateTransactionIDRequestDTO
            {
                TransactionID = transactionID
            };

            var response = client.ValidateTransactionID(request);

            var json = JsonConvert.SerializeObject(response, Formatting.Indented);

            Console.WriteLine(json);

            request.TransactionDetailsRequest.TransactionID = "WrongTransactionID";

            response = client.ValidateTransactionID(request);

            json = JsonConvert.SerializeObject(response, Formatting.Indented);

            Console.WriteLine(json);
        }

        static void TestGetBookletDetails(ChequeDispenseServicePortClient client)
        {
            var request = new GetBookletDetailsRequest();

            request.BookletDetailsRequest = new BookletDetailsRequestDTO
            {
                TransactionID = transactionID,
                TransactionStatus = "ok",
                Account = "12345678",
                Otp = string.Empty
            };

            var response = client.GetBookletDetails(request);

            var json = JsonConvert.SerializeObject(response, Formatting.Indented);

            Console.WriteLine(json);
        }

        static void TestPrintedBooklet(ChequeDispenseServicePortClient client)
        {
            var request = new PrintedBookletRequest();

            request.PrintChequeDispenseRequest = new PrintChequeDispenseRequestDTO
            {
                TransactionID = transactionID,
                TransactionStatus = "delivered"
            };

            var response = client.PrintedBooklet(request);

            var json = JsonConvert.SerializeObject(response, Formatting.Indented);

            Console.WriteLine(json);
        }

    }
}
