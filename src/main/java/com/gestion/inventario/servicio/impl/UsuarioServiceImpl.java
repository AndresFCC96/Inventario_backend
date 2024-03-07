package com.gestion.inventario.servicio.impl;

import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dominio.Usuario;
import com.gestion.inventario.dto.UsuarioDto;
import com.gestion.inventario.mapper.UsuarioMapper;
import com.gestion.inventario.repositorio.UsuarioRepository;
import com.gestion.inventario.servicio.UsuarioService;
import com.gestion.inventario.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Respuesta listarTodosLosUsuarios() {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        if (listaUsuarios.isEmpty()){
            return Utils.respuestaErorLista("usuarios", Utils.LISTA_VACIA);
        }else {
            return Utils.respuestaExitosaLista(Collections.singletonList(listaUsuarios));
        }
    }

    @Override
    public Respuesta encontrarUsuarioPorCorreo(String correo) {
        validarCorreo(correo);
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCorreoElectronico(correo);
        if(usuarioOptional.isEmpty()){
            return Utils.respuestaEror(correo, " no existe usuario con ese valor");
        }else {
            return Utils.respuestaExitosa(String.valueOf(usuarioOptional.get()), Utils.ENCONTRADO);
        }
    }

    @Override
    public Respuesta encontrarUsuarioPorUsario(String usuario) {
        validarNombreDeUsuario(usuario);
        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsuario(usuario);
        if(usuarioOptional.isEmpty()){
            return Utils.respuestaEror(usuario, " no existe usuario con ese valor");
        }else {
            return Utils.respuestaExitosa(String.valueOf(usuarioOptional.get()), Utils.ENCONTRADO);
        }
    }

    @Override
    public Respuesta encontrarUsuarioPorId(Long id) {
        validarIdUsuario(id);
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isEmpty()){
            return Utils.respuestaEror(id.toString(), " no existe usuario con ese valor");
        }else {
            return Utils.respuestaExitosa(String.valueOf(usuarioOptional.get()), Utils.ENCONTRADO);
        }
    }

    @Override
    public Respuesta guardarUsuario(UsuarioDto usuarioDto) {
        validarUsuarioDto(usuarioDto);
        validarNombre(usuarioDto.getPrimerNombre(), usuarioDto.getPrimerApellido());
        validarCorreo(usuarioDto.getCorreoElectronico());
        validarTelefono(usuarioDto.getTelefono());
        validarNombreDeUsuario(usuarioDto.getUsuario());
        validatePassword(usuarioDto.getPassword());
        usuarioRepository.save(UsuarioMapper.convertirUsuarioDtoAUsuario(usuarioDto));
        return Utils.respuestaExitosa(UsuarioMapper.convertirUsuarioDtoAUsuario(usuarioDto).toString(), Utils.CREACION_EXITOSA);

    }


    @Override
    public Respuesta modificarUsuario(UsuarioDto usuarioDto) {
        validarUsuarioDto(usuarioDto);
        validarIdUsuario(usuarioDto.getId());
        validarNombre(usuarioDto.getPrimerNombre(), usuarioDto.getPrimerApellido());
        validarCorreo(usuarioDto.getCorreoElectronico());
        validarTelefono(usuarioDto.getTelefono());
        validarNombreDeUsuario(usuarioDto.getUsuario());
        validatePassword(usuarioDto.getPassword());
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioDto.getId());
        if(usuario.isEmpty()){
            return Utils.respuestaEror(usuario.get().toString(), " No existe usuario o esta");
        }else{
            Usuario usuarioAModificar = usuario.get();
            usuarioAModificar.setId(usuarioDto.getId());
            usuarioRepository.save(usuarioAModificar);
            return Utils.respuestaExitosa(usuarioAModificar.toString(), Utils.MODIFICACION_EXITOSA);
        }
    }

    @Override
    public Respuesta eliminarUsuario(UsuarioDto usuarioDto) {
        validarUsuarioDto(usuarioDto);
        validarIdUsuario(usuarioDto.getId());
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioDto.getId());
        if(usuario.isEmpty()){
            return Utils.respuestaEror(usuario.get().toString(), " No existe usuario o esta");
        }else{
            usuarioRepository.delete(usuario.get());
            return Utils.respuestaExitosa(usuario.toString(), Utils.ELIMNACION_EXITOSA);
        }
    }

    @Override
    public Respuesta validarUsuarioDto(UsuarioDto usuarioDto) {
        if (!Utils.esUnObjeto(usuarioDto)) {
            return Utils.respuestaEror(String.valueOf(usuarioDto), " no es valido o es nulo");
        }
        return null;
    }

    @Override
    public Respuesta validarIdUsuario(Long id) {
        if (!Utils.esNumerico(id.toString())) {
            return Utils.respuestaEror(id.toString(), " no es valido o es nulo");
        }
        return null;
    }

    @Override
    public Respuesta validarNombre(String primerNombre, String primerApellido) {
        if (!Utils.esUnaCadenaDeTexto(primerNombre) || !Utils.esUnaCadenaDeTexto(primerApellido)){
            return Utils.respuestaEror("nombre", " debe llevar primer nombre y primer apellido");
        }
        return null;
    }

    @Override
    public Respuesta validarTelefono(String telefono) {
        if(!Utils.esNumerico(telefono) || !Utils.esUnaCadenaDeTexto(telefono)){
            return Utils.respuestaEror(telefono, " solo se aceptan numeros");
        }
        return null;
    }

    @Override
    public Respuesta validarCorreo(String correo) {
        if (!Utils.esUnEmailValido(correo) || !Utils.esUnaCadenaDeTexto(correo)){
            return Utils.respuestaEror(correo, " no es un correo valido");
        }
        return null;
    }

    @Override
    public Respuesta validatePassword(String password) {
        if(!Utils.esUnPasswordValido(password) || !Utils.esUnaCadenaDeTexto(password)){
            return Utils.respuestaEror(password, " no cumple con los estandares de seguridad");
        }
        return null;
    }

    @Override
    public Respuesta validarNombreDeUsuario(String nombre) {
        if (!Utils.esUnEmailValido(nombre) || !Utils.esUnaCadenaDeTexto(nombre)){
            return Utils.respuestaEror(nombre, " no es un nombre de usuario valido");
        }
        return null;
    }
}
