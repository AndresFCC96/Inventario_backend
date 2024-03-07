package com.gestion.inventario.servicio.impl;

import com.gestion.inventario.dominio.Acciones;
import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dominio.Rol;
import com.gestion.inventario.dto.AccionesDto;
import com.gestion.inventario.mapper.AccionMapper;
import com.gestion.inventario.repositorio.AccionRepository;
import com.gestion.inventario.servicio.AccionesService;
import com.gestion.inventario.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccionesServiceImpl implements AccionesService {

    @Autowired
    private AccionRepository accionRepository;

    @Override
    public Respuesta listarTodasLasAcciones() {
        List<Acciones> listarTodasLasAcciones = accionRepository.findAll();
        if (listarTodasLasAcciones.isEmpty()){
            return Utils.respuestaErorLista("Acciones", " no hay ninguna accion disponible");
        }else {
            return Utils.respuestaExitosaLista(Collections.singletonList(listarTodasLasAcciones));
        }
    }

    @Override
    public Respuesta guardarAccion(AccionesDto accionesDto) {
        validarAccionDto(accionesDto);
        validarNombreAccion(accionesDto.getNombreAccion());
        validarRol(accionesDto.getRol());
        Acciones accion = AccionMapper.convertirAccionDtoAAccion(accionesDto);
        accionRepository.save(accion);
        return Utils.respuestaExitosa(accion.toString(), Utils.CREACION_EXITOSA);
    }

    @Override
    public Respuesta modificarAccion(AccionesDto accionesDto) {
        validarAccionDto(accionesDto);
        validarIdAccion(accionesDto.getId());
        validarNombreAccion(accionesDto.getNombreAccion());
        validarRol(accionesDto.getRol());
        Optional<Acciones> accionABuscar = accionRepository.findById(accionesDto.getId());
        if (accionABuscar.isEmpty()){
            return Utils.respuestaEror(accionABuscar.get().toString(), " la accion que se quiere modificar no existe con ese id" );
        }else {
            Acciones accionAModificar = accionABuscar.get();
            accionAModificar = AccionMapper.convertirAccionDtoAAccion(accionesDto);
            accionAModificar.setId(accionesDto.getId());
            accionRepository.save(accionAModificar);
            return Utils.respuestaExitosa(accionesDto.toString(), Utils.MODIFICACION_EXITOSA);
        }
    }

    @Override
    public Respuesta eliminarAccion(AccionesDto accionesDto) {
        validarAccionDto(accionesDto);
        validarIdAccion(accionesDto.getId());
        Optional<Acciones> accionesAElmiminar = accionRepository.findById(accionesDto.getId());
        if(accionesAElmiminar.isEmpty()){
            return Utils.respuestaEror(accionesDto.toString(), " la accion que se quiere eliminar no existe con ese id");
        }else{
            accionRepository.delete(accionesAElmiminar.get());
            return Utils.respuestaExitosa(accionesAElmiminar.toString(), Utils.ELIMNACION_EXITOSA);
        }
    }

    @Override
    public Respuesta validarAccionDto(AccionesDto accionesDto) {
        if(!Utils.esUnObjeto(accionesDto)){
            return Utils.respuestaEror(accionesDto.toString(), " la accion que se quiere crear no es valida");
        }
        return null;
    }

    @Override
    public Respuesta validarIdAccion(Long id) {
        if(!Utils.esNumerico(id.toString())){
            return Utils.respuestaEror(id.toString(), " el id con el que se esta buscando la accion no es valido");
        }
        return null;
    }

    @Override
    public Respuesta validarNombreAccion(String nombre) {
        if(!Utils.esUnaCadenaDeTexto(nombre)){
            return Utils.respuestaEror(nombre, " el nombre de la accion no es valido");
        }
        return null;
    }

    @Override
    public Respuesta validarRol(String rol) {
        if(!Utils.esUnObjeto(rol)){
            return Utils.respuestaEror(rol.toString(), " el rol que esta tratando de asignar no existe");
        }
        return null;
    }
}
