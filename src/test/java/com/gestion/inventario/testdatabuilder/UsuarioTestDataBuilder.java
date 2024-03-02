package com.gestion.inventario.testdatabuilder;

import com.gestion.inventario.dominio.Rol;
import com.gestion.inventario.dominio.Usuario;

public class UsuarioTestDataBuilder {

    private Long id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String correoElectronico;
    private String telefono;
    private String usuario;
    private String password;
    private Rol rol;

    public UsuarioTestDataBuilder(){
        primerNombre = "Pablo";
        segundoNombre = "Andres";
        primerApellido = "Tejada";
        segundoApellido = "Mendoza";
        correoElectronico = "pablo@inventory.com";
        telefono = "3169446263";
        usuario = "paanteme";
        password = "Prius_1212345";
        rol = Rol.ADMINISTRADOR;
    }

    public UsuarioTestDataBuilder usuarioConId(Long id){
        this.id = id;
        return this;
    }

    public UsuarioTestDataBuilder usuarioConPrimerNombre(String primerNombre){
        this.primerNombre = primerNombre;
        return this;
    }

    public UsuarioTestDataBuilder usuarioConSegundoNombre(String segundoNombre){
        this.segundoNombre = segundoNombre;
        return this;
    }

    public UsuarioTestDataBuilder usuarioConPrimerApellido(String primerApellido){
        this.primerApellido = primerApellido;
        return this;
    }

    public UsuarioTestDataBuilder usuarioConSegundoApellido(String segundoApellido){
        this.segundoApellido = segundoApellido;
        return this;
    }

    public UsuarioTestDataBuilder usuarioConCorreoElectronico(String correoElectronico){
        this.correoElectronico = correoElectronico;
        return this;
    }

    public UsuarioTestDataBuilder usuarioConTelefono(String telefono){
        this.telefono = telefono;
        return this;
    }

    public UsuarioTestDataBuilder usuarioConUsuario(String usuario){
        this.usuario = usuario;
        return this;
    }

    public UsuarioTestDataBuilder usuarioConPassword(String password){
        this.password = password;
        return this;
    }

    public UsuarioTestDataBuilder usuarioConRol(Rol rol){
        this.rol = rol;
        return this;
    }


    public Usuario build() {
        return new Usuario(
                id,
                primerNombre,
                segundoNombre,
                primerApellido,
                segundoApellido,
                correoElectronico,
                telefono,
                usuario,
                password,
                rol
        );}
}
