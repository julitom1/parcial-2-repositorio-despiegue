package edu.eci.arsw.WeatherBackend.model;

public class Ciudad {
	
	private String ciudad;
    private double lat;
    private double lon;
    private double temp;
    
    public Ciudad() {
    	
    }
    public Ciudad(String c,double la, double lo, double tem) {
    	ciudad=c;
    	lat=la;
    	lon=lo;
    	temp=tem;
    }
    
    
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double tem) {
		this.temp = tem;
	}

}
