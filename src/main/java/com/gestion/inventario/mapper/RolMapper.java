package com.gestion.inventario.mapper;

import com.gestion.inventario.dominio.Rol;
import com.gestion.inventario.dto.RolDto;
import org.springframework.stereotype.Component;

@Component
public class RolMapper {

    public static Rol convertirRolDtoARol(RolDto rolDto){
        return Rol.builder()
                .nombre(rolDto.getNombre())
                .build();
    }

    public static RolDto convertirRolARolDto(Rol rol){
        return RolDto.builder()
                .id(rol.getId())
                .nombre(rol.getNombre())
                .build();
    }
}
