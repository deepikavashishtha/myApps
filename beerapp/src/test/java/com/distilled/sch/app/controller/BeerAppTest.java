package com.distilled.sch.app.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.distilled.sch.app.BeerApp;
import com.distilled.sch.app.BeerRepository;
import com.distilled.sch.entities.Beer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeerApp.class)
public class BeerAppTest {

    @Autowired
    private BeerRepository beerRepo;
    
    @Before
    public void setup() {
    	beerRepo.deleteAll();
    }

    @Test
    public void randomok() {
        Beer beer1 = beerRepo.save(new Beer(1, "test1", "test1 desc", 1f, "loc1"));
        Beer beer2 = beerRepo.save(new Beer(2, "test2", "test2 desc", 2f, "loc2"));
        Beer beer3 = beerRepo.save(new Beer(3, "test3", "test3 desc", 3f, "loc3"));
        
        final Beer randomBeer = beerRepo.findRandomRecord().get(0);
        assertNotNull(randomBeer);
    }
    
    @Test
    public void randomwithoneresult() {
        Beer beer1 = beerRepo.save(new Beer(1, "test1", "test1 desc", 1f, "loc1"));
        
        final Beer randomBeer = beerRepo.findRandomRecord().get(0);
        assertNotNull(randomBeer);
        assertEquals("Beer name should be same", randomBeer.getName(),  beer1.getName()); 
        assertEquals("Beer id should be same", randomBeer.getId(),  beer1.getId()); 
    }
    
    @Test
    public void randomwithnoresult() {
        final List<Beer> beerList = beerRepo.findRandomRecord();
        assertNotNull(beerList);
        assertEquals("Beer return list should be empty", beerList.isEmpty(),  Boolean.TRUE); 
    }
}
