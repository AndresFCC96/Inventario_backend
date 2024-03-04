package com.gestion.inventario.mapper;

import com.gestion.inventario.dominio.Fabricante;
import com.gestion.inventario.dto.FabricanteDto;
import org.springframework.stereotype.Component;

@Component
public class FabricanteMapper {

    public static Fabricante convertirFabricanteDtoAFabricante(FabricanteDto fabricanteDto){
        return Fabricante.builder()
                .nombre(fabricanteDto.getNombre())
                .modelo(fabricanteDto.getModelo())
                .build();
    }

    public static FabricanteDto convertirFabricanteAFabricanteDto(Fabricante fabricante){
        return FabricanteDto.builder()
                .id(fabricante.getId())
                .nombre(fabricante.getNombre())
                .modelo(fabricante.getModelo())
                .build();
    }

}
