# ChequeDispenseService

This is a SOAP Service prototype created from a WSDL file

The service is created with Spring Boot using Spring-WS.


## WSDL First Code Generation

The classes related to methods and parameters of the SOAP Service are generated using the `jaxb2-maven-plugin` plugin.

Here is the content of `plugin` section in `pom.xml` file:

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>jaxb2-maven-plugin</artifactId>
    <version>3.2.0</version>
    <executions>
        <execution>
            <id>xjc</id>
            <goals>
                <goal>xjc</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <!-- <outputDirectory>${project.basedir}/src/main/java</outputDirectory> -->
        <arguments>
            <argument>-verbose</argument>
        </arguments>
        <sources>
            <source>${project.basedir}/src/main/resources/schema/ChequeDispenseService.xsd</source>
        </sources>
    </configuration>
</plugin>

```

And the code is generated from the service schema in `ChequeDispenseService.xsd` file.

```xml
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" 
            xmlns:tns="http://www.wstutorial.com/ws/ChequeDispenseService" 
            targetNamespace="http://www.wstutorial.com/ws/ChequeDispenseService"
            elementFormDefault="qualified">
    <xs:element name="GetTransactionIDRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element minOccurs="0" maxOccurs="1" name="DetailsRequest" type="tns:TransactionIDDetailsRequestDTO"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
    <xs:complexType name="TransactionIDDetailsRequestDTO">
        <xs:sequence>
            <xs:element minOccurs="0" maxOccurs="1" name="CardMagData1" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="CardMagData2" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="CardMagData3" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="EncryptedPinBlock" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
    <xs:element name="GetTransactionIDResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element minOccurs="0" maxOccurs="1" name="DetailsResponse" type="tns:TransactionIDDetailsResponseDTO"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
    <xs:complexType name="TransactionIDDetailsResponseDTO">
        <xs:sequence>
            <xs:element minOccurs="0" maxOccurs="1" name="TransactionStatus" type="xs:string"/>
            <xs:element minOccurs="1" maxOccurs="1" name="NumberOfAccounts" type="xs:int"/>
            <xs:element minOccurs="0" maxOccurs="unbounded" name="Accounts" nillable="true" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="TransactionID" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="Error" type="tns:ErrorDTO"/>
        </xs:sequence>
    </xs:complexType>
    <xs:complexType name="ErrorDTO">
        <xs:sequence>
            <xs:element minOccurs="0" maxOccurs="1" name="errorCode" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="errorDesc" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
    <xs:element name="PrintedBookletRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element minOccurs="0" maxOccurs="1" name="PrintChequeDispenseRequest" type="tns:PrintChequeDispenseRequestDTO"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
    <xs:complexType name="PrintChequeDispenseRequestDTO">
        <xs:sequence>
            <xs:element minOccurs="0" maxOccurs="1" name="TransactionStatus" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="TransactionID" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
    <xs:element name="PrintedBookletResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element minOccurs="0" maxOccurs="1" name="PrintChequeDispenseResponse" type="tns:PrintChequeDispenseResponseDTO"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
    <xs:complexType name="PrintChequeDispenseResponseDTO">
        <xs:sequence>
            <xs:element minOccurs="0" maxOccurs="1" name="TransactionStatus" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="TransactionID" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
    <xs:element name="GetBookletDetailsRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element minOccurs="0" maxOccurs="1" name="BookletDetailsRequest" type="tns:BookletDetailsRequestDTO"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
    <xs:complexType name="BookletDetailsRequestDTO">
        <xs:sequence>
            <xs:element minOccurs="0" maxOccurs="1" name="Account" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="TransactionStatus" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="TransactionID" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="Otp" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
    <xs:element name="GetBookletDetailsResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element minOccurs="0" maxOccurs="1" name="BookletDetailsResponse" type="tns:BookletDetailsResponseDTO"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
    <xs:complexType name="BookletDetailsResponseDTO">
        <xs:sequence>
            <xs:element minOccurs="0" maxOccurs="1" name="TransactionStatus" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="TransactionID" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="AccountNumber" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="BookletRequest" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="SerialFrom" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="SerialTo" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
    <xs:element name="ValidateTransactionIDRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element minOccurs="0" maxOccurs="1" name="TransactionDetailsRequest" type="tns:ValidateTransactionIDRequestDTO"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
    <xs:complexType name="ValidateTransactionIDRequestDTO">
        <xs:sequence>
            <xs:element minOccurs="0" maxOccurs="1" name="TransactionID" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
    <xs:element name="ValidateTransactionIDResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element minOccurs="0" maxOccurs="1" name="TransactionDetailsResponse" type="tns:ValidateTransactionIDResponseDTO"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
    <xs:complexType name="ValidateTransactionIDResponseDTO">
        <xs:sequence>
            <xs:element minOccurs="0" maxOccurs="1" name="TransactionID" type="xs:string"/>
            <xs:element minOccurs="0" maxOccurs="1" name="TransactionStatus" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
</xs:schema>

```

## Service Endpoints


In `ChequeDispenseServiceEndpoint.java` are defined the four methods exposed by the service.


Here is a part of that file.


```java

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

	// other methods are in the file

}

```


## WSDL Exposed

This is the WSDL content exposed by the service.

```xml

<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<wsdl:definitions
	xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
	xmlns:sch="http://www.wstutorial.com/ws/ChequeDispenseService"
	xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
	xmlns:tns="http://www.wstutorial.com/ws/ChequeDispenseService" targetNamespace="http://www.wstutorial.com/ws/ChequeDispenseService">
	<wsdl:types>
		<xs:schema
			xmlns:xs="http://www.w3.org/2001/XMLSchema" elementFormDefault="qualified" targetNamespace="http://www.wstutorial.com/ws/ChequeDispenseService">
			<xs:element name="GetTransactionIDRequest">
				<xs:complexType>
					<xs:sequence>
						<xs:element maxOccurs="1" minOccurs="0" name="DetailsRequest" type="tns:TransactionIDDetailsRequestDTO"/>
					</xs:sequence>
				</xs:complexType>
			</xs:element>
			<xs:complexType name="TransactionIDDetailsRequestDTO">
				<xs:sequence>
					<xs:element maxOccurs="1" minOccurs="0" name="CardMagData1" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="CardMagData2" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="CardMagData3" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="EncryptedPinBlock" type="xs:string"/>
				</xs:sequence>
			</xs:complexType>
			<xs:element name="GetTransactionIDResponse">
				<xs:complexType>
					<xs:sequence>
						<xs:element maxOccurs="1" minOccurs="0" name="DetailsResponse" type="tns:TransactionIDDetailsResponseDTO"/>
					</xs:sequence>
				</xs:complexType>
			</xs:element>
			<xs:complexType name="TransactionIDDetailsResponseDTO">
				<xs:sequence>
					<xs:element maxOccurs="1" minOccurs="0" name="TransactionStatus" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="1" name="NumberOfAccounts" type="xs:int"/>
					<xs:element maxOccurs="unbounded" minOccurs="0" name="Accounts" nillable="true" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="TransactionID" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="Error" type="tns:ErrorDTO"/>
				</xs:sequence>
			</xs:complexType>
			<xs:complexType name="ErrorDTO">
				<xs:sequence>
					<xs:element maxOccurs="1" minOccurs="0" name="errorCode" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="errorDesc" type="xs:string"/>
				</xs:sequence>
			</xs:complexType>
			<xs:element name="PrintedBookletRequest">
				<xs:complexType>
					<xs:sequence>
						<xs:element maxOccurs="1" minOccurs="0" name="PrintChequeDispenseRequest" type="tns:PrintChequeDispenseRequestDTO"/>
					</xs:sequence>
				</xs:complexType>
			</xs:element>
			<xs:complexType name="PrintChequeDispenseRequestDTO">
				<xs:sequence>
					<xs:element maxOccurs="1" minOccurs="0" name="TransactionStatus" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="TransactionID" type="xs:string"/>
				</xs:sequence>
			</xs:complexType>
			<xs:element name="PrintedBookletResponse">
				<xs:complexType>
					<xs:sequence>
						<xs:element maxOccurs="1" minOccurs="0" name="PrintChequeDispenseResponse" type="tns:PrintChequeDispenseResponseDTO"/>
					</xs:sequence>
				</xs:complexType>
			</xs:element>
			<xs:complexType name="PrintChequeDispenseResponseDTO">
				<xs:sequence>
					<xs:element maxOccurs="1" minOccurs="0" name="TransactionStatus" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="TransactionID" type="xs:string"/>
				</xs:sequence>
			</xs:complexType>
			<xs:element name="GetBookletDetailsRequest">
				<xs:complexType>
					<xs:sequence>
						<xs:element maxOccurs="1" minOccurs="0" name="BookletDetailsRequest" type="tns:BookletDetailsRequestDTO"/>
					</xs:sequence>
				</xs:complexType>
			</xs:element>
			<xs:complexType name="BookletDetailsRequestDTO">
				<xs:sequence>
					<xs:element maxOccurs="1" minOccurs="0" name="Account" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="TransactionStatus" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="TransactionID" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="Otp" type="xs:string"/>
				</xs:sequence>
			</xs:complexType>
			<xs:element name="GetBookletDetailsResponse">
				<xs:complexType>
					<xs:sequence>
						<xs:element maxOccurs="1" minOccurs="0" name="BookletDetailsResponse" type="tns:BookletDetailsResponseDTO"/>
					</xs:sequence>
				</xs:complexType>
			</xs:element>
			<xs:complexType name="BookletDetailsResponseDTO">
				<xs:sequence>
					<xs:element maxOccurs="1" minOccurs="0" name="TransactionStatus" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="TransactionID" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="AccountNumber" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="BookletRequest" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="SerialFrom" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="SerialTo" type="xs:string"/>
				</xs:sequence>
			</xs:complexType>
			<xs:element name="ValidateTransactionIDRequest">
				<xs:complexType>
					<xs:sequence>
						<xs:element maxOccurs="1" minOccurs="0" name="TransactionDetailsRequest" type="tns:ValidateTransactionIDRequestDTO"/>
					</xs:sequence>
				</xs:complexType>
			</xs:element>
			<xs:complexType name="ValidateTransactionIDRequestDTO">
				<xs:sequence>
					<xs:element maxOccurs="1" minOccurs="0" name="TransactionID" type="xs:string"/>
				</xs:sequence>
			</xs:complexType>
			<xs:element name="ValidateTransactionIDResponse">
				<xs:complexType>
					<xs:sequence>
						<xs:element maxOccurs="1" minOccurs="0" name="TransactionDetailsResponse" type="tns:ValidateTransactionIDResponseDTO"/>
					</xs:sequence>
				</xs:complexType>
			</xs:element>
			<xs:complexType name="ValidateTransactionIDResponseDTO">
				<xs:sequence>
					<xs:element maxOccurs="1" minOccurs="0" name="TransactionID" type="xs:string"/>
					<xs:element maxOccurs="1" minOccurs="0" name="TransactionStatus" type="xs:string"/>
				</xs:sequence>
			</xs:complexType>
		</xs:schema>
	</wsdl:types>
	<wsdl:message name="GetTransactionIDResponse">
		<wsdl:part element="tns:GetTransactionIDResponse" name="GetTransactionIDResponse"></wsdl:part>
	</wsdl:message>
	<wsdl:message name="PrintedBookletResponse">
		<wsdl:part element="tns:PrintedBookletResponse" name="PrintedBookletResponse"></wsdl:part>
	</wsdl:message>
	<wsdl:message name="PrintedBookletRequest">
		<wsdl:part element="tns:PrintedBookletRequest" name="PrintedBookletRequest"></wsdl:part>
	</wsdl:message>
	<wsdl:message name="ValidateTransactionIDRequest">
		<wsdl:part element="tns:ValidateTransactionIDRequest" name="ValidateTransactionIDRequest"></wsdl:part>
	</wsdl:message>
	<wsdl:message name="ValidateTransactionIDResponse">
		<wsdl:part element="tns:ValidateTransactionIDResponse" name="ValidateTransactionIDResponse"></wsdl:part>
	</wsdl:message>
	<wsdl:message name="GetTransactionIDRequest">
		<wsdl:part element="tns:GetTransactionIDRequest" name="GetTransactionIDRequest"></wsdl:part>
	</wsdl:message>
	<wsdl:message name="GetBookletDetailsRequest">
		<wsdl:part element="tns:GetBookletDetailsRequest" name="GetBookletDetailsRequest"></wsdl:part>
	</wsdl:message>
	<wsdl:message name="GetBookletDetailsResponse">
		<wsdl:part element="tns:GetBookletDetailsResponse" name="GetBookletDetailsResponse"></wsdl:part>
	</wsdl:message>
	<wsdl:portType name="ChequeDispenseServicePort">
		<wsdl:operation name="GetTransactionID">
			<wsdl:input message="tns:GetTransactionIDRequest" name="GetTransactionIDRequest"></wsdl:input>
			<wsdl:output message="tns:GetTransactionIDResponse" name="GetTransactionIDResponse"></wsdl:output>
		</wsdl:operation>
		<wsdl:operation name="PrintedBooklet">
			<wsdl:input message="tns:PrintedBookletRequest" name="PrintedBookletRequest"></wsdl:input>
			<wsdl:output message="tns:PrintedBookletResponse" name="PrintedBookletResponse"></wsdl:output>
		</wsdl:operation>
		<wsdl:operation name="ValidateTransactionID">
			<wsdl:input message="tns:ValidateTransactionIDRequest" name="ValidateTransactionIDRequest"></wsdl:input>
			<wsdl:output message="tns:ValidateTransactionIDResponse" name="ValidateTransactionIDResponse"></wsdl:output>
		</wsdl:operation>
		<wsdl:operation name="GetBookletDetails">
			<wsdl:input message="tns:GetBookletDetailsRequest" name="GetBookletDetailsRequest"></wsdl:input>
			<wsdl:output message="tns:GetBookletDetailsResponse" name="GetBookletDetailsResponse"></wsdl:output>
		</wsdl:operation>
	</wsdl:portType>
	<wsdl:binding name="ChequeDispenseServicePortSoap11" type="tns:ChequeDispenseServicePort">
		<soap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"/>
		<wsdl:operation name="GetTransactionID">
			<soap:operation soapAction=""/>
			<wsdl:input name="GetTransactionIDRequest">
				<soap:body use="literal"/>
			</wsdl:input>
			<wsdl:output name="GetTransactionIDResponse">
				<soap:body use="literal"/>
			</wsdl:output>
		</wsdl:operation>
		<wsdl:operation name="PrintedBooklet">
			<soap:operation soapAction=""/>
			<wsdl:input name="PrintedBookletRequest">
				<soap:body use="literal"/>
			</wsdl:input>
			<wsdl:output name="PrintedBookletResponse">
				<soap:body use="literal"/>
			</wsdl:output>
		</wsdl:operation>
		<wsdl:operation name="ValidateTransactionID">
			<soap:operation soapAction=""/>
			<wsdl:input name="ValidateTransactionIDRequest">
				<soap:body use="literal"/>
			</wsdl:input>
			<wsdl:output name="ValidateTransactionIDResponse">
				<soap:body use="literal"/>
			</wsdl:output>
		</wsdl:operation>
		<wsdl:operation name="GetBookletDetails">
			<soap:operation soapAction=""/>
			<wsdl:input name="GetBookletDetailsRequest">
				<soap:body use="literal"/>
			</wsdl:input>
			<wsdl:output name="GetBookletDetailsResponse">
				<soap:body use="literal"/>
			</wsdl:output>
		</wsdl:operation>
	</wsdl:binding>
	<wsdl:service name="ChequeDispenseService">
		<wsdl:port binding="tns:ChequeDispenseServicePortSoap11" name="ChequeDispenseServicePortSoap11">
			<soap:address location="http://localhost:8080/ws"/>
		</wsdl:port>
	</wsdl:service>
</wsdl:definitions>


```



## References

- [Soap with Spring boot - WSDL First](https://wstutorial.com/ws/soap-spring-boot-wsdl.html)
- [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service)
- [Developing SOAP Web Services with Spring Boot: A Comprehensive Guide](https://medium.com/@extio/developing-soap-web-services-with-spring-boot-a-comprehensive-guide-1d4f89bc3127)
- [Spring Initializr](https://start.spring.io/)

