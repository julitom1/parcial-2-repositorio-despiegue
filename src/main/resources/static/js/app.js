var api = apiclient;
//api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}


function cargar(){
		if (document.querySelectorAll('#map').length > 0)
		{
		if (document.querySelector('html').lang)
		  lang = document.querySelector('html').lang;
		else
		  lang = 'en';

		var js_file = document.createElement('script');
		js_file.type = 'text/javascript';
		js_file.src = 'https://maps.googleapis.com/maps/api/js?callback=initMap&signed_in=true&language=' + lang;
		document.getElementsByTagName('head')[0].appendChild(js_file);
	  }
	};

	var map;


	function initMap()
	{
	  map = new google.maps.Map(document.getElementById('map'), {
		center: {lat: -34.397, lng: 150.644},
		zoom: 8
	  });

	  
	}
	function marcas(){
		fetch('https://raw.githubusercontent.com/jayshields/google-maps-api-template/master/markers.json')
		.then(function(response){return response.json()})
		.then(plotMarkers);
	}
	var markers;
	var bounds;

	function plotMarkers(m)
	{
	  bounds = new google.maps.LatLngBounds();
		var position = new google.maps.LatLng(m.lat, m.lon);
	
		
		 // new google.maps.Marker({
		//	position: position,
		//	map: map,
		//	animation: google.maps.Animation.DROP
		 // });
		
		
		bounds.extend(position);
		

	  map.fitBounds(bounds);
	  map.setZoom(12);	
	}

function colocarDatos(datos){
	$("#ciudad").html(datos.ciudad);
	$("#temperatura").html(datos.temp+" grados");
	$("#latitud").html(datos.lat);
	$("#longitud").html(datos.lon);
}

$(document).ready(function(){
	cargar();

	$("#buscar").click(function(){
			var c=$("#nickname").val();
			api.getDatos(c,function(err,datos){
					if(err){
						fetch("https://api.openweathermap.org/data/2.5/weather?q="+ c +"&appid=8805fcd7d0439565c8dda8eb5eedbbad")
						.then(function(response){return response.json()})
						.then(async function(d){
							let s = {
								ciudad:d.name,
								lat: d.coord.lat,
								lon:d.coord.lon,
								temp:d.main.temp,
							}
							let json=JSON.stringify(s);
							await api.postDatos(json);
							await api.getDatos(c,function(error,datos){
								if(error){
									console.log(err);
								}else{
									colocarDatos(datos);
									plotMarkers(datos);
								}
							});
						})
						
					}
					else{	
						colocarDatos(datos);
						plotMarkers(datos);
					}
				
			});
			
			
			
	});
	
	
});