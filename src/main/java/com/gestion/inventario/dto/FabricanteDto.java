package com.gestion.inventario.dto;

import com.gestion.inventario.dominio.Modelo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FabricanteDto {

    private Long id;
    private String nombre;
    private Modelo modelo;
}
