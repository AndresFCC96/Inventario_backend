package com.gestion.inventario.servicio.impl;

import com.gestion.inventario.dominio.Usuario;
import com.gestion.inventario.dto.UsuarioDto;
import com.gestion.inventario.servicio.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Override
    public List<Usuario> listarTodosLosUsuarios() throws Exception {
        return null;
    }

    @Override
    public Usuario encontrarUsuarioPorEmail(String email) throws Exception {
        return null;
    }

    @Override
    public Usuario encontrarUsuarioPorUsario(String email) throws Exception {
        return null;
    }

    @Override
    public Usuario encontrarUsuarioPorId(String id) throws Exception {
        return null;
    }

    @Override
    public Usuario modifyUser(UsuarioDto usuarioDto) throws Exception {
        return null;
    }
}
