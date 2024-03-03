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
    public ResponseEntity<?> listAllProjects() throws Exception {
        return ResponseEntity.ok().body(fabricanteService.listarTodosLosFabricantes());
    }

    @GetMapping("/findfabricantebyname")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findProjectByName(@RequestParam("name") String name) throws Exception {
        return ResponseEntity.ok().body(fabricanteService.encontrarFabricantePorNombre(name));
    }

    @PostMapping("/createfabricante")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNewProject(@RequestBody FabricanteDto fabricanteDto) throws Exception {
        return ResponseEntity.ok().body(fabricanteService.guardarFabricante(fabricanteDto));
    }

    @PutMapping("/modifyfabricante")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> modifyAProject(@RequestBody FabricanteDto fabricanteDto) throws Exception {
        return ResponseEntity.ok().body(fabricanteService.modificarFabricante(fabricanteDto));
    }

    @DeleteMapping("/deletefabricante")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteproject(@RequestBody FabricanteDto fabricanteDto){
        return ResponseEntity.ok().body(fabricanteService.eliminarFabricante(fabricanteDto));
    }
}
