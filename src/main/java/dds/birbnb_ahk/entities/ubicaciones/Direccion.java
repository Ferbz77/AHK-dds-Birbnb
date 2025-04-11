package dds.birbnb_ahk.entities.ubicaciones;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="direccion") //coleccion, la relacion termina en many

public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(name="calle")
    private String calle;

    @Column(name = "altura")
    private String altura;

    @ManyToOne
    @JoinColumn(name = "ciudad_id", nullable = false)
    private Ciudad ciudad;

    @Column(name = "latitud")
    private String lat;

    @Column(name = "longitud")
    private String longitud;
}
