package com.gestion.inventario.servicio;

import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dominio.EstadoDispositivo;
import com.gestion.inventario.dto.EstadoDispositivoDto;
import org.springframework.stereotype.Service;

@Service
public interface EstadoDispositivoService {
    Respuesta listarTodosLosEstadosDispositivo();

    Respuesta encontrarEstadoDispositivoPorNombre(String estadoDispositivo);

    EstadoDispositivo encontrarEstadoDispositivoPorId(Long id);

    Respuesta guardarEstadoDispositivo(EstadoDispositivoDto estadoDispositivoDto);

    Respuesta modificarEstadoDispositivo(EstadoDispositivoDto estadoDispositivoDto);

    Respuesta eliminarEstadoDispositivo(EstadoDispositivoDto estadoDispositivoDto);

    Respuesta validarEstadoDispositivoDto(EstadoDispositivoDto estadoDispositivoDto);

    Respuesta validarIdEstadoDispositivo(Long id);

    Respuesta validarNombreEstadoDispositivo(String nombre);
}
