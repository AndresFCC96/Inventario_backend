package com.gestion.inventario.controlador;

import com.gestion.inventario.dto.ModeloDto;
import com.gestion.inventario.servicio.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario/model")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping("/models")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listAllModels() throws Exception {
        return ResponseEntity.ok().body(modeloService.listarTodosLosModelos());
    }

    @GetMapping("/findmodelbyname")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findModelByName(@RequestParam("name") String name) throws Exception {
        return ResponseEntity.ok().body(modeloService.encontrarModeloPorNombre(name));
    }

    @PostMapping("/createmodel")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNewModel(@RequestBody ModeloDto modeloDto) throws Exception {
        return ResponseEntity.ok().body(modeloService.guardarModelo(modeloDto));
    }

    @PutMapping("/modifymodel")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> modifyAModel(@RequestBody ModeloDto modeloDto) throws Exception {
        return ResponseEntity.ok().body(modeloService.modificarModelo(modeloDto));
    }

    @DeleteMapping("/deletemodel")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteModel(@RequestBody ModeloDto modeloDto){
        return ResponseEntity.ok().body(modeloService.eliminarModelo(modeloDto));
    }
}
