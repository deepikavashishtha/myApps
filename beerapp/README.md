# Beers

Beers is simple mvc application, which shows random record of beer stored in database.

## Main method

BeerApp is main entry point for this project

## Running the application
To build and lauch application: mvn clean install && docker-compose up --build
URL: http://localhost:8080/beerapp/view

## Backend Logic
Main requirement for this application is to get random record for Beer. Which can be Done in following ways and there are pros and cons of each approach. One approach via which we can get most light weight application, is choosen here. 
> Approach 1: Randomly select an id in Java-App [may be in BeerAppController] and fetch that records from db. 
	pros: Application will have control over buisness logic.
	cons: Application wont know if that record is exists in db. Various db calls need to be done to make sure that object exists in db.
> Approach 2: Fetch all the records from db and randomly share one of them.
	pros: Easy to implement
	cons: Will make application more Bulky.
> Approach 3: Run Random query on db and show the record, returned by DB. This approach is picked up in the shared implementation.
	pros: Light weight applicaiton.
	cons: Application does not have control over buisness logic.

## Class Structure
This application has These packages
> com.distilled.sch.app : This package contains classes for BeerApp, Controller and repository
> com.distilled.sch.app.entity: This package contains entity class.
 
This application has following classes:

> BeerAppController: Controller class for this app. Exposes end point and talk to BeerRepository, to fetch the records.
	Endpoints: 
		random: fetch random records from Database.
		all: to fetch all the records from db
		beers: POST method: to create beer record in db
> BeerApp : Main entry point for the application
> BeerRepository : An interface extending CrudRepository.
> Beer : Entity class for the beer.

## UI
> beers.html: Main UI for applicaiton.
> beerserror.html: Error page for applicaiton. 

## Authors

Deepika Vashishtha
