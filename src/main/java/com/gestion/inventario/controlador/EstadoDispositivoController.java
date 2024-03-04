package com.gestion.inventario.controlador;

import com.gestion.inventario.dto.EstadoDispositivoDto;
import com.gestion.inventario.servicio.EstadoDispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario/statusdevice")
public class EstadoDispositivoController {

    @Autowired
    private EstadoDispositivoService estadoDispositivoService;

    @GetMapping("/statusdevices")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listAllStatusDevices() throws Exception {
        return ResponseEntity.ok().body(estadoDispositivoService.listarTodosLosEstadosDispositivo());
    }

    @GetMapping("/findstatusdevicebyname")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findStatusDeviceByName(@RequestParam("name") String name) throws Exception {
        return ResponseEntity.ok().body(estadoDispositivoService.encontrarEstadoDispositivoPorNombre(name));
    }

    @PostMapping("/createstatusdevice")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNewStatusDevice(@RequestBody EstadoDispositivoDto estadoDispositivoDto) throws Exception {
        return ResponseEntity.ok().body(estadoDispositivoService.guardarEstadoDispositivo(estadoDispositivoDto));
    }

    @PutMapping("/modifystatusdevice")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> modifyAStatusDevice(@RequestBody EstadoDispositivoDto estadoDispositivoDto) throws Exception {
        return ResponseEntity.ok().body(estadoDispositivoService.modificarEstadoDispositivo(estadoDispositivoDto));
    }

    @DeleteMapping("/deletestatusdevice")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteStatusDevice(@RequestBody EstadoDispositivoDto estadoDispositivoDto){
        return ResponseEntity.ok().body(estadoDispositivoService.eliminarEstadoDispositivo(estadoDispositivoDto));
    }
}
