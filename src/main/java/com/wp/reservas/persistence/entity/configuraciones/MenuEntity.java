package com.wp.reservas.persistence.entity.configuraciones;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "menu")
@Getter
@Setter
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_padre")
    private Integer idPadre;

    @Column(name = "id_permiso")
    private Integer idPermiso;

    @Column(name = "ruta")
    private String ruta;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "icono")
    private String icono;

}
