package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter

public class RangoFechas {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public boolean haySuperposicionCon(RangoFechas rangoFechas) {
        return this.fechaInicio.isBefore(rangoFechas.getFechaFin())
                && rangoFechas.getFechaInicio().isBefore(this.fechaFin);
    }
}
