var apiclient = (function () {
  
	return {
		getDatos : function (ciudad,callback) {
			
			$.getJSON("/getDatos/"+ ciudad ,function (data) {
					console.log(data);
					if(data!=-1){
						callback(null,data);
					}else{
						callback("no se guardo dato");
					
						
					}
				}
			);
		},
		
		postDatos : function(datos){
			let promise = new Promise( (resolve, reject) => {
				var postPromise = $.ajax({
				url: "http://localhost:8080/postDatos",
				type: 'POST',
				data: datos,
				contentType: "application/json"
			});
			resolve(postPromise);
			});
			
			return promise;			
		}
		
		
		
		
		
	
		
		
		
		
		
		
	}
})();