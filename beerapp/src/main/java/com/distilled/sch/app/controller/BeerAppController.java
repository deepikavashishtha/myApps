package com.distilled.sch.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.distilled.sch.app.BeerRepository;
import com.distilled.sch.entities.Beer;

/**
 * Rest Controller class for this application.
 * @author Deepika Vashishtha
 *
 */
@Controller
@RequestMapping(path="/beerapp") 
public class BeerAppController {
	@Autowired 
	private BeerRepository beerRepository;

	/**
	 * @return Random Beer response from db
	 */
	@RequestMapping(value = "/random", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Beer> getBeer() {
		final List<Beer> beers = beerRepository.findRandomRecord();
		if (beers.size() > 0) {
			return new ResponseEntity<Beer>(beers.get(0), HttpStatus.OK);
		}
		return new ResponseEntity<Beer>(HttpStatus.NO_CONTENT);
	}

	/**
	 * View method for random beer
	 * @param model
	 * @return html page
	 */
	@RequestMapping(value = "view", produces = { MediaType.TEXT_HTML_VALUE }, method = RequestMethod.GET)
	public String getBeerPage(Model model) {
		Beer beerResponse = getBeer().getBody();
		if(beerResponse!=null) {
			model.addAttribute("beermodel", beerResponse);
			return "beers";}
		return "beerserror";
	}

	/**
	 * @return Response containing all the records in db
	 */
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Beer> getAllBeers() {
		// This returns a JSON with the beers
		return beerRepository.findAll();
	}


}