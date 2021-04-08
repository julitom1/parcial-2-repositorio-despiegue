package edu.eci.arsw.WeatherBackend.persistence;
import edu.eci.arsw.WeatherBackend.model.*;
import java.util.Set;

/**
 *
 * @author hcadavid
 */
public interface WeatherPersistence {
    

    
    public Ciudad getDatos(String ciudad);
    
    public void postDatos(Ciudad ciudad);
    
}