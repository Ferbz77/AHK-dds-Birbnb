package dds.birbnb_ahk.entities.alojamientos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "foto")

public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String descripcion;

    @Column
    private String path;


}
