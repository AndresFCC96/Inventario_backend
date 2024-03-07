package com.gestion.inventario.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accciones", schema = "public")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Acciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nombre_accion")
    private String nombreAccion;

    @Column(name = "rol")
    private String rol;
}
