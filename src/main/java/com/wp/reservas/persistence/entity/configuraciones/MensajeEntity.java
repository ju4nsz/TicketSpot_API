package com.wp.reservas.persistence.entity.configuraciones;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mensajes")
@Getter
@Setter
public class MensajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "clave")
    private String clave;
    @Column(name = "valor")
    private String valor;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "id_tipo_mensaje")
    private Integer idTipoMensaje;

}
