package com.gestion.inventario.servicio.impl;

import com.gestion.inventario.dominio.EstadoDispositivo;
import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dto.EstadoDispositivoDto;
import com.gestion.inventario.mapper.EstadosDispositivoMapper;
import com.gestion.inventario.repositorio.EstadoDispositivoRepository;
import com.gestion.inventario.servicio.EstadoDispositivoService;
import com.gestion.inventario.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoDispositivoServiceImpl implements EstadoDispositivoService {
    @Autowired
    private EstadoDispositivoRepository estadoDispositivoRepository;

    @Override
    public Respuesta listarTodosLosEstadosDispositivo() {
        List<EstadoDispositivo> listaEstadoDispositivos = estadoDispositivoRepository.findAll();
        if (listaEstadoDispositivos.isEmpty()){
            return Utils.respuestaErorLista("estadoDispositivos", Utils.LISTA_VACIA);
        }else {
            return Utils.respuestaExitosaLista(Collections.singletonList(listaEstadoDispositivos));
        }
    }

    @Override
    public Respuesta encontrarEstadoDispositivoPorNombre(String estadoDispositivo) {
        validarNombreEstadoDispositivo(estadoDispositivo);
        Optional<EstadoDispositivo> estadoDispositivoABuscar = estadoDispositivoRepository.findByNombre(estadoDispositivo);
        if(estadoDispositivoABuscar.isEmpty()){
            return Utils.respuestaEror(estadoDispositivo, " no existen estadoDispositivos con ese nombre");
        }else{
            return Utils.respuestaExitosa(estadoDispositivoABuscar.get().toString(), Utils.ENCONTRADO);
        }
    }

    @Override
    public EstadoDispositivo encontrarEstadoDispositivoPorId(Long id) {
        validarIdEstadoDispositivo(id);
        Optional<EstadoDispositivo> estadoDispositivoOptional = estadoDispositivoRepository.findById(id);
        return estadoDispositivoOptional.orElse(null);
    }

    @Override
    public Respuesta guardarEstadoDispositivo(EstadoDispositivoDto estadoDispositivoDto) {
        validarEstadoDispositivoDto(estadoDispositivoDto);
        validarNombreEstadoDispositivo(estadoDispositivoDto.getNombre());
        EstadoDispositivo estadoDispositivo = EstadosDispositivoMapper.convertirEstadoDispositivoDtoAEstadoDispositivo(estadoDispositivoDto);
        estadoDispositivoRepository.save(estadoDispositivo);
        return Utils.respuestaExitosa(estadoDispositivo.getId().toString(),  Utils.CREACION_EXITOSA);
    }

    @Override
    public Respuesta modificarEstadoDispositivo(EstadoDispositivoDto estadoDispositivoDto) {
        validarEstadoDispositivoDto(estadoDispositivoDto);
        validarIdEstadoDispositivo(estadoDispositivoDto.getId());
        validarNombreEstadoDispositivo(estadoDispositivoDto.getNombre());
        EstadoDispositivo estadoDispositivoAEncontrar = encontrarEstadoDispositivoPorId(estadoDispositivoDto.getId());
        EstadoDispositivo estadoDispositivo = EstadosDispositivoMapper.convertirEstadoDispositivoDtoAEstadoDispositivo(estadoDispositivoDto);
        estadoDispositivo.setId(estadoDispositivoDto.getId());
        estadoDispositivoRepository.save(estadoDispositivo);
        return Utils.respuestaExitosa(estadoDispositivo.getId().toString(),  Utils.MODIFICACION_EXITOSA);
    }

    @Override
    public Respuesta eliminarEstadoDispositivo(EstadoDispositivoDto estadoDispositivoDto) {
        validarEstadoDispositivoDto(estadoDispositivoDto);
        validarIdEstadoDispositivo(estadoDispositivoDto.getId());
        validarNombreEstadoDispositivo(estadoDispositivoDto.getNombre());
        EstadoDispositivo estadoDispositivoAEncontrar = encontrarEstadoDispositivoPorId(estadoDispositivoDto.getId());
        estadoDispositivoRepository.delete(estadoDispositivoAEncontrar);
        return Utils.respuestaExitosa(estadoDispositivoAEncontrar.getId().toString(),  Utils.ELIMNACION_EXITOSA);
    }

    @Override
    public Respuesta validarEstadoDispositivoDto(EstadoDispositivoDto estadoDispositivoDto) {
        if (!Utils.esUnObjeto(estadoDispositivoDto)){
            return  Utils.respuestaEror(estadoDispositivoDto.getId().toString(), " el estadoDispositivo no puede estar vacia");
        }
        return null;
    }

    @Override
    public Respuesta validarIdEstadoDispositivo(Long id) {
        if(!Utils.esNumerico(id.toString())){
            return Utils.respuestaEror(id.toString(), " no existen estadoDispositivos con ese id");
        }
        return null;
    }

    @Override
    public Respuesta validarNombreEstadoDispositivo(String nombre) {
        if (!Utils.esUnaCadenaDeTexto(nombre)){
            return Utils.respuestaEror(nombre, " no existen estadoDispositivos con ese nombre");
        }
        return null;
    }
}
