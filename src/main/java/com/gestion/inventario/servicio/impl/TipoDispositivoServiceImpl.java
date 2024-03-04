package com.gestion.inventario.servicio.impl;

import com.gestion.inventario.dominio.TipoDispositivo;
import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dominio.TipoDispositivo;
import com.gestion.inventario.dto.TipoDispositivoDto;
import com.gestion.inventario.dto.TipoDispositivoDto;
import com.gestion.inventario.mapper.TipoDispositivoMapper;
import com.gestion.inventario.repositorio.TipoDispositivoRepository;
import com.gestion.inventario.servicio.TipoDispositivoService;
import com.gestion.inventario.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TipoDispositivoServiceImpl implements TipoDispositivoService {

    @Autowired
    private TipoDispositivoRepository tipoDispositivoRepository;

    @Override
    public Respuesta listarTodosLosTiposDipositivos() {
        List<TipoDispositivo> listaTipoDispositivos = tipoDispositivoRepository.findAll();
        if (listaTipoDispositivos.isEmpty()){
            return Utils.respuestaErorLista("tipoDispositivos", Utils.LISTA_VACIA);
        }else {
            return Utils.respuestaExitosaLista(Collections.singletonList(listaTipoDispositivos));
        }
    }

    @Override
    public Respuesta encontrarTipoDispositivoPorNombre(String tipoDispositivo) {
        validarNombreTipoDispositivo(tipoDispositivo);
        Optional<TipoDispositivo> tipoDispositivoABuscar = tipoDispositivoRepository.findByNombre(tipoDispositivo);
        if(tipoDispositivoABuscar.isEmpty()){
            return Utils.respuestaEror(tipoDispositivo, " no existen tipoDispositivos con ese nombre");
        }else{
            return Utils.respuestaExitosa(tipoDispositivoABuscar.get().toString(), Utils.ENCONTRADO);
        }
    }

    @Override
    public TipoDispositivo encontrarTipoDispositivoPorId(Long id) {
        validarIdTipoDispositivo(id);
        Optional<TipoDispositivo> tipoDispositivoOptional = tipoDispositivoRepository.findById(id);
        return tipoDispositivoOptional.orElse(null);
    }

    @Override
    public Respuesta guardarTipoDispositivo(TipoDispositivoDto tipoDispositivoDto) {
        validarTipoDispositivoDto(tipoDispositivoDto);
        validarNombreTipoDispositivo(tipoDispositivoDto.getNombre());
        TipoDispositivo tipoDispositivo = TipoDispositivoMapper.convertirTipoDispositivoDtoATipoDispositivo(tipoDispositivoDto);
        tipoDispositivoRepository.save(tipoDispositivo);
        return Utils.respuestaExitosa(tipoDispositivo.getId().toString(),  Utils.CREACION_EXITOSA);
    }

    @Override
    public Respuesta modificarTipoDispositivo(TipoDispositivoDto tipoDispositivoDto) {
        validarTipoDispositivoDto(tipoDispositivoDto);
        validarIdTipoDispositivo(tipoDispositivoDto.getId());
        validarNombreTipoDispositivo(tipoDispositivoDto.getNombre());
        TipoDispositivo tipoDispositivoAEncontrar = encontrarTipoDispositivoPorId(tipoDispositivoDto.getId());
        TipoDispositivo tipoDispositivo = TipoDispositivoMapper.convertirTipoDispositivoDtoATipoDispositivo(tipoDispositivoDto);
        tipoDispositivo.setId(tipoDispositivoDto.getId());
        tipoDispositivoRepository.save(tipoDispositivo);
        return Utils.respuestaExitosa(tipoDispositivo.getId().toString(),  Utils.MODIFICACION_EXITOSA);
    }

    @Override
    public Respuesta eliminarTipoDispositivo(TipoDispositivoDto tipoDispositivoDto) {
        validarTipoDispositivoDto(tipoDispositivoDto);
        validarIdTipoDispositivo(tipoDispositivoDto.getId());
        validarNombreTipoDispositivo(tipoDispositivoDto.getNombre());
        TipoDispositivo tipoDispositivoAEncontrar = encontrarTipoDispositivoPorId(tipoDispositivoDto.getId());
        tipoDispositivoRepository.delete(tipoDispositivoAEncontrar);
        return Utils.respuestaExitosa(tipoDispositivoAEncontrar.getId().toString(),  Utils.ELIMNACION_EXITOSA);
    }

    @Override
    public Respuesta validarTipoDispositivoDto(TipoDispositivoDto tipoDispositivoDto) {
        if (!Utils.esUnObjeto(tipoDispositivoDto)){
            return  Utils.respuestaEror(tipoDispositivoDto.getId().toString(), " el tipoDispositivo no puede estar vacia");
        }
        return null;
    }

    @Override
    public Respuesta validarIdTipoDispositivo(Long id) {
        if(!Utils.esNumerico(id.toString())){
            return Utils.respuestaEror(id.toString(), " no existen tipoDispositivos con ese id");
        }
        return null;
    }

    @Override
    public Respuesta validarNombreTipoDispositivo(String nombre) {
        if (!Utils.esUnaCadenaDeTexto(nombre)){
            return Utils.respuestaEror(nombre, " no existen tipoDispositivos con ese nombre");
        }
        return null;
    }
}
