package com.gestion.inventario.servicio.impl;

import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dominio.Rol;
import com.gestion.inventario.dto.RolDto;
import com.gestion.inventario.mapper.RolMapper;
import com.gestion.inventario.repositorio.RolRepository;
import com.gestion.inventario.servicio.RolService;
import com.gestion.inventario.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;

    @Override
    public Respuesta listarTodosLosRoles() {
        List<Rol> listaRols = rolRepository.findAll();
        if (listaRols.isEmpty()){
            return Utils.respuestaErorLista("rols", Utils.LISTA_VACIA);
        }else {
            return Utils.respuestaExitosaLista(Collections.singletonList(listaRols));
        }
    }

    @Override
    public Respuesta encontrarRolPorNombre(String rol) {
        validarNombreRol(rol);
        Optional<Rol> rolABuscar = rolRepository.findByNombre(rol);
        if(rolABuscar.isEmpty()){
            return Utils.respuestaEror(rol, " no existen roles con ese nombre");
        }else{
            return Utils.respuestaExitosa(rolABuscar.get().toString(), Utils.ENCONTRADO);
        }
    }

    @Override
    public Rol encontrarRolPorId(Long id) {
        validarIdRol(id);
        Optional<Rol> rolOptional = rolRepository.findById(id);
        return rolOptional.orElse(null);
    }

    @Override
    public Respuesta guardarRol(RolDto rolDto) {
        validarRolDto(rolDto);
        validarNombreRol(rolDto.getNombre().toString());
        Rol rol = RolMapper.convertirRolDtoARol(rolDto);
        rolRepository.save(rol);
        return Utils.respuestaExitosa(rol.getId().toString(),  Utils.CREACION_EXITOSA);
    }

    @Override
    public Respuesta modificarRol(RolDto rolDto) {
        validarRolDto(rolDto);
        validarIdRol(rolDto.getId());
        validarNombreRol(rolDto.getNombre().toString());
        Rol rolAEncontrar = encontrarRolPorId(rolDto.getId());
        Rol rol = RolMapper.convertirRolDtoARol(rolDto);
        rol.setId(rolDto.getId());
        rolRepository.save(rol);
        return Utils.respuestaExitosa(rol.getId().toString(),  Utils.MODIFICACION_EXITOSA);
    }

    @Override
    public Respuesta eliminarRol(RolDto rolDto) {
        validarRolDto(rolDto);
        validarIdRol(rolDto.getId());
        validarNombreRol(rolDto.getNombre().toString());
        Rol rolAEncontrar = encontrarRolPorId(rolDto.getId());
        rolRepository.delete(rolAEncontrar);
        return Utils.respuestaExitosa(rolAEncontrar.getId().toString(),  Utils.ELIMNACION_EXITOSA);
    }

    @Override
    public Respuesta validarRolDto(RolDto rolDto) {
        if (!Utils.esUnObjeto(rolDto)){
            return  Utils.respuestaEror(rolDto.getId().toString(), " el rol no puede estar vacia");
        }
        return null;
    }

    @Override
    public Respuesta validarIdRol(Long id) {
        if(!Utils.esNumerico(id.toString())){
            return Utils.respuestaEror(id.toString(), " no existen roles con ese id");
        }
        return null;
    }

    @Override
    public Respuesta validarNombreRol(String rol) {
        if (!Utils.esUnObjeto(rol)){
            return Utils.respuestaEror(rol, " no existen roles con ese nombre");
        }
        return null;
    }}
