package edu.eci.arsw.WeatherBackend.persistence.impl;


import edu.eci.arsw.WeatherBackend.model.*;
import java.util.Map;
import java.util.Set;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

import edu.eci.arsw.WeatherBackend.persistence.*;

/**
 *
 * @author hcadavid
 */

@Service
public class InMemoryWeatherPersistence implements WeatherPersistence{
	//private ArrayList<String> ciudades=new ArrayList<>();
	private ArrayList<Timer> timers=new ArrayList<>();
    private final ConcurrentHashMap<String,Ciudad> dic=new ConcurrentHashMap<>();

 
    @Override
	public void postDatos(Ciudad ciudad) {

    	if(!dic.containsKey(ciudad)){
			dic.put(ciudad.getCiudad(),ciudad);
			//Eliminacion cada 5 minutos
			Timer timer=new Timer(300000,new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {
	                System.out.println("hola");
					dic.remove(ciudad.getCiudad());
	                timers.get(0).stop();
	                timers.remove(timers.get(0));
	                
	            }
			});
			
			timer.start();
			timers.add(timer);
		
    	}

	}


	@Override
	public Ciudad getDatos(String ciudad) {
		
		if(dic.containsKey(ciudad)){
			return dic.get(ciudad);
		}
		return null;
		
	}
	
	
}
