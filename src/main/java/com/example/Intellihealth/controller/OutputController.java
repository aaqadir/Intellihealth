package com.example.Intellihealth.controller;

import com.example.Intellihealth.dao.OutputDAO;
import com.example.Intellihealth.model.Output;
import com.example.Intellihealth.service.TrimString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OutputController {
	private static final Logger log = LogManager.getLogger(OutputController.class);

	@Autowired
	TrimString trimString;
	@Autowired
	OutputDAO outputDAO;
	
	@GetMapping("/get_from_output")
	public List<Output> get(){
		return outputDAO.findAll();
	}

	@PostMapping("/save_in_output")
	public Output save(@RequestBody Output inputObj) {
		return outputDAO.save(inputObj);
	}


	@PostMapping("/process_save_in_output")
	public Output process(@RequestBody String inputStr) {
		log.info("inputString: " + inputStr);
		Output output = trimString.processData(inputStr);
		log.info("rest outputStr: "+output.getOutput());
		log.info("rest output Count: "+output.getCount());
		return outputDAO.save(output);
	}

}