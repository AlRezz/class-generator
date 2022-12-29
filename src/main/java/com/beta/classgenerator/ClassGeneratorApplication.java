package com.beta.classgenerator;

import com.beta.classgenerator.model.*;
import com.beta.classgenerator.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class ClassGeneratorApplication implements CommandLineRunner {
	@Autowired
	private MappingService mappingService;

	public static void main(String[] args) {
		SpringApplication.run(ClassGeneratorApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		EntityGenerated alex = new EntityGenerated();
		alex.setId(1);
		alex.setName("Alex");
		alex.setAge(21);
		alex.setSalary(BigDecimal.TEN);
		alex.setTax(BigDecimal.ONE);

		ReportGenerated reportRecord = new ReportGenerated();

		mappingService.map(alex, reportRecord);
	}
}
