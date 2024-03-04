package com.gestion.inventario.dto;

import com.gestion.inventario.dominio.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DispositivoDto {
    private Long id;
    private String nombre;
    private Usuario usuario;
    private Area area;
    private EstadoDispositivo estadoDispositivo;
    private TipoDispositivo tipoDispositivo;
    private Fabricante fabricante;
    private String modelo;
    private String numeroDeSerie;
    private Long numeroDeInventario;
    private String comentario;
}
