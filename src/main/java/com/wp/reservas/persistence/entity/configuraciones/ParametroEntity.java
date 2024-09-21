package com.wp.reservas.persistence.entity.configuraciones;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ParametroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "clave")
    private String clave;

    @Column(name = "valor")
    private String valor;

    @Column(name = "tipo_dato")
    private String tipoDato;

    @Column(name = "descripcion")
    private String descripcion;

}
