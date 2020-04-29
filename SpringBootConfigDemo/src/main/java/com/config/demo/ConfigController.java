package com.config.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

	@Value("${app.message}")
    String myProperty;
	
	@Value("${app.uuid}")
    String token;
	
	@Autowired
	ConfigurationBean configurationBean;
	
    @GetMapping("/configProperties")
    public String getBindingProperties(){

        return myProperty+" token: "+token;
    }

    @GetMapping("/configBean")
    public ConfigurationBean getConfigBean(){

        return configurationBean;
    }
}
