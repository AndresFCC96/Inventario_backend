package com.gestion.inventario.mapper;

import com.gestion.inventario.dominio.Modelo;
import com.gestion.inventario.dto.ModeloDto;
import org.springframework.stereotype.Component;

@Component
public class ModeloMapper {
    public static Modelo convertirModeloDtoAModelo(ModeloDto modeloDto){
        return Modelo.builder()
                .nombre(modeloDto.getNombre())
                .build();
    }

    public static ModeloDto convertirModeloAModeloDto(Modelo modelo){
        return ModeloDto.builder()
                .id(modelo.getId())
                .nombre(modelo.getNombre())
                .build();
    }
}
