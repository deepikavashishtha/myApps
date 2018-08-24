package com.technical.test.technicalTest;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * NumberFinderTest is junit test class for NumberFinderImpl
 * @author Deepika Vashishtha
 *
 */
public class NumberFinderTest {
	NumberFinder numberFinder;
	ClassLoader classLoader = getClass().getClassLoader();

	@Before
	public void setup()
	{
		numberFinder = new NumberFinderImpl();
	}

	
	@Test
	public void readFromFileTest()
	{
		List<CustomNumberEntity> listOfEntities = readEntryFromFile();
		Assert.assertEquals(8, listOfEntities.size());
	}

	@Test
	public void readFromFile_nonexisitng_file()
	{
		Assert.assertEquals(0, numberFinder.readFromFile("C:/abc/file.txt").size());
	}
	
	@Test
	public void readFromFile_empty_file()
	{
		File file = new File(classLoader.getResource("emptyFile").getFile());
		Assert.assertEquals(0, numberFinder.readFromFile(file.getPath()).size());
	}

	@Test
	public void readFromFile_empty_array()
	{
		File file = new File(classLoader.getResource("emptyArray").getFile());
		Assert.assertEquals(0, numberFinder.readFromFile(file.getPath()).size());
	}

	@Test
	public void readFromFile_empty_entry()
	{
		File file = new File(classLoader.getResource("emptyEntry").getFile());
		Assert.assertEquals(0, numberFinder.readFromFile(file.getPath()).size());
	}
	
	@Test
	public void containEntryTest()
	{
		List<CustomNumberEntity> listOfEntities = readEntryFromFile();
		Assert.assertEquals(8, listOfEntities.size());
		Assert.assertEquals(true, numberFinder.contains(100, listOfEntities));
	}
	
	@Test
	public void notcontainEntryTest()
	{
		List<CustomNumberEntity> listOfEntities = readEntryFromFile();
		Assert.assertEquals(8, listOfEntities.size());
		Assert.assertEquals(false, numberFinder.contains(150, listOfEntities));
	}
	
	private List<CustomNumberEntity> readEntryFromFile() {
		File file = new File(classLoader.getResource("CustomNumberEntity").getFile());
		List<CustomNumberEntity> listOfEntities = numberFinder.readFromFile(file.getPath());
		return listOfEntities;
	}
}
