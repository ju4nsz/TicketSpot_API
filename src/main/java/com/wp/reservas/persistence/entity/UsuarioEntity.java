package com.wp.reservas.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class UsuarioEntity implements UserDetails {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "nombre1")
    private String nombre1;

    @Column(name = "nombre2")
    private String nombre2;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // TODO Obtener permisos del rol
        ArrayList<String> permisos = new ArrayList<>();
        permisos.add("test:obtener");

        return permisos
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }
}
