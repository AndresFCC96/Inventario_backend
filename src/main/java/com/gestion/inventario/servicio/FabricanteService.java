package com.gestion.inventario.servicio;


import com.gestion.inventario.dominio.Fabricante;
import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dto.FabricanteDto;
import org.springframework.stereotype.Service;

@Service
public interface FabricanteService {

    Respuesta listarTodosLosFabricantes();

    Respuesta encontrarFabricantePorNombre(String area);

    Fabricante encontrarFabricantePorId(Long id);

    Respuesta guardarFabricante(FabricanteDto fabricanteDto);

    Respuesta modificarFabricante(FabricanteDto fabricanteDto);

    Respuesta eliminarFabricante(FabricanteDto fabricanteDto);

    Respuesta validarFabricanteDto(FabricanteDto fabricanteDto);

    Respuesta validarIdFabricante(Long id);

    Respuesta validarNombreFabricante(String nombre);
}
