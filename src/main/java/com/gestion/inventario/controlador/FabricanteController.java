package com.gestion.inventario.controlador;

import com.gestion.inventario.dto.FabricanteDto;
import com.gestion.inventario.servicio.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario/manufacturer")
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;

    @GetMapping("/manufacturers")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listAllManufacturers() throws Exception {
        return ResponseEntity.ok().body(fabricanteService.listarTodosLosFabricantes());
    }

    @GetMapping("/findmanufacturerbyname")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findManufacturerByName(@RequestParam("name") String name) throws Exception {
        return ResponseEntity.ok().body(fabricanteService.encontrarFabricantePorNombre(name));
    }

    @PostMapping("/createmanufacturer")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNewManufacturer(@RequestBody FabricanteDto fabricanteDto) throws Exception {
        return ResponseEntity.ok().body(fabricanteService.guardarFabricante(fabricanteDto));
    }

    @PutMapping("/modifymanufacturer")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> modifyAManufacturer(@RequestBody FabricanteDto fabricanteDto) throws Exception {
        return ResponseEntity.ok().body(fabricanteService.modificarFabricante(fabricanteDto));
    }

    @DeleteMapping("/deletemanufacturer")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteManufacturer(@RequestBody FabricanteDto fabricanteDto){
        return ResponseEntity.ok().body(fabricanteService.eliminarFabricante(fabricanteDto));
    }
}
