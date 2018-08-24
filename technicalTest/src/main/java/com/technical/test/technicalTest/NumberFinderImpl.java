package com.technical.test.technicalTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Implementation class for NumberFinder
 * @author Deepika Vashishtha
 *
 */
public class NumberFinderImpl implements NumberFinder {
	
	final Logger logger = Logger.getLogger(NumberFinderImpl.class.getName());

	@Override
	public boolean contains(int valueToFind, List<CustomNumberEntity> list) {
		final FastestComparator fc = new FastestComparator();
		return list.stream().parallel().anyMatch(t -> {
			try {
				return fc.compare(valueToFind, t) == 0;
			} catch (Exception e) {
				logger.log(Level.WARNING, "No match found", e);
				return false;
			}
		});
	}


	@Override
	public List<CustomNumberEntity> readFromFile(final String filePath) {
		final JSONParser parser = new JSONParser();
		final List<CustomNumberEntity> customNumberEntityList = new ArrayList<>();
		JSONArray from_excel;
		try {
			from_excel = (JSONArray)parser.parse(new FileReader(filePath));
			for(Object o: from_excel){
				final JSONObject jsonObj = (JSONObject)o;
				if(jsonObj != null && jsonObj.get("number") != null)
				{
					customNumberEntityList.add(new CustomNumberEntity(jsonObj.get("number").toString()));
				}
			}
		} catch (final IOException | ParseException e) {
			logger.log(Level.WARNING, "Exceptions while reading file", e);
		}
		return customNumberEntityList;
	}

}
