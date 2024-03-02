package com.gestion.inventario.servicio;

import com.gestion.inventario.dto.respuesta.SolicitudRespuesta;
import com.gestion.inventario.dto.solicitud.SolicitudInicio;
import com.gestion.inventario.dto.solicitud.SolicitudRegistro;
import org.springframework.stereotype.Service;

@Service
public interface AutenticacionService {

    SolicitudRespuesta registro(SolicitudRegistro solicitudRegistro);

    SolicitudRespuesta inicioDeSesion(SolicitudInicio solicitudInicio);
}
