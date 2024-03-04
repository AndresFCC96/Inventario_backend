package com.gestion.inventario.mapper;

import com.gestion.inventario.dominio.EstadoDispositivo;
import com.gestion.inventario.dto.EstadoDispositivoDto;
import org.springframework.stereotype.Component;

@Component
public class EstadosDispositivoMapper {

    public static EstadoDispositivo convertirEstadoDispositivoDtoAEstadoDispositivo(EstadoDispositivoDto estadoDispositivoDto){
        return EstadoDispositivo.builder()
                .nombre(estadoDispositivoDto.getNombre())
                .build();
    }

    public static EstadoDispositivoDto convertirEstadoDispositivoAEstadoDispositivoDto(EstadoDispositivo estadoDispositivo){
        return EstadoDispositivoDto.builder()
                .id(estadoDispositivo.getId())
                .nombre(estadoDispositivo.getNombre())
                .build();
    }
}
