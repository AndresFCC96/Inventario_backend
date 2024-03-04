package com.gestion.inventario.servicio.impl;

import com.gestion.inventario.dominio.Modelo;
import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dto.ModeloDto;
import com.gestion.inventario.mapper.ModeloMapper;
import com.gestion.inventario.repositorio.ModeloRepository;
import com.gestion.inventario.servicio.ModeloService;
import com.gestion.inventario.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ModeloServiceImpl implements ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;

    @Override
    public Respuesta listarTodosLosModelos() {
        List<Modelo> listaModelos = modeloRepository.findAll();
        if (listaModelos.isEmpty()){
            return Utils.respuestaErorLista("modelos", Utils.LISTA_VACIA);
        }else {
            return Utils.respuestaExitosaLista(Collections.singletonList(listaModelos));
        }
    }

    @Override
    public Respuesta encontrarModeloPorNombre(String modelo) {
        validarNombreModelo(modelo);
        Optional<Modelo> modeloABuscar = modeloRepository.findByNombre(modelo);
        if(modeloABuscar.isEmpty()){
            return Utils.respuestaEror(modelo, " no existen modelos con ese nombre");
        }else{
            return Utils.respuestaExitosa(modeloABuscar.get().toString(), Utils.ENCONTRADO);
        }
    }

    @Override
    public Modelo encontrarModeloPorId(Long id) {
        validarIdModelo(id);
        Optional<Modelo> modeloOptional = modeloRepository.findById(id);
        return modeloOptional.orElse(null);
    }

    @Override
    public Respuesta guardarModelo(ModeloDto modeloDto) {
        validarModeloDto(modeloDto);
        validarNombreModelo(modeloDto.getNombre());
        Modelo modelo = ModeloMapper.convertirModeloDtoAModelo(modeloDto);
        modeloRepository.save(modelo);
        return Utils.respuestaExitosa(modelo.getId().toString(),  Utils.CREACION_EXITOSA);
    }

    @Override
    public Respuesta modificarModelo(ModeloDto modeloDto) {
        validarModeloDto(modeloDto);
        validarIdModelo(modeloDto.getId());
        validarNombreModelo(modeloDto.getNombre());
        Modelo modeloAEncontrar = encontrarModeloPorId(modeloDto.getId());
        Modelo modelo = ModeloMapper.convertirModeloDtoAModelo(modeloDto);
        modelo.setId(modeloDto.getId());
        modeloRepository.save(modelo);
        return Utils.respuestaExitosa(modelo.getId().toString(),  Utils.MODIFICACION_EXITOSA);
    }

    @Override
    public Respuesta eliminarModelo(ModeloDto modeloDto) {
        validarModeloDto(modeloDto);
        validarIdModelo(modeloDto.getId());
        validarNombreModelo(modeloDto.getNombre());
        Modelo modeloAEncontrar = encontrarModeloPorId(modeloDto.getId());
        modeloRepository.delete(modeloAEncontrar);
        return Utils.respuestaExitosa(modeloAEncontrar.getId().toString(),  Utils.ELIMNACION_EXITOSA);
    }

    @Override
    public Respuesta validarModeloDto(ModeloDto modeloDto) {
        if (!Utils.esUnObjeto(modeloDto)){
            return  Utils.respuestaEror(modeloDto.getId().toString(), " el modelo no puede estar vacia");
        }
        return null;
    }

    @Override
    public Respuesta validarIdModelo(Long id) {
        if(!Utils.esNumerico(id.toString())){
            return Utils.respuestaEror(id.toString(), " no existen modelos con ese id");
        }
        return null;
    }

    @Override
    public Respuesta validarNombreModelo(String nombre) {
        if (!Utils.esUnaCadenaDeTexto(nombre)){
            return Utils.respuestaEror(nombre, " no existen modelos con ese nombre");
        }
        return null;
    }
}
