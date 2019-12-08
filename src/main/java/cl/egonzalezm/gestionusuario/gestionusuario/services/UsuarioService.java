package cl.egonzalezm.gestionusuario.gestionusuario.services;

import cl.egonzalezm.gestionusuario.gestionusuario.domain.UsuarioResponse;
import cl.egonzalezm.gestionusuario.gestionusuario.entity.Usuario;

public interface UsuarioService {

	UsuarioResponse crearUsuario(Usuario usuario);
}
