package com.Kayak.Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;
	private static ConfigReader configReader;

    private ConfigReader() {
		BufferedReader reader;
	    	String propertyFilePath = "/src/main/resources/TestData/TestData.properties";
	        try {
	            reader = new BufferedReader(new FileReader(propertyFilePath));
	            properties = new Properties();
	            try {
	                properties.load(reader);
	                reader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	        }		
	}

    public static ConfigReader getInstance( ) {
    	if(configReader == null) {
    		configReader = new ConfigReader();
    	}
        return configReader;
    }

    public String getReportConfigPath() {
        String xmlPath = properties.getProperty("XmlPath");
        if(xmlPath != null) return xmlPath;
        else throw new RuntimeException("xmlPath not specified in the Configuration.properties file.");
    }

   
}
