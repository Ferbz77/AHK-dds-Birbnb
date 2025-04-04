package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Direccion {
    private String calle;
    private String altura;
    private Ciudad ciudad;
    private String lat;
    private String longitud;
}
