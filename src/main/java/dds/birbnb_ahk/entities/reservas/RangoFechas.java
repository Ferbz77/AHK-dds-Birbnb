package dds.birbnb_ahk.entities.reservas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@Embeddable

public class RangoFechas {

    @Column(columnDefinition = "DATE")
    private LocalDate fechaInicio;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaFin;

    public boolean haySuperposicionCon(RangoFechas rangoFechas) {
        return this.fechaInicio.isBefore(rangoFechas.getFechaFin())
                && rangoFechas.getFechaInicio().isBefore(this.fechaFin);
    }
}
