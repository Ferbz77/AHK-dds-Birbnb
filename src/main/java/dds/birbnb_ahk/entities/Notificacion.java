package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Setter
@Getter

public class Notificacion {
    private String mensaje;
    private Usuario usuario;
    private LocalDateTime fechaAlta;
    private Boolean leida;
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