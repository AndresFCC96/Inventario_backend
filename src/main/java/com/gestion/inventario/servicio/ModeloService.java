package com.gestion.inventario.servicio;

import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dominio.Modelo;
import com.gestion.inventario.dto.ModeloDto;
import org.springframework.stereotype.Service;

@Service
public interface ModeloService {

    Respuesta listarTodosLosModelos();

    Respuesta encontrarModeloPorNombre(String modelo);

    Modelo encontrarModeloPorId(Long id);

    Respuesta guardarModelo(ModeloDto modeloDto);

    Respuesta modificarModelo(ModeloDto modeloDto);

    Respuesta eliminarModelo(ModeloDto modeloDto);

    Respuesta validarModeloDto(ModeloDto modeloDto);

    Respuesta validarIdModelo(Long id);

    Respuesta validarNombreModelo(String nombre);
}
