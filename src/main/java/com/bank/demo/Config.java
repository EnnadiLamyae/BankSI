package com.bank.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.bank.demo.rmi.BankRMI;

@Configuration
public class Config {

	@Bean
	public SimpleJaxWsServiceExporter getJWS() {
		SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8089/bank");
		return exporter;
	}
	
	@Bean
	public RmiServiceExporter getRMI(ApplicationContext context) {
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setService(context.getBean("RMIService"));
		exporter.setServiceName("BankRMIService");
		exporter.setRegistryPort(1099);
		exporter.setServiceInterface(BankRMI.class);
		return exporter;
	}
}
