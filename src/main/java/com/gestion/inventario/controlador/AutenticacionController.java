package com.gestion.inventario.controlador;

import com.gestion.inventario.dto.respuesta.SolicitudRespuesta;
import com.gestion.inventario.dto.solicitud.SolicitudInicio;
import com.gestion.inventario.dto.solicitud.SolicitudRegistro;
import com.gestion.inventario.servicio.AutenticacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AutenticacionController {

    @Autowired
    private AutenticacionService autenticacionService;
    @PostMapping("/signup")
    public ResponseEntity<SolicitudRespuesta> registro(@RequestBody SolicitudRegistro solicitudRegistro) {
        return ResponseEntity.ok(autenticacionService.registro(solicitudRegistro));
    }

    @PostMapping("/signin")
    public ResponseEntity<SolicitudRespuesta> inicio(@RequestBody SolicitudInicio solicitudInicio) {
        return ResponseEntity.ok(autenticacionService.inicioDeSesion(solicitudInicio));
    }
}
