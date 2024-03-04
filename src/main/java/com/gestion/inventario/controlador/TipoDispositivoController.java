package com.gestion.inventario.controlador;

import com.gestion.inventario.dto.TipoDispositivoDto;
import com.gestion.inventario.servicio.TipoDispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario/devicetype")
public class TipoDispositivoController {

    @Autowired
    private TipoDispositivoService tipoDispositivoService;

    @GetMapping("/devicestypes")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listAllDeviceTypes() throws Exception {
        return ResponseEntity.ok().body(tipoDispositivoService.listarTodosLosTiposDipositivos());
    }

    @GetMapping("/finddevicestypebyname")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findDeviceTypeByName(@RequestParam("name") String name) throws Exception {
        return ResponseEntity.ok().body(tipoDispositivoService.encontrarTipoDispositivoPorNombre(name));
    }

    @PostMapping("/createdevicestype")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNewDeviceType(@RequestBody TipoDispositivoDto tipoDispositivoDto) throws Exception {
        return ResponseEntity.ok().body(tipoDispositivoService.guardarTipoDispositivo(tipoDispositivoDto));
    }

    @PutMapping("/modifydevicestype")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> modifyADeviceType(@RequestBody TipoDispositivoDto tipoDispositivoDto) throws Exception {
        return ResponseEntity.ok().body(tipoDispositivoService.modificarTipoDispositivo(tipoDispositivoDto));
    }

    @DeleteMapping("/deletedevicestype")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteDeviceType(@RequestBody TipoDispositivoDto tipoDispositivoDto){
        return ResponseEntity.ok().body(tipoDispositivoService.eliminarTipoDispositivo(tipoDispositivoDto));
    }
}
