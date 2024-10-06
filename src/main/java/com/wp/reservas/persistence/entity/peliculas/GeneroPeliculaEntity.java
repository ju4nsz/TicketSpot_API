package com.wp.reservas.persistence.entity.peliculas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "generos_peliculas")
@Getter
@Setter
public class GeneroPeliculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "activo")
    private boolean activo;

    @ManyToMany(mappedBy = "generos")
    private List<PeliculaEntity> peliculas;

}
