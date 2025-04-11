package dds.birbnb_ahk.entities.usuarios;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    //los enumerados se transforman en columnas, se transforman en strings-el nombre o numeros-ordinal/ enumerados fijos y finitos
    private TipoUsuario tipo;
}
