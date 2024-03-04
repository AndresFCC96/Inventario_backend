package com.gestion.inventario.dominio;

import com.gestion.inventario.testdatabuilder.UsuarioTestDataBuilder;
import com.gestion.inventario.utils.Roles;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    @DisplayName("Debe crear el usuario correctamente")
    void debeCrearElUsuarioCorrectamente(){
        //Arrange
        String primerNombre = "Pablo";
        String segundoNombre = "Andres";
        String primerApellido = "Tejada";
        String segundoApellido = "Mendoza";
        String correoElectronico = "pablo@inventory.com";
        String telefono = "3169446263";
        String usuario = "paanteme";
        String password = "Prius_1212345";
        Roles rol = Roles.ADMINISTRADOR;
        //Act
        Usuario usuarioTest = new UsuarioTestDataBuilder()
                .usuarioConId(1L)
                .build();
        //Assert
        assertEquals(1, usuarioTest.getId());
        assertEquals(primerNombre, usuarioTest.getPrimerNombre());
        assertEquals(segundoNombre, usuarioTest.getSegundoNombre());
        assertEquals(primerApellido, usuarioTest.getPrimerApellido());
        assertEquals(segundoApellido, usuarioTest.getSegundoApellido());
        assertEquals(correoElectronico, usuarioTest.getCorreoElectronico());
        assertEquals(telefono, usuarioTest.getTelefono());
        assertEquals(usuario, usuarioTest.getUsuario());
        assertEquals(password, usuarioTest.getPassword());
        assertEquals(rol, usuarioTest.getRol());
    }


    @Test
    @DisplayName("Debe fallar sin el usuario es nulo")
    void debeFallarSiElUsuarioEsNulo(){
        //Arrange
        Usuario usuario = null;
        //Act-Assert
        assertNull(usuario);
    }

    @Test
    @DisplayName("Debe fallar sin id")
    void debeFallarSinElId(){
        //Arrange
        Usuario usuario = new UsuarioTestDataBuilder().
                usuarioConId(null)
                .build();
        //Act-Assert
        assertNull(usuario.getId());
    }

    @Test
    @DisplayName("Debe fallar sin el primer nombre")
    void debeFallarSinElPrimerNombre(){
        //Arrange
        Usuario usuario = new UsuarioTestDataBuilder()
                .usuarioConId(1L)
                .usuarioConPrimerNombre(null)
                .build();
        //Act-Assert
        assertNull(usuario.getPrimerNombre());
    }

    @Test
    @DisplayName("Debe fallar sin el primer apellido")
    void debeFallarSinElPrimerApellido(){
        //Arrange
        Usuario usuario = new UsuarioTestDataBuilder()
                .usuarioConId(1L)
                .usuarioConPrimerApellido(null)
                .build();
        //Act-Assert
        assertNull(usuario.getPrimerApellido());
    }
    @Test
    @DisplayName("Debe fallar sin el usuario")
    void debeFallarSinUsuario(){
        //Act
        Usuario usuario = new UsuarioTestDataBuilder()
                .usuarioConId(1L)
                .usuarioConUsuario(null).
                build();
        //Act-Assert
        assertNull(usuario.getUsername());
        assertNull(usuario.getUsuario());
    }

    @Test
    @DisplayName("Debe fallar sin el correo electronico")
    void debeFallarSinCorreoElectronico(){
        //Act
        Usuario usuario = new UsuarioTestDataBuilder()
                .usuarioConId(1L)
                .usuarioConCorreoElectronico(null).
                build();
        //Act-Assert
        assertNull(usuario.getCorreoElectronico());
    }

    @Test
    @DisplayName("Debe fallar sin el telefono")
    void debeFallarSinElTelefono(){
        //Act
        Usuario usuario = new UsuarioTestDataBuilder()
                .usuarioConId(1L)
                .usuarioConTelefono(null)
                .build();
        //Act-Assert
        assertNull(usuario.getTelefono());
    }

    @Test
    @DisplayName("Debe fallar sin password")
    void debeFallarSinPassword(){

        //Act
        Usuario usuario = new UsuarioTestDataBuilder()
                .usuarioConId(1L)
                .usuarioConPassword(null)
                .build();
        //Act-Assert
        assertNull(usuario.getPassword());
    }

    @Test
    @DisplayName("Debe fallar sin el rol")
    void debeFallarSinRol(){
        //Arrange
        Usuario usuario = new UsuarioTestDataBuilder()
                .usuarioConId(1L)
                .usuarioConRol(null)
                .build();
        //Act-Assert
        assertNull(usuario.getRol());
    }


    @Test
    @DisplayName("El Usuario no debe de haber expirado para poder generar el token")
    void elUsuarioNoDeHaberExpiradoParaPoderGenerarElToken(){
        //Act
        Usuario usuario = new UsuarioTestDataBuilder().build();
        //Assert
        assertTrue(usuario.isAccountNonExpired());
    }

    @Test
    @DisplayName("El usuario no debe de estar bloqueado")
    void elUsuarioNoDebeDeEstarBloqueado(){
        //Act
        Usuario usuario = new UsuarioTestDataBuilder().build();
        //Assert
        assertTrue(usuario.isAccountNonLocked());
    }

    @Test
    @DisplayName("El usuario debe de estar habilitado")
    void elUsuarioDebeDeEstarHabilitado(){
        //Act
        Usuario usuario = new UsuarioTestDataBuilder().build();
        //Assert
        assertTrue(usuario.isEnabled());
    }

    @Test
    @DisplayName("Las credenciales del usuario no deben de haber vencido")
    void lasCredencialesDelUsuarioNoDebenDeHaberVencido(){
        //Act
        Usuario usuario = new UsuarioTestDataBuilder().build();
        //Assert
        assertTrue(usuario.isCredentialsNonExpired());
    }

    @Test
    @DisplayName("Debe retornar la lista de privilegios")
    void debeRetornarLaListaDePrivilegios(){
        //Arrange
        String admin = "ADMINISTRADOR";
        //Act
        Usuario usuario = new UsuarioTestDataBuilder().build();
        String role =  usuario.getAuthorities().toString();
        role = role.replace("[", "").replace("]", "");
        //Assert
        assertNotNull(usuario.getAuthorities());
        assertEquals(admin, role);
    }
}
