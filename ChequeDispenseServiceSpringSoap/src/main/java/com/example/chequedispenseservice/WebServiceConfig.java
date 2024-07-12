package com.example.chequedispenseservice;

import java.util.Properties;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

	// @Bean(name="tutorialService")
	// public Wsdl11Definition defaultWsdl11Definition() {
	// 	SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
	// 	wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/TutorialService.wsdl"));
	// 	return wsdl11Definition;
	// }

    @Bean(name="ChequeDispenseService")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema serviceSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ChequeDispenseServicePort");
        wsdl11Definition.setServiceName("ChequeDispenseService");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.wstutorial.com/ws/ChequeDispenseService");
		wsdl11Definition.setSchema(serviceSchema);

		return wsdl11Definition;
	}


    @Bean
	public XsdSchema serviceSchema() {
		return new SimpleXsdSchema(new ClassPathResource("/schema/ChequeDispenseService.xsd"));
	}
}