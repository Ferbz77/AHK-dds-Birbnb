package dds.birbnb_ahk.entities.ubicaciones;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //clave primaria ficticia y autoincremental
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String ciudad;

    @ManyToOne                      //@Transient para q a este atributo x el momento no lo persista
    @JoinColumn(name = "pais_id", referencedColumnName = "id", nullable = false) //not null
    private Pais pais;
}