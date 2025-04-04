package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Usuario {
    private String nombre;
    private String email;
    private TipoUsuario tipo;
}
