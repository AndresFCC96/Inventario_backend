package com.gestion.inventario.servicio.impl;

import com.gestion.inventario.dominio.Fabricante;
import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dto.FabricanteDto;
import com.gestion.inventario.mapper.FabricanteMapper;
import com.gestion.inventario.repositorio.FabricanteRepository;
import com.gestion.inventario.servicio.FabricanteService;
import com.gestion.inventario.utils.Utils;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FabricanteServiceImpl implements FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Override
    public Respuesta listarTodosLosFabricantes() {
        List<Fabricante> listaFabricantes = fabricanteRepository.findAll();
        if (listaFabricantes.isEmpty()){
            return Utils.respuestaErorLista("fabricantes", Utils.LISTA_VACIA);
        }else {
            return Utils.respuestaExitosaLista(Collections.singletonList(listaFabricantes));
        }
    }

    @Override
    public Respuesta encontrarFabricantePorNombre(String fabricante) {
        validarNombreFabricante(fabricante);
        Optional<Fabricante> fabricanteABuscar = fabricanteRepository.findByNombre(fabricante);
        if(fabricanteABuscar.isEmpty()){
            return Utils.respuestaEror(fabricante, " no existen fabricantes con ese nombre");
        }else{
            return Utils.respuestaExitosa(fabricante, Utils.ENCONTRADO);
        }
    }

    @Override
    public Fabricante encontrarFabricantePorId(Long id) {
        validarIdFabricante(id);
        Optional<Fabricante> fabricanteOptional = fabricanteRepository.findById(id);
        return fabricanteOptional.orElse(null);
    }

    @Override
    public Respuesta guardarFabricante(FabricanteDto fabricanteDto) {
        validarFabricanteDto(fabricanteDto);
        validarNombreFabricante(fabricanteDto.getNombre());
        Fabricante fabricante = FabricanteMapper.convertirFabricanteDtoAFabricante(fabricanteDto);
        fabricanteRepository.save(fabricante);
        return Utils.respuestaExitosa(fabricante.getId().toString(), Utils.CREACION_EXITOSA);
    }

    @Override
    public Respuesta modificarFabricante(FabricanteDto fabricanteDto) {
        validarFabricanteDto(fabricanteDto);
        validarIdFabricante(fabricanteDto.getId());
        validarNombreFabricante(fabricanteDto.getNombre());
        Fabricante fabricanteAEncontrar = encontrarFabricantePorId(fabricanteDto.getId());
        Fabricante fabricante = FabricanteMapper.convertirFabricanteDtoAFabricante(fabricanteDto);
        fabricanteRepository.save(fabricante);
        return Utils.respuestaExitosa(fabricante.getId().toString(), Utils.MODIFICACION_EXITOSA);
    }

    @Override
    public Respuesta eliminarFabricante(FabricanteDto fabricanteDto) {
        validarFabricanteDto(fabricanteDto);
        validarIdFabricante(fabricanteDto.getId());
        validarNombreFabricante(fabricanteDto.getNombre());
        Fabricante fabricanteAEncontrar = encontrarFabricantePorId(fabricanteDto.getId());
        fabricanteRepository.delete(fabricanteAEncontrar);
        return Utils.respuestaExitosa(fabricanteAEncontrar.getId().toString(),  Utils.ELIMNACION_EXITOSA);
    }

    @Override
    public Respuesta validarFabricanteDto(FabricanteDto fabricanteDto) {
        if (!Utils.esUnObjeto(fabricanteDto)){
            return  Utils.respuestaEror(fabricanteDto.getId().toString(), " el fabricante no puede estar vacia");
        }
        return null;
    }

    @Override
    public Respuesta validarIdFabricante(Long id) {
        if(!Utils.esNumerico(id.toString())){
            return Utils.respuestaEror(id.toString(), " no existen fabricantes con ese id");
        }
        return null;
    }

    @Override
    public Respuesta validarNombreFabricante(String nombre) {
        if (!Utils.esUnaCadenaDeTexto(nombre)){
            return Utils.respuestaEror(nombre, " no existen fabricantes con ese nombre");
        }
        return null;
    }
}
