package com.gestion.inventario.mapper;

import com.gestion.inventario.dominio.Usuario;
import com.gestion.inventario.dto.UsuarioDto;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public static Usuario convertirUsuarioDtoAUsuario(UsuarioDto usuarioDto){
        return Usuario.builder()
                .primerNombre(usuarioDto.getPrimerNombre())
                .segundoNombre(usuarioDto.getSegundoNombre())
                .primerApellido(usuarioDto.getPrimerApellido())
                .segundoApellido(usuarioDto.getSegundoApellido())
                .telefono(usuarioDto.getTelefono())
                .correoElectronico(usuarioDto.getCorreoElectronico())
                .usuario(usuarioDto.getUsuario())
                .password(usuarioDto.getPassword())
                .rol(usuarioDto.getRol())
                .build();
    }

    public static Usuario convertirUsuarioAUsuarioDto(Usuario usuario){
        return Usuario.builder()
                .id(usuario.getId())
                .primerNombre(usuario.getPrimerNombre())
                .segundoNombre(usuario.getSegundoNombre())
                .primerApellido(usuario.getPrimerApellido())
                .segundoApellido(usuario.getSegundoApellido())
                .telefono(usuario.getTelefono())
                .correoElectronico(usuario.getCorreoElectronico())
                .usuario(usuario.getUsuario())
                .password(usuario.getPassword())
                .rol(usuario.getRol())
                .build();
    }
}
