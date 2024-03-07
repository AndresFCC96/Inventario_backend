package com.gestion.inventario.controlador;

import com.gestion.inventario.dto.AccionesDto;
import com.gestion.inventario.servicio.AccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario/actions")
public class AccionesController {

    @Autowired
    private AccionesService accionesService;

    @GetMapping("/getactions")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listarTodasLasAcciones(){
        return ResponseEntity.ok().body(accionesService.listarTodasLasAcciones());
    }

    @PostMapping("/createaction")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> guardarUnaAccion(@RequestBody AccionesDto accionesDto){
        return ResponseEntity.ok().body(accionesService.guardarAccion(accionesDto));
    }

    @PutMapping("/modifyaction")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> modificarUnaAccion(@RequestBody AccionesDto accionesDto){
        return ResponseEntity.ok().body(accionesService.modificarAccion(accionesDto));
    }

    @DeleteMapping("/deleteaction")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> eliminarUnaAccion(@RequestBody AccionesDto accionesDto){
        return ResponseEntity.ok().body(accionesService.eliminarAccion(accionesDto));
    }

}
