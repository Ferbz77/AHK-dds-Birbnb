package dds.birbnb_ahk.entities.alojamientos;

import dds.birbnb_ahk.entities.ubicaciones.Direccion;
import dds.birbnb_ahk.entities.Moneda;
import dds.birbnb_ahk.entities.reservas.RangoFechas;
import dds.birbnb_ahk.entities.reservas.Reserva;
import dds.birbnb_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "alojamiento")

public class Alojamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Setter
    @Getter

    @ManyToOne
    @JoinColumn(name = "anfitrion_id", nullable = false)
    private Usuario anfitrion;

    @Setter
    @Getter
    @Column
    private String nombre;

    @Setter
    @Getter
    @Column(columnDefinition = "TEXT") //65535 Y longtext 4gb
    private String descripcion;

    @Setter
    @Getter
    @Column
    private Double precioPorNoche;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING) //si le quiero cambiar el nombre, le agrego @column arriba
    private Moneda moneda;

    @Setter
    @Getter
    @Column(columnDefinition = "TIME")
    private LocalTime horarioCheckIn;

    @Setter
    @Getter
    @Column(columnDefinition = "TIME")
    private LocalTime horarioCheckOut;

    @Setter
    @Getter
    @OneToOne
    @JoinColumn(name = "direccion_id", nullable = false)
    private Direccion direccion;

    @Setter
    @Getter
    @Column
    private Integer cantHuespedesMax;

    @Getter
    @ElementCollection //crea una relacion onetoMany
    @CollectionTable(name = "alojamiento_caracteristica", joinColumns = @JoinColumn(name = "alojamiento_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "caracteristica")
    private List<Caracteristica> caracteristicas;


    @Getter
    @OneToMany//el manytoOne tiene la FK, en este caso, las fotos
    @JoinColumn(name = "alojamiento_id")
    private List<Foto> fotos;

    @Getter
    @OneToMany(mappedBy = "alojamiento") //para relaciones bidireccionales y que coincida cobn el nombre del atributo en la clase
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
