package cl.egonzalezm.gestionusuario.gestionusuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.egonzalezm.gestionusuario.gestionusuario.entity.Usuario;
import cl.egonzalezm.gestionusuario.gestionusuario.services.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(value = "/usuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioNuevo = usuarioService.crearUsuario(usuario);
		return new ResponseEntity<>(usuarioNuevo, HttpStatus.OK);
	}

}
