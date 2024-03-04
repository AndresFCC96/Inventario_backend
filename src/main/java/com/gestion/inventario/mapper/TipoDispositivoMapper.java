package com.gestion.inventario.mapper;

import com.gestion.inventario.dominio.TipoDispositivo;
import com.gestion.inventario.dto.TipoDispositivoDto;
import org.springframework.stereotype.Component;

@Component
public class TipoDispositivoMapper {

    public static TipoDispositivo convertirTipoDispositivoDtoATipoDispositivo(TipoDispositivoDto tipoDispositivoDto){
        return TipoDispositivo.builder()
                .nombre(tipoDispositivoDto.getNombre())
                .build();
    }

    public static TipoDispositivoDto convertirTipoDispositivoATipoDispositivoDto(TipoDispositivo tipoDispositivo){
        return TipoDispositivoDto.builder()
                .id(tipoDispositivo.getId())
                .nombre(tipoDispositivo.getNombre())
                .build();
    }
}
