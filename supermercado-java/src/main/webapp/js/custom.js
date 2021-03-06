
 // ejecuta la funcion cuando todo el documento de html DOM este listo y cargado
$(document).ready(function() {    
    $('.tabla').DataTable();
});

function init() {
	console.log('Documento cargado y listo');
	
}
/**
 * 
 *funcion asociada al evento keyenter para el id:input#nombre
 *llama mediante AJAX a un servicio REST para combrobar si existe el usuario en BBDD
 */
function buscarUsuario(event) {
	//console.debug(event);
	const nombre = event.target.value;
	console.debug(`valor del input ${nombre}`);
	const url = `http://localhost:8080/supermerkado-master/api/usuario?nombre=${nombre}`;
	   //console.debug('url %s', url);

	   var xhttp = new XMLHttpRequest();
	   xhttp.open("GET", url );    
	   xhttp.send();
	   xhttp.onreadystatechange = function() {     
	   
	     let elNombreHelp=document.getElementById('nombreHelp');
	     let elBtnLogin=document.getElementById('btnLogin');
	     if (this.readyState == 4 && this.status == 200) {            
	    	 elNombreHelp.innerHTML = 'nombre no disponible';
	 		elNombreHelp.classList.add('text-danger');
	 		elNombreHelp.classList.remove('text-success');
	 		elBtnLogin.setAttribute('disabled','disabled');
	     }
	     if (this.readyState == 4 && this.status == 204) {            
	    	 elNombreHelp.innerHTML = 'nombre disponible';
	 		elNombreHelp.classList.add('text-success');
	 		elNombreHelp.classList.remove('text-danger');
	 		elBtnLogin.setAttribute('disabled','');
	     }

	};// onreadystatechange
	
}//buscarUsuario




function cifrar() {
		
		console.log('cifrar y conseguir hash');
		
		//recupero el valor de la contraseña del input a traves de su ID
		var contrasenia = document.getElementById('pass').value;		
		
		//consigo el hash mediante la libreria incluida en el pie.jsp
		var hash = md5(contrasenia);
		
		//guardo en el atributo value del input el codigo hash
		document.getElementById('pass').value = hash;		
		
		// comprobar si hay que confirmar la contraseña
		var inputRePass = document.getElementById('repass');
		
		// comprobar que exista el input#repass, si no existe tiene valor undefined
		if ( inputRePass ){                        
			
			var rehash = md5(inputRePass.value);
			inputRePass.value = rehash;
		}	
				
		//enviar formulario
		return true; // si ponemos false no se envia el formulario
		
}


function confirmar(nombre) {
	
	// The confirm() method returns true if the user clicked "OK", and false otherwise. 
	if ( confirm('¿ Estas seguro que quires eliminar ' + nombre + ' ?') ){
		
		console.debug(' continua el evento por defceto del ancla ');
		
	}else {
		console.debug(' prevenimos o detenemos el evento del ancla ');
		event.preventDefault();
	}
	
}
