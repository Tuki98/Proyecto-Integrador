package service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Usuario;
import service.UsuarioService;
import repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Optional<Usuario> findingByEmail(String email) {
		Optional<Usuario> usu = usuarioRepository.findByEmail(email);
		return usu;
	}

	@Override
	public Optional<Usuario> findingByDni(String dni) {
		Optional<Usuario> usu = usuarioRepository.findByDni(dni);
		return usu;
	}

	@Override
	public Optional<Usuario> findingByUsername(String username) {
		Optional<Usuario> usu = usuarioRepository.findByUsername(username);
		return usu;
	}

}
