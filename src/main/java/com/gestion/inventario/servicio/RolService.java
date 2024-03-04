package com.gestion.inventario.servicio;

import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dominio.Rol;
import com.gestion.inventario.dto.RolDto;
import org.springframework.stereotype.Service;

@Service
public interface RolService {

    Respuesta listarTodosLosRoles();

    Respuesta encontrarRolPorNombre(String nombre);

    Rol encontrarRolPorId(Long id);

    Respuesta guardarRol(RolDto rolDto);

    Respuesta modificarRol(RolDto rolDto);

    Respuesta eliminarRol(RolDto rolDto);

    Respuesta validarRolDto(RolDto rolDto);

    Respuesta validarIdRol(Long id);

    Respuesta validarNombreRol(String rol);
}
