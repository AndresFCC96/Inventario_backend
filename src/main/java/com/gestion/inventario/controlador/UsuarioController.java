package com.gestion.inventario.controlador;

import com.gestion.inventario.dto.UsuarioDto;
import com.gestion.inventario.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listAllUsuarios() throws Exception {
        return ResponseEntity.ok().body(usuarioService.listarTodosLosUsuarios());
    }

    @GetMapping("/findusuerbyemail")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findUsuarioByEmail(@RequestParam("correo") String correo) throws Exception {
        return ResponseEntity.ok().body(usuarioService.encontrarUsuarioPorCorreo(correo));
    }

    @GetMapping("/findusuerbyusername")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findUsuarioByUsername(@RequestParam("usuario") String usuario) throws Exception {
        return ResponseEntity.ok().body(usuarioService.encontrarUsuarioPorUsario(usuario));
    }

    @PostMapping("/createuser")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNewUser(@RequestBody UsuarioDto usuarioDto) throws Exception {
        return ResponseEntity.ok().body(usuarioService.guardarUsuario(usuarioDto));
    }

    @PutMapping("/modifyuser")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> modifyAUser(@RequestBody UsuarioDto usuarioDto) throws Exception {
        return ResponseEntity.ok().body(usuarioService.modificarUsuario(usuarioDto));
    }

    @DeleteMapping("/deleteuser")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteUser(@RequestBody UsuarioDto usuarioDto){
        return ResponseEntity.ok().body(usuarioService.eliminarUsuario(usuarioDto));
    }
}
