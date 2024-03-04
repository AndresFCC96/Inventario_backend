package com.gestion.inventario.utils;

import com.gestion.inventario.dominio.Dispositivo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneradorCSV {

    private static final String CSV_CABECERA = "Id,nombre,usuario,area,estadoDispositivo,tipoDispositivo,fabricante,modelo,numeroDeSerie,numeroDeInventario,comentario";

    public String generarCsv(List<Dispositivo> dispositivos) {
        StringBuilder csvContent = new StringBuilder();
        csvContent.append(CSV_CABECERA);


        for (Dispositivo dispositivo : dispositivos) {
            csvContent.append(dispositivo.getId()).append(",")
                    .append(dispositivo.getNombre()).append(",")
                    .append(dispositivo.getUsuario()).append(",")
                    .append(dispositivo.getArea()).append(",")
                    .append(dispositivo.getEstadoDispositivo())
                    .append(dispositivo.getTipoDispositivo())
                    .append(dispositivo.getFabricante())
                    .append(dispositivo.getModelo())
                    .append(dispositivo.getNumeroDeSerie())
                    .append(dispositivo.getNumeroDeInventario())
                    .append(dispositivo.getComentario())
                    .append("\n");
        }

        return csvContent.toString();
    }

}
