package com.gestion.inventario.controlador;

import com.gestion.inventario.dto.RolDto;
import com.gestion.inventario.servicio.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/rols")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listAllRols() throws Exception {
        return ResponseEntity.ok().body(rolService.listarTodosLosRoles());
    }

    @GetMapping("/findrolbyname")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findRolByName(@RequestParam("name") String name) throws Exception {
        return ResponseEntity.ok().body(rolService.encontrarRolPorNombre(name));
    }

    @PostMapping("/createrol")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNewRol(@RequestBody RolDto rolDto) throws Exception {
        return ResponseEntity.ok().body(rolService.guardarRol(rolDto));
    }

    @PutMapping("/modifyrol")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> modifyARol(@RequestBody RolDto rolDto) throws Exception {
        return ResponseEntity.ok().body(rolService.modificarRol(rolDto));
    }

    @DeleteMapping("/deleterol")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteRol(@RequestBody RolDto rolDto){
        return ResponseEntity.ok().body(rolService.eliminarRol(rolDto));
    }
}
