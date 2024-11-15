package service;

import java.util.Optional;
import model.Usuario;

public interface UsuarioService {

	Optional<Usuario> findingByEmail(String email);

    Optional<Usuario> findingByDni(String dni);

    Optional<Usuario> findingByUsername(String username);
}
