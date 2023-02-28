package mx.tecnm.itlp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.itlp.bd.UsuarioJDBC;
import mx.tecnm.itlp.modelos.Usuario;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class UsuarioREST {
	
	@Autowired
	UsuarioJDBC repo;
	
	@GetMapping
	public ResponseEntity<?> recuperarUsuarios(){
		List<Usuario> resultado = null;
		resultado = repo.consultarUsuarios();
		return new ResponseEntity<List<Usuario>>(resultado, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarUsuario(@PathVariable int id){
		Usuario resultado = null;
		resultado = repo.buscarUsuario(id);
		return new ResponseEntity<Usuario>(resultado, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> desactivarUsuario(@PathVariable int id){
		repo.desactivarUsuario(id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping
	public ResponseEntity<?> agregarUsuario(@RequestBody Usuario user){
		repo.agregarUsuario(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
