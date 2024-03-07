package com.gestion.inventario.servicio;

import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dominio.Rol;
import com.gestion.inventario.dto.AccionesDto;
import org.springframework.stereotype.Service;

@Service
public interface AccionesService {

    Respuesta listarTodasLasAcciones();

    Respuesta guardarAccion(AccionesDto accionesDto);

    Respuesta modificarAccion(AccionesDto accionesDto);

    Respuesta eliminarAccion(AccionesDto accionesDto);

    Respuesta validarAccionDto(AccionesDto accionesDto);

    Respuesta validarIdAccion(Long id);

    Respuesta validarNombreAccion(String nombre);

    Respuesta validarRol(String rol);
}
