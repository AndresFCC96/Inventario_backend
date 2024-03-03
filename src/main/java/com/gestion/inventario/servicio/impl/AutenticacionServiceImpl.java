package com.gestion.inventario.servicio.impl;

import com.gestion.inventario.dominio.Rol;
import com.gestion.inventario.utils.Roles;
import com.gestion.inventario.dominio.Usuario;
import com.gestion.inventario.dto.respuesta.SolicitudRespuesta;
import com.gestion.inventario.dto.solicitud.SolicitudInicio;
import com.gestion.inventario.dto.solicitud.SolicitudRegistro;
import com.gestion.inventario.repositorio.UsuarioRepository;
import com.gestion.inventario.servicio.AutenticacionService;
import com.gestion.inventario.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public SolicitudRespuesta registro(SolicitudRegistro solicitudRegistro) {
        Usuario usuario = com.gestion.inventario.dominio.Usuario.builder()
                .primerNombre(solicitudRegistro.getPrimerNombre())
                .segundoNombre(solicitudRegistro.getSegundoNombre())
                .primerApellido(solicitudRegistro.getPrimerApellido())
                .segundoApellido(solicitudRegistro.getSegundoApellido())
                .correoElectronico(solicitudRegistro.getCorreoElectronico())
                .telefono(solicitudRegistro.getTelefono())
                .usuario(solicitudRegistro.getUsuario())
                .password(passwordEncoder.encode(solicitudRegistro.getPassword()))
                .rol(Rol.builder().nombre(Roles.USUARIO).build())
                .build();
        usuarioRepository.save(usuario);
        var jwt = jwtUtils.generateToken(usuario);
        return SolicitudRespuesta.builder().token(jwt).build();
    }

    @Override
    public SolicitudRespuesta inicioDeSesion(SolicitudInicio solicitudInicio) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        solicitudInicio.getUsuario(),
                        solicitudInicio.getPassword()
                ));
        Usuario usuario = usuarioRepository.findByUsuario(solicitudInicio.getUsuario()).get();
        System.out.println(usuario);
//                .orElseThrow(() -> new IllegalArgumentException("Nombre de usuario o contraseña incorrecta."));
        var jwt = jwtUtils.generateToken(usuario);
        return SolicitudRespuesta.builder().token(jwt).build();
    }
}
