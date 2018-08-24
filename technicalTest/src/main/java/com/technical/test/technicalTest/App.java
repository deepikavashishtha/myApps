package com.technical.test.technicalTest;

import java.util.List;

public class App 
{

	public static void main( String[] args )
	{
		final long startingTime = System.currentTimeMillis();
		NumberFinder numberFinder = new NumberFinderImpl();
		List<CustomNumberEntity> entityList = numberFinder.readFromFile(args[0]);
		System.out.println(entityList);
		System.out.println("value found : " + numberFinder.contains(100, entityList));
		final long endTime = System.currentTimeMillis();
		System.out.println("time taken in milliseconds: " + (endTime - startingTime));
	}
}
