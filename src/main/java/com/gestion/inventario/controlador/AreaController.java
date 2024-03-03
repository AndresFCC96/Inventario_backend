package com.gestion.inventario.controlador;

import com.gestion.inventario.dto.AreaDto;
import com.gestion.inventario.servicio.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/areas")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listAllProjects() throws Exception {
        return ResponseEntity.ok().body(areaService.listarTodasLasAreas());
    }

    @GetMapping("/findareabyname")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findProjectByName(@RequestParam("name") String name) throws Exception {
        return ResponseEntity.ok().body(areaService.encontrarAreaPorNombre(name));
    }

    @PostMapping("/createarea")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNewProject(@RequestBody AreaDto areaDto) throws Exception {
        return ResponseEntity.ok().body(areaService.guardarArea(areaDto));
    }

    @PutMapping("/modifyarea")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> modifyAProject(@RequestBody AreaDto areaDto) throws Exception {
        return ResponseEntity.ok().body(areaService.modificarArea(areaDto));
    }

    @DeleteMapping("/deletearea")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteproject(@RequestBody AreaDto areaDto){
            return ResponseEntity.ok().body(areaService.eliminarArea(areaDto));
    }
}
