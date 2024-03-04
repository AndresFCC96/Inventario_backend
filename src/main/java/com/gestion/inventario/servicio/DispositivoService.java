package com.gestion.inventario.servicio;

import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dto.DispositivoDto;
import org.springframework.stereotype.Service;

@Service
public interface DispositivoService {

    Respuesta listarTodosLosDispositivos();

    Respuesta encontrarDispositivoPorNombre(String nombre);

    Respuesta encontrarDispositivoPorModelo(String modelo);

    Respuesta encontrarDispositivoPorNumeroDeSerie(String numeroDeSerie);

    Respuesta encontrarDispositivoPorNumeroDeInventario(Long Inventario);


    Respuesta encontrarDispositivoPorId(Long id);

    Respuesta guardarDispositivo(DispositivoDto dispositivoDto);

    Respuesta modificarDispositivo(DispositivoDto dispositivoDto);

    Respuesta eliminarDispositivo(DispositivoDto dispositivoDto);

    Respuesta validarDispositivoDto(DispositivoDto dispositivoDto);

    Respuesta validarIdDispositivo(Long id);

    Respuesta validarNombre(String nombre);

    Respuesta validarDispositivoPorModelo(String modelo);

    Respuesta validarDispositivoPorNumeroDeSerie(String numeroDeSerie);

    Respuesta validarDispositivoPorNumeroDeInventario(Long Inventario);


}
