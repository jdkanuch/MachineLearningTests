package com.machinelearningtests.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class InputDataManager {

	/* Handles input data in Yaml formats
	 * 
	 * Usage:
	 *   
	 *   // Instance the manager
	 *   InputDataManager dm = new InputDataManager;
	 * 
	 *   // to read a file into a string object:
	 *   String strYaml = InputDataManager.readFile("data/config.yml");
	 *   
	 *   // to parse a yaml string into a java map object:
	 *   HashMap<Object,Object> confMap = InputDataManager.parseYaml(strYaml);
	 *   
	 *   // To use data manager for CSV data
	 *     
	 *     
	 *   // To retrieve the data contained in the HashMap
	 *   // Use an object mapper
	 *   ObjectMapper mapper = new ObjectMapper();
	 *   // Convert to Tree (Use JsonNode, don't be fooled)
	 *   JsonNode node =  mapper.valueToTree(cMap);
	 *   // create reader to read as a list instead of as a node (set the reader to read whatever object you need)
	 *   ObjectReader reader = mapper.readerFor(new TypeReference<List<String>>() {});
	 * 
	 */
	
	
	
	FileReader fr;
	BufferedReader br = null;


	public InputDataManager() throws IOException{
		System.out.println("DM Loaded...");
	}

	static public String readFile(String path) 
			throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded);
		// test
	}

	@SuppressWarnings("unchecked")
	static public HashMap<Object,Object> parseYaml(String yamlSource) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		HashMap<Object,Object> yMap = mapper.readValue(yamlSource, HashMap.class);
		return yMap;
	}
	
	public Instances loadCSVData(String path) throws Exception{
		DataSource src = new DataSource(path);
		Instances inst = src.getDataSet();
		//inst.setClassIndex(inst.numAttributes() -1);
		
		return inst;
		
	}

	
}
