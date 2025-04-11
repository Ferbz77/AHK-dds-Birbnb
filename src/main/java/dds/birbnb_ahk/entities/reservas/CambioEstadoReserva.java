package dds.birbnb_ahk.entities.reservas;

import dds.birbnb_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "reserva_cambio_estado")

public class CambioEstadoReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(columnDefinition = "DATE")
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;

    @Column
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
