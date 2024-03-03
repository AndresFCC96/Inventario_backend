package com.gestion.inventario.servicio.impl;

import com.gestion.inventario.dominio.Fabricante;
import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dto.FabricanteDto;
import com.gestion.inventario.mapper.FabricanteMapper;
import com.gestion.inventario.repositorio.FabricanteRepository;
import com.gestion.inventario.servicio.FabricanteService;
import com.gestion.inventario.utils.Utils;
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
            return Utils.respuestaEror(fabricante, " fabricante"," no existen fabricantes con ese nombre");
        }else{
            return Utils.respuestaExitosa(fabricante, " fabricante", " encontrada");
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
        return Utils.respuestaExitosa(fabricante.getId().toString(), " fabricante", " creada");
    }

    @Override
    public Respuesta modificarFabricante(FabricanteDto fabricanteDto) {
        validarFabricanteDto(fabricanteDto);
        validarIdFabricante(fabricanteDto.getId());
        validarNombreFabricante(fabricanteDto.getNombre());
        Fabricante fabricanteAEncontrar = encontrarFabricantePorId(fabricanteDto.getId());
        Fabricante fabricante = FabricanteMapper.convertirFabricanteDtoAFabricante(fabricanteDto);
        fabricanteRepository.save(fabricante);
        return Utils.respuestaExitosa(fabricante.getId().toString(), " fabricante", " modicada");
    }

    @Override
    public Respuesta eliminarFabricante(FabricanteDto fabricanteDto) {
        validarFabricanteDto(fabricanteDto);
        validarIdFabricante(fabricanteDto.getId());
        validarNombreFabricante(fabricanteDto.getNombre());
        Fabricante fabricanteAEncontrar = encontrarFabricantePorId(fabricanteDto.getId());
        Fabricante fabricante = FabricanteMapper.convertirFabricanteDtoAFabricante(fabricanteDto);
        fabricanteRepository.delete(fabricante);
        return Utils.respuestaExitosa(fabricante.getId().toString(), " fabricante", " eliminada");
    }

    @Override
    public Respuesta validarFabricanteDto(FabricanteDto fabricanteDto) {
        if (!Utils.esUnObjeto(fabricanteDto)){
            return  Utils.respuestaEror("fabricante", fabricanteDto.getId().toString(), " el fabricante no puede estar vacia");
        }
        return null;
    }

    @Override
    public Respuesta validarIdFabricante(Long id) {
        if(!Utils.esNumerico(id.toString())){
            return Utils.respuestaEror(id.toString(), " fabricante"," no existen fabricantes con ese id");
        }
        return null;
    }

    @Override
    public Respuesta validarNombreFabricante(String nombre) {
        if (!Utils.esUnaCadenaDeTexto(nombre)){
            return Utils.respuestaEror(nombre, " fabricante"," no existen fabricantes con ese nombre");
        }
        return null;
    }
}
