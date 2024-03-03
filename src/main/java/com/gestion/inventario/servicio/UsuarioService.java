package com.gestion.inventario.servicio;

import com.gestion.inventario.dominio.Usuario;
import com.gestion.inventario.dto.UsuarioDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    List<Usuario> listarTodosLosUsuarios() throws Exception;

    Usuario encontrarUsuarioPorEmail(String email) throws Exception;

    Usuario encontrarUsuarioPorUsario(String email) throws Exception;

    Usuario encontrarUsuarioPorId(String id) throws Exception;

    Usuario modifyUser(UsuarioDto usuarioDto) throws Exception;
}
