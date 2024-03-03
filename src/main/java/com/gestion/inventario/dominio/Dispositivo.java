package com.gestion.inventario.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dispositivos", schema = "public")
public class Dispositivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_area", referencedColumnName = "id")
    private Area area;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private EstadoDispositivo estadoDispositivo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo", referencedColumnName = "id")
    private TipoDispositivo tipoDispositivo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_fabricante", referencedColumnName = "id")
    private Fabricante fabricante;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "numero_de_serie")
    private String numeroDeSerie;

    @Column(name = "numero_de_inventario", columnDefinition="serial")
    private Long numeroDeInventario;

    @Column(name = "comentario")
    private String comentario;




}
