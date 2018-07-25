package com.distilled.sch.app;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.distilled.sch.entities.Beer;

/**
 * Beer Repository for doing crud operation
 * @author Deepika Vashishtha
 *
 */
@Repository
public interface BeerRepository extends CrudRepository<Beer, Long> {
	
	/**
	 * @return Random records of beer , fetched from database
	 */
	public List<Beer> findRandomRecord(); 

}