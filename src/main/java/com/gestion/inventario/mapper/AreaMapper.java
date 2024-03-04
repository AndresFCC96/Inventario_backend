package com.gestion.inventario.mapper;

import com.gestion.inventario.dominio.Area;
import com.gestion.inventario.dto.AreaDto;
import org.springframework.stereotype.Component;

@Component
public class AreaMapper {

    public static Area convertirAreaDtoAArea(AreaDto areaDto){
        return Area.builder()
                .nombre(areaDto.getNombre())
                .build();
    }

    public static AreaDto convertirAreaAAreaDto(Area area){
        return AreaDto.builder()
                .id(area.getId())
                .nombre(area.getNombre())
                .build();
    }
}
