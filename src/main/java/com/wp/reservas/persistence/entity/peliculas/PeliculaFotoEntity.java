package com.wp.reservas.persistence.entity.peliculas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "peliculas_fotos")
@Getter
@Setter
public class PeliculaFotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_pelicula")
    private Integer idPelicula;

    @Column(name = "ruta_foto")
    private String rutaFoto;

    @Column(name = "hash_foto")
    private String hashFoto;

    @Column(name = "activo")
    private boolean activo;

}
