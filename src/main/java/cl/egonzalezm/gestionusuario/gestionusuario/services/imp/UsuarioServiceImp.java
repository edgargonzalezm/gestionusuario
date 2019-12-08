package cl.egonzalezm.gestionusuario.gestionusuario.services.imp;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.egonzalezm.gestionusuario.gestionusuario.domain.UsuarioResponse;
import cl.egonzalezm.gestionusuario.gestionusuario.entity.Phone;
import cl.egonzalezm.gestionusuario.gestionusuario.entity.Usuario;
import cl.egonzalezm.gestionusuario.gestionusuario.repository.UsuarioRepository;
import cl.egonzalezm.gestionusuario.gestionusuario.services.UsuarioService;

@Service
@Transactional
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UsuarioResponse crearUsuario(Usuario usuario) {
		usuario.setActivo(Boolean.TRUE);
		usuario.setFechaCreacion(new Date());
		usuario.setFechaModificacion(new Date());
		for (Phone phone : usuario.getPhones()) {
			phone.setUsuario(usuario);
		}
		Usuario resultado = repository.save(usuario);

		return convertResponse(resultado);
	}

	private UsuarioResponse convertResponse(Usuario resultado) {
		UsuarioResponse usuarioResponse = new UsuarioResponse();

		usuarioResponse.setId(resultado.getId());
		usuarioResponse.setName(resultado.getName());
		usuarioResponse.setEmail(resultado.getEmail());
		usuarioResponse.setFechaCreacion(resultado.getFechaCreacion());
		usuarioResponse.setFechaModificacion(resultado.getFechaModificacion());
		usuarioResponse.setActivo(resultado.getActivo());
		return usuarioResponse;
	}

}
