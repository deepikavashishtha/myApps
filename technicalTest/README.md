# NumberFinder

NumberFinder is simple JAVA application , And using this app usr can serach a number in a file conatining array of JSON objects.


## Running the tests

NumberFinderTest is junit test class for NumberFinderImpl
NumberFinderTest can be improved catching specific issue , if APIs[NumberFinder class methods are not throwing exception] are not retricted. Methods can throw exception containing an ENUM [ex: FILENOTFOUND, EMPTYFILE ......] with error code.
 
mvn clean test


## Class Structure

> NumberFinderImpl: This class provides implementation for NumberFinder class. 
> It uses json-simple library to read json from file and 
> Parallel stream to read List of JSON objects and search for int value in list.
> App class is main entry point : Need to pass path to file as an argument.


## Authors

Deepika Vashishtha