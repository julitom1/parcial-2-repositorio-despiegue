package edu.eci.arsw.WeatherBackend.services;



import edu.eci.arsw.WeatherBackend.model.*;
import edu.eci.arsw.WeatherBackend.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class WeatherServices {
   
    @Autowired
    WeatherPersistence bp = null;

    
    /**
     * Metodo encargado de adicionar un nuevo BluePrint
     * @param bp
     * @throws BlueprintPersistenceException 
     */
    public Ciudad getDatos(String datos){
        return bp.getDatos(datos);
    }
    
    public void postDatos(Ciudad datos){
        bp.postDatos(datos);
    }
    
 

}
