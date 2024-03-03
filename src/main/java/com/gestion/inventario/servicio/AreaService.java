package com.gestion.inventario.servicio;

import com.gestion.inventario.dominio.Area;
import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dto.AreaDto;
import org.springframework.stereotype.Service;

@Service
public interface AreaService  {

    Respuesta listarTodasLasAreas();

    Respuesta encontrarAreaPorNombre(String area);

    Area encontrarAreaPorId(Long id);

    Respuesta guardarArea(AreaDto areaDto);

    Respuesta modificarArea(AreaDto areaDto);

    Respuesta eliminarArea(AreaDto areaDto);

    Respuesta validarAreaDto(AreaDto areaDto);

    Respuesta validarIdArea(Long id);
    Respuesta validarNombreArea(String nombre);
}
