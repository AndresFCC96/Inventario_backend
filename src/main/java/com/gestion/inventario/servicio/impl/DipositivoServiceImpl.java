package com.gestion.inventario.servicio.impl;

import com.gestion.inventario.dominio.Dispositivo;
import com.gestion.inventario.dominio.Respuesta;
import com.gestion.inventario.dto.DispositivoDto;
import com.gestion.inventario.mapper.DispositivoMapper;
import com.gestion.inventario.repositorio.DispositivoRepository;
import com.gestion.inventario.servicio.DispositivoService;
import com.gestion.inventario.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DipositivoServiceImpl implements DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Override
    public Respuesta listarTodosLosDispositivos() {
        List<Dispositivo> listaDispositivos = dispositivoRepository.findAll();
        if (listaDispositivos.isEmpty()){
            return Utils.respuestaErorLista("dipositivos", Utils.LISTA_VACIA);
        }else {
            return Utils.respuestaExitosaLista(Collections.singletonList(listaDispositivos));
        }
    }

    @Override
    public Respuesta encontrarDispositivoPorNombre(String nombre) {
        validarNombre(nombre);
        Optional<Dispositivo> dispositivoABuscar = dispositivoRepository.findByNombre(nombre);
        if(dispositivoABuscar.isEmpty()){
            return Utils.respuestaEror(nombre, " no existen dispositivos con ese nombre");
        }else{
            return Utils.respuestaExitosa(dispositivoABuscar.get().toString(), Utils.ENCONTRADO);
        }
    }

    @Override
    public Respuesta encontrarDispositivoPorModelo(String modelo) {
        validarDispositivoPorModelo(modelo);
        Optional<Dispositivo> dispositivoABuscar = dispositivoRepository.findByModelo(modelo);
        if(dispositivoABuscar.isEmpty()){
            return Utils.respuestaEror(modelo, " no existen dispositivos con ese modelo");
        }else{
            return Utils.respuestaExitosa(dispositivoABuscar.get().toString(), Utils.ENCONTRADO);
        }
    }

    @Override
    public Respuesta encontrarDispositivoPorNumeroDeSerie(String numeroDeSerie) {
        validarDispositivoPorModelo(numeroDeSerie);
        Optional<Dispositivo> dispositivoABuscar = dispositivoRepository.findByNumeroDeSerie(numeroDeSerie);
        if(dispositivoABuscar.isEmpty()){
            return Utils.respuestaEror(numeroDeSerie, " no existen dispositivos con ese numero de serie");
        }else{
            return Utils.respuestaExitosa(dispositivoABuscar.get().toString(), Utils.ENCONTRADO);
        }
    }

    @Override
    public Respuesta encontrarDispositivoPorNumeroDeInventario(Long Inventario) {
        validarDispositivoPorNumeroDeInventario(Inventario);
        Optional<Dispositivo> dispositivoABuscar = dispositivoRepository.findByNumeroDeInventario(Inventario);
        if(dispositivoABuscar.isEmpty()){
            return Utils.respuestaEror(Inventario.toString(), " no existen dispositivos con ese numero de serie");
        }else{
            return Utils.respuestaExitosa(dispositivoABuscar.get().toString(), Utils.ENCONTRADO);
        }
    }


    @Override
    public Respuesta encontrarDispositivoPorId(Long id) {
        validarIdDispositivo(id);
        Optional<Dispositivo> dispositivoABuscar = dispositivoRepository.findById(id);
        if(dispositivoABuscar.isEmpty()){
            return Utils.respuestaEror(id.toString(), " no existen dispositivos con ese numero de id");
        }else{
            return Utils.respuestaExitosa(dispositivoABuscar.get().toString(), Utils.ENCONTRADO);
        }
    }

    @Override
    public Respuesta guardarDispositivo(DispositivoDto dispositivoDto) {
        validarDispositivoDto(dispositivoDto);
        validarNombre(dispositivoDto.getNombre());
        validarDispositivoPorModelo(dispositivoDto.getModelo());
        validarDispositivoPorNumeroDeInventario(dispositivoDto.getNumeroDeInventario());
        validarDispositivoPorNumeroDeSerie(dispositivoDto.getNumeroDeSerie());
        dispositivoRepository.save(DispositivoMapper.convertirDispositivoDtoADispositivo(dispositivoDto));
        return Utils.respuestaExitosa(DispositivoMapper.convertirDispositivoDtoADispositivo(dispositivoDto).toString(), Utils.CREACION_EXITOSA);
    }

    @Override
    public Respuesta modificarDispositivo(DispositivoDto dispositivoDto) {
        validarDispositivoDto(dispositivoDto);
        validarIdDispositivo(dispositivoDto.getId());
        validarNombre(dispositivoDto.getNombre());
        validarDispositivoPorModelo(dispositivoDto.getModelo());
        validarDispositivoPorNumeroDeInventario(dispositivoDto.getNumeroDeInventario());
        validarDispositivoPorNumeroDeSerie(dispositivoDto.getNumeroDeSerie());
        Optional<Dispositivo> dispositivo = dispositivoRepository.findById(dispositivoDto.getId());
        if (dispositivo.isEmpty()){
            return Utils.respuestaEror(dispositivoDto.toString(), " no existen dispositivos con ese numero de id");
        }else{
            Dispositivo dispositivoAGuardar = dispositivo.get();
            dispositivoAGuardar = DispositivoMapper.convertirDispositivoDtoADispositivo(dispositivoDto);
            dispositivoAGuardar.setId(dispositivoDto.getId());
            dispositivoRepository.save(dispositivoAGuardar);
            return Utils.respuestaExitosa(dispositivoAGuardar.toString(), Utils.MODIFICACION_EXITOSA);
        }
    }

    @Override
    public Respuesta eliminarDispositivo(DispositivoDto dispositivoDto) {
        validarDispositivoDto(dispositivoDto);
        validarIdDispositivo(dispositivoDto.getId());
        Optional<Dispositivo> dispositivo = dispositivoRepository.findById(dispositivoDto.getId());
        if (dispositivo.isEmpty()){
            return Utils.respuestaEror(dispositivoDto.toString(), " no existen dispositivos con ese numero de id");
        }else{
            dispositivoRepository.delete(dispositivo.get());
            return Utils.respuestaExitosa(dispositivoDto.toString(), Utils.ELIMNACION_EXITOSA);
        }

    }

    @Override
    public Respuesta validarDispositivoDto(DispositivoDto dispositivoDto) {
        if (!Utils.esUnObjeto(dispositivoDto)){
            return  Utils.respuestaEror(dispositivoDto.getId().toString(), " el area no puede estar vacia");
        }
        return null;
    }

    @Override
    public Respuesta validarIdDispositivo(Long id) {
        if(!Utils.esNumerico(id.toString())){
            return Utils.respuestaEror(id.toString(), " no existen dispositivos con ese id");
        }
        return null;
    }

    @Override
    public Respuesta validarNombre(String nombre) {
        if (!Utils.esUnaCadenaDeTexto(nombre)){
            return Utils.respuestaEror(nombre, " no existen dispositivos con ese nombre");
        }
        return null;
    }

    @Override
    public Respuesta validarDispositivoPorModelo(String modelo) {
        if (!Utils.esUnaCadenaDeTexto(modelo)){
            return Utils.respuestaEror(modelo, " no existen dispositivos con ese modelo");
        }
        return null;
    }

    @Override
    public Respuesta validarDispositivoPorNumeroDeSerie(String numeroDeSerie) {
        if (!Utils.esUnaCadenaDeTexto(numeroDeSerie)){
            return Utils.respuestaEror(numeroDeSerie, " no existen dispositivos con ese nombre");
        }
        return null;
    }

    @Override
    public Respuesta validarDispositivoPorNumeroDeInventario(Long Inventario) {
        if(!Utils.esNumerico(Inventario.toString())){
            return Utils.respuestaEror(Inventario.toString(), " solo se aceptan numeros");
        }
        return null;
    }
}
