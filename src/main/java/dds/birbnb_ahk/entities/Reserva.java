package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Setter
@Getter

public class Reserva {
    private LocalDate fechaAlta;
    private Usuario huesped;
    private Alojamiento alojamiento;
    private RangoFechas rangoFechas;
    private EstadoReserva estadoReserva;
    private Double precioPorNoche;

    public void actualizarEstado(EstadoReserva estadoReserva){
        this.estadoReserva = estado;
        //TODO pendiente de ser guardado
        Notificacion notificacion = new FactoryNotificacion().crearSegunReserva(this);
    }
}
