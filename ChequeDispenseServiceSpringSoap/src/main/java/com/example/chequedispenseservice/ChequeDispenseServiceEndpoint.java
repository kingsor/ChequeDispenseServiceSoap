package com.example.chequedispenseservice;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.wstutorial.ws.chequedispenseservice.*;


@Endpoint
public class ChequeDispenseServiceEndpoint {
    private static final String NAMESPACE_URI = "http://www.wstutorial.com/ws/ChequeDispenseService";

    // @SoapAction("http://www.wstutorial.com/ws/GetTransactionIDRequest")
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetTransactionIDRequest" )
	@ResponsePayload
	public GetTransactionIDResponse GetTransactionID(@RequestPayload GetTransactionIDRequest request)throws Exception  {
		
		TransactionIDDetailsRequestDTO detailsRequest = request.getDetailsRequest();

		var cardMagData1 = detailsRequest.getCardMagData1();

		// do something with data
		
		ObjectFactory factory = new ObjectFactory();
		GetTransactionIDResponse response = factory.createGetTransactionIDResponse();

		TransactionIDDetailsResponseDTO responseDetails = factory.createTransactionIDDetailsResponseDTO();
		responseDetails.setTransactionID("Trx-0005");
		responseDetails.setNumberOfAccounts(2);
		responseDetails.getAccounts().add("9435562");
		responseDetails.getAccounts().add("7739485");
		responseDetails.setTransactionStatus("ok");
		var error = new ErrorDTO();
		error.setErrorCode("0");
		error.setErrorDesc("SUCCESS");
		responseDetails.setError(error);

		response.setDetailsResponse(responseDetails);
		
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ValidateTransactionIDRequest" )
	@ResponsePayload
	public ValidateTransactionIDResponse ValidateTransactionID(@RequestPayload ValidateTransactionIDRequest request)throws Exception  {
		
		ValidateTransactionIDRequestDTO detailsRequest = request.getTransactionDetailsRequest();

		var transactionID = detailsRequest.getTransactionID();

		// validate TransactionID

		var trxStatus = "ok";

		if(!transactionID.equals("Trx-0005")) {
			trxStatus = "failed: unknown transactionid";
		}
		
		ObjectFactory factory = new ObjectFactory();
		ValidateTransactionIDResponse response = factory.createValidateTransactionIDResponse();

		ValidateTransactionIDResponseDTO responseDetails = factory.createValidateTransactionIDResponseDTO();

		responseDetails.setTransactionID(transactionID);
		responseDetails.setTransactionStatus(trxStatus);
		
		response.setTransactionDetailsResponse(responseDetails);
		
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBookletDetailsRequest" )
	@ResponsePayload
	public GetBookletDetailsResponse GetBookletDetails(@RequestPayload GetBookletDetailsRequest request)throws Exception  {
		
		BookletDetailsRequestDTO detailsRequest = request.getBookletDetailsRequest();

		var transactionID = detailsRequest.getTransactionID();
		var transactionStatus = detailsRequest.getTransactionStatus();
		var otp = detailsRequest.getOtp();
		var account = detailsRequest.getAccount();

		// do something with BookletDetails

		var trxStatus = "ok";

		if(!transactionID.equals("Trx-0005")) {
			trxStatus = "failed: unknown transactionid";
		}
		
		ObjectFactory factory = new ObjectFactory();
		GetBookletDetailsResponse response = factory.createGetBookletDetailsResponse();

		BookletDetailsResponseDTO responseDetails = factory.createBookletDetailsResponseDTO();

		responseDetails.setTransactionID(transactionID);
		responseDetails.setTransactionStatus(trxStatus);
		responseDetails.setAccountNumber(account);
		responseDetails.setBookletRequest("Comma separated list of parameters used by CHECKATMOS to print booklet");
		responseDetails.setSerialFrom("125");
		responseDetails.setSerialTo("134");
		
		response.setBookletDetailsResponse(responseDetails);
		
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PrintedBookletRequest" )
	@ResponsePayload
	public PrintedBookletResponse PrintedBooklet(@RequestPayload PrintedBookletRequest request)throws Exception  {
		
		PrintChequeDispenseRequestDTO detailsRequest = request.getPrintChequeDispenseRequest();

		var transactionID = detailsRequest.getTransactionID();
		var transactionStatus = detailsRequest.getTransactionStatus();

		// where transactionStatus can be:
		// "delivered" (if the user takes it)
		// "retracted" (if user fails to take it and it is retracted in the unit)
		// "aborted: cancelled by user" (if user cancels on OTP or choose account page or timeout elape in either of those pages)
		// "failed: printer jammed"
		// "failed: problem description text"

		// do something with BookletDetails

		var trxStatus = "ok";

		
		ObjectFactory factory = new ObjectFactory();
		PrintedBookletResponse response = factory.createPrintedBookletResponse();
		PrintChequeDispenseResponseDTO responseDetails = factory.createPrintChequeDispenseResponseDTO();
		responseDetails.setTransactionID(transactionID);
		responseDetails.setTransactionStatus(trxStatus);
		
		response.setPrintChequeDispenseResponse(responseDetails);
		
		return response;
	}


}
