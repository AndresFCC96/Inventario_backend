package com.gestion.inventario.mapper;

import com.gestion.inventario.dominio.Dispositivo;
import com.gestion.inventario.dto.DispositivoDto;
import org.springframework.stereotype.Component;

@Component
public class DispositivoMapper {

    public static Dispositivo convertirDispositivoDtoADispositivo(DispositivoDto dispositivoDto){
        return Dispositivo.builder()
                .nombre(dispositivoDto.getNombre())
                .numeroDeSerie(dispositivoDto.getNumeroDeSerie())
                .estadoDispositivo(dispositivoDto.getEstadoDispositivo())
                .area(dispositivoDto.getArea())
                .tipoDispositivo(dispositivoDto.getTipoDispositivo())
                .comentario(dispositivoDto.getComentario())
                .usuario(dispositivoDto.getUsuario())
                .fabricante(dispositivoDto.getFabricante())
                .numeroDeInventario(dispositivoDto.getNumeroDeInventario())
                .modelo(dispositivoDto.getModelo())
                .build();
    }

    public static DispositivoDto convertirDispositivoADispositivoDto(Dispositivo dispositivo){
        return DispositivoDto.builder()
                .id(dispositivo.getId())
                .nombre(dispositivo.getNombre())
                .numeroDeSerie(dispositivo.getNumeroDeSerie())
                .estadoDispositivo(dispositivo.getEstadoDispositivo())
                .area(dispositivo.getArea())
                .tipoDispositivo(dispositivo.getTipoDispositivo())
                .comentario(dispositivo.getComentario())
                .usuario(dispositivo.getUsuario())
                .fabricante(dispositivo.getFabricante())
                .numeroDeInventario(dispositivo.getNumeroDeInventario())
                .modelo(dispositivo.getModelo())
                .build();
    }
}
