package edu.eci.arsw.WeatherBackend.controller;

import edu.eci.arsw.WeatherBackend.model.*;
import edu.eci.arsw.WeatherBackend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping(value = "/")
public class WeatherAPIController {
    @Autowired
    WeatherServices ws= null;
  

    
    
    @RequestMapping(path ="/getDatos/{ciudad}",method = RequestMethod.GET)
    public ResponseEntity<?> getDatos(@PathVariable ("ciudad") String ciudad){
    	Ciudad c=ws.getDatos(ciudad);
    	try {
    		if(c!=null) {
        
    			return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
    		} 
    		return new ResponseEntity<>(-1,HttpStatus.ACCEPTED);
    	}catch (Exception ex) {
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path ="/postDatos",method = RequestMethod.POST)	
    public ResponseEntity<?> postDatos(@RequestBody Ciudad ciudad){
        
    	try {
    		ws.postDatos(ciudad);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }     

    }
    
    
    
   
}