package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Alojamiento {
    @Setter
    @Getter
    private Usuario anfitrion;
    @Setter
    @Getter
    private String nombre;
    @Setter
    @Getter
    private String descripcion;
    @Setter
    @Getter
    private Double precioPorNoche;
    @Setter
    @Getter
    private Moneda moneda;
    @Setter
    @Getter
    private LocalTime horarioCheckIn;
    @Setter
    @Getter
    private LocalTime horarioCheckOut;
    @Setter
    @Getter
    private Direccion direccion;
    @Setter
    @Getter
    private Integer cantHuespedesMax;
    @Getter
    private List<Caracteristica> caracteristicas;
    @Getter
    private List<Foto> fotos;
    @Getter
    private List<Reserva> reservas;

    public Alojamiento(){
        this.fotos = new ArrayList<>();
        this.caracteristicas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public Boolean tuPrecioEstaDentroDe(Double valorMin, Double valorMax){
        return this.precioPorNoche <= valorMax && this.precioPorNoche >= valorMin;
    }

    public Boolean estasDisponibleEn(RangoFechas rangoFechas){
       /* boolean haySuperposicionDeFechas = false;
        int i = 0;
        while(i < this.reservas.size() && haySuperposicionDeFechas){
            Reserva reserva = this.reservas.get(i);
            RangoFechas rangoDeLaReserva = reserva.getRangoFechas(); //me quedo con el rango de las fechas de esta reserva

            if(rangoDeLaReserva.haySuperposicionCon(rangoFechas)){
                haySuperposicionDeFechas = true;
            }

            i++;

        }
        return !haySuperposicionDeFechas;*/

        return this.reservas.stream().noneMatch(r-> r.getRangoFechas().haySuperposicionCon(rangoFechas));
    }

    public Boolean tenesCaracteristica(Caracteristica caracteristica){
        return this.caracteristicas.contains(caracteristicas);
    }

    public Boolean puedenAlojarse(Integer cantHuespedes){
        return this.cantHuespedesMax >= cantHuespedes;
    }
}
