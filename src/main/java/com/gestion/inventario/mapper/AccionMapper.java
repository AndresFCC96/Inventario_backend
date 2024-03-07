package com.gestion.inventario.mapper;

import com.gestion.inventario.dominio.Acciones;
import com.gestion.inventario.dto.AccionesDto;
import org.springframework.stereotype.Component;

@Component
public class AccionMapper {

    public static Acciones convertirAccionDtoAAccion(AccionesDto accionesDto){
        return Acciones.builder()
                .nombreAccion(accionesDto.getNombreAccion())
                .rol(accionesDto.getRol())
                .build();
    }
}



