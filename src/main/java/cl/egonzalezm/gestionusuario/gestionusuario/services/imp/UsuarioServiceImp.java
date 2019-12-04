package cl.egonzalezm.gestionusuario.gestionusuario.services.imp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Usuario crearUsuario(Usuario usuario) {
		for (Phone phone : usuario.getPhones()) {
			phone.setUsuario(usuario);
		}
		return repository.save(usuario);
	}

}
