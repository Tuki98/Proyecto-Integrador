package model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "USUARIO", uniqueConstraints = {
        @UniqueConstraint(columnNames = "dni"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "username")
})
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Email(message = "El formato del email es inválido")
    private String email;

    private String password;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    // Agregado: Campo username, que debe ser único
    private String username;

    // Agregado: Campo DNI, que debe ser único
    private String dni;
}