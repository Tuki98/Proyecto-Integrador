package controller;

import lombok.AllArgsConstructor;
import model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UsuarioService;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Obtener un usuario por email
    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> getUsuarioByEmail(@PathVariable String email) {
        Optional<Usuario> usuario = usuarioService.findingByEmail(email);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener un usuario por DNI
    @GetMapping("/dni/{dni}")
    public ResponseEntity<Usuario> getUsuarioByDni(@PathVariable String dni) {
        Optional<Usuario> usuario = usuarioService.findingByDni(dni);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener un usuario por username
    @GetMapping("/username/{username}")
    public ResponseEntity<Usuario> getUsuarioByUsername(@PathVariable String username) {
        Optional<Usuario> usuario = usuarioService.findingByUsername(username);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para agregar un usuario (por ejemplo)
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        // Implementación de lógica para guardar usuario (si aplica)
        // Ejemplo básico (puede variar según tus requisitos de negocio)
        return ResponseEntity.ok(usuario);
    }
}
