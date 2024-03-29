package com.gestion.inventario.servicio.impl;

import com.gestion.inventario.dominio.Area;
import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dto.AreaDto;
import com.gestion.inventario.mapper.AreaMapper;
import com.gestion.inventario.repositorio.AreaRepository;
import com.gestion.inventario.servicio.AreaService;
import com.gestion.inventario.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public Respuesta listarTodasLasAreas() {
        List<Area> listaAreas = areaRepository.findAll();
        if (listaAreas.isEmpty()){
            return Utils.respuestaErorLista("areas", Utils.LISTA_VACIA);
        }else {
            return Utils.respuestaExitosaLista(Collections.singletonList(listaAreas));
        }
    }

    @Override
    public Respuesta encontrarAreaPorNombre(String area) {
        validarNombreArea(area);
        Optional<Area> areaABuscar = areaRepository.findByNombre(area);
        if(areaABuscar.isEmpty()){
            return Utils.respuestaEror(area, " no existen areas con ese nombre");
        }else{
            return Utils.respuestaExitosa(areaABuscar.get().toString(), Utils.ENCONTRADO);
        }
    }

    @Override
    public Area encontrarAreaPorId(Long id) {
        validarIdArea(id);
        Optional<Area> areaOptional = areaRepository.findById(id);
        return areaOptional.orElse(null);
    }

    @Override
    public Respuesta guardarArea(AreaDto areaDto) {
        validarAreaDto(areaDto);
        validarNombreArea(areaDto.getNombre());
        Area area = AreaMapper.convertirAreaDtoAArea(areaDto);
        areaRepository.save(area);
        return Utils.respuestaExitosa(area.getId().toString(),  Utils.CREACION_EXITOSA);
    }

    @Override
    public Respuesta modificarArea(AreaDto areaDto) {
        validarAreaDto(areaDto);
        validarIdArea(areaDto.getId());
        validarNombreArea(areaDto.getNombre());
        Area areaAEncontrar = encontrarAreaPorId(areaDto.getId());
        Area area = AreaMapper.convertirAreaDtoAArea(areaDto);
        area.setId(areaDto.getId());
        areaRepository.save(area);
        return Utils.respuestaExitosa(area.getId().toString(),  Utils.MODIFICACION_EXITOSA);
    }

    @Override
    public Respuesta eliminarArea(AreaDto areaDto) {
        validarAreaDto(areaDto);
        validarIdArea(areaDto.getId());
        validarNombreArea(areaDto.getNombre());
        Area areaAEncontrar = encontrarAreaPorId(areaDto.getId());
        areaRepository.delete(areaAEncontrar);
        return Utils.respuestaExitosa(areaAEncontrar.getId().toString(),  Utils.ELIMNACION_EXITOSA);
    }

    @Override
    public Respuesta validarAreaDto(AreaDto areaDto) {
        if (!Utils.esUnObjeto(areaDto)){
            return  Utils.respuestaEror(areaDto.getId().toString(), " el area no puede estar vacia");
        }
        return null;
    }

    @Override
    public Respuesta validarIdArea(Long id) {
        if(!Utils.esNumerico(id.toString())){
            return Utils.respuestaEror(id.toString(), " no existen areas con ese id");
        }
        return null;
    }

    @Override
    public Respuesta validarNombreArea(String nombre) {
        if (!Utils.esUnaCadenaDeTexto(nombre)){
            return Utils.respuestaEror(nombre, " no existen areas con ese nombre");
        }
        return null;
    }
}
