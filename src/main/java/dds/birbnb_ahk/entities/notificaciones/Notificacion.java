package dds.birbnb_ahk.entities.notificaciones;

import dds.birbnb_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "notificacion")

public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDateTime fechaAlta;

    @Column
    private Boolean leida;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime fechaLeida;

    public Notificacion(){
        this.leida = false;
        this.fechaAlta = LocalDateTime.now();
    }

    public void marcarComoLeida(){
        this.leida = true;
        this.fechaLeida = LocalDateTime.now();
    }
}