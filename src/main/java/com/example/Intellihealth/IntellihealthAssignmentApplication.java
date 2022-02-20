package com.example.Intellihealth;

import com.example.Intellihealth.controller.InputController;
import com.example.Intellihealth.controller.OutputController;
import com.example.Intellihealth.model.Input;
import com.example.Intellihealth.model.Output;
import com.example.Intellihealth.service.TrimString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class IntellihealthAssignmentApplication implements CommandLineRunner {

	private static final Logger log = LogManager.getLogger(IntellihealthAssignmentApplication.class);

	@Autowired
	InputController inputController;
	@Autowired
	OutputController outputController;
	@Autowired
	TrimString trimString;

	public static void main(String[] args) {
		SpringApplication.run(IntellihealthAssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) {

		for(Input input : inputController.getAllInput()) {
			log.info("inputString: " + input.getInputString());
			Output output = trimString.processData(input.getInputString());
			log.info("output Str: "+output.getOutput());
			log.info("output count: "+output.getCount());
			outputController.save(output);
		}

	}

}
