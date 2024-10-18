package com.wp.reservas.persistence.entity.usuarios;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios_fotos")
@Getter
@Setter
public class UsuarioFotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "ruta_foto")
    private String rutaFoto;

    @Column(name = "hash_foto")
    private String hashFoto;

    @Column(name = "activo")
    private boolean activo;

}
