package com.gestion.inventario.servicio;

import com.gestion.inventario.dominio.TipoDispositivo;
import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dto.TipoDispositivoDto;
import org.springframework.stereotype.Service;

@Service
public interface TipoDispositivoService {

    Respuesta listarTodosLosTiposDipositivos();

    Respuesta encontrarTipoDispositivoPorNombre(String tipoDispositivo);

    TipoDispositivo encontrarTipoDispositivoPorId(Long id);

    Respuesta guardarTipoDispositivo(TipoDispositivoDto tipoDispositivoDto);

    Respuesta modificarTipoDispositivo(TipoDispositivoDto tipoDispositivoDto);

    Respuesta eliminarTipoDispositivo(TipoDispositivoDto tipoDispositivoDto);

    Respuesta validarTipoDispositivoDto(TipoDispositivoDto tipoDispositivoDto);

    Respuesta validarIdTipoDispositivo(Long id);

    Respuesta validarNombreTipoDispositivo(String nombre);
}
