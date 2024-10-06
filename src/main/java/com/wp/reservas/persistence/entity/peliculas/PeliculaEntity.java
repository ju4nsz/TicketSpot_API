package com.wp.reservas.persistence.entity.peliculas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "peliculas")
@Getter
@Setter
public class PeliculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "edad_minima")
    private Integer edadMinima;

    @ManyToMany
    @JoinTable(
            name = "peliculas_generos",
            joinColumns = @JoinColumn(name = "id_pelicula"),
            inverseJoinColumns = @JoinColumn(name = "id_genero")
    )
    private List<GeneroPeliculaEntity> generos;

}
