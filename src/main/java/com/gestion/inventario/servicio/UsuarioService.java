package com.gestion.inventario.servicio;

import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dto.UsuarioDto;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

    Respuesta listarTodosLosUsuarios();

    Respuesta encontrarUsuarioPorCorreo(String correo);

    Respuesta encontrarUsuarioPorUsario(String usuario);

    Respuesta encontrarUsuarioPorId(Long id);

    Respuesta guardarUsuario(UsuarioDto usuarioDto);

    Respuesta modificarUsuario(UsuarioDto usuarioDto);

    Respuesta eliminarUsuario(UsuarioDto usuarioDto) ;

    Respuesta validarUsuarioDto(UsuarioDto usuarioDto);

    Respuesta validarIdUsuario(Long id);

    Respuesta validarNombre(String primerNombre, String primerApellido);

    Respuesta validarTelefono(String telefono);

    Respuesta validarCorreo(String correo);

    Respuesta validatePassword(String password);

    Respuesta validarNombreDeUsuario(String nombre);
}
