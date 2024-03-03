package com.gestion.inventario.utils;

import com.gestion.inventario.dominio.Respuesta;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static String CREACION_EXITOSA = "La creación del objecto ha sido satisfactoria";

    public static String MODIFICACION_EXITOSA = "La modificacion del objecto ha sido satisfactoria";

    public static String ELIMNACION_EXITOSA = "La eliminacion del objecto ha sido satisfactoria";

    public static String MENSAJE_DE_ERROR = "Ha ocurrido un error ";

    public static String LISTA_VACIA = "La lista esta vacia";

    public static String LISTA = "Se encontraron varias objetos en esta lista";

    public static boolean esNumerico(String word) {
        boolean ret = false;
        Pattern pat = Pattern.compile("[^0-9',.\\s]");
        Matcher mat = pat.matcher(word);
        if (!mat.find()) {
            ret = true;
        }
        return ret;
    }

    public static boolean contieneSoloLetras(String word) {
        boolean ret = false;
        Pattern pat = Pattern.compile("[^A-Za-z',.\\s]");
        Matcher mat = pat.matcher(word);
        if (!mat.find()) {
            ret = true;
        }
        return ret;
    }

    public static boolean esUnaCadenaDeTexto(String word){
        return !word.trim().isEmpty();
    }

    public static boolean esUnObjeto(Object object){
        return object != null;
    }

    public static boolean esUnEmailValido(String email){
        boolean allowLocal = true;
        return EmailValidator.getInstance(allowLocal).isValid(email);
    }

    public static boolean esUnPasswordValido(String password){
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            return false;
        }
        Matcher m = p.matcher(password);
        return m.matches();
    }

    public static Respuesta respuestaExitosa(String id, String objeto, String metodo){
        return Respuesta.builder()
                .identificator(objeto)
                .codError("1: Éxito")
                .msjError(metodo)
                .build();
    }


    public static Respuesta respuestaExitosaLista(List<Object> lista){
        return Respuesta.builder()
                .identificator(lista.toString())
                .codError("1: Éxito")
                .msjError(LISTA)
                .build();
    }

    public static Respuesta respuestaEror(String id, String objeto, String mensajeError){
        return Respuesta.builder()
                .identificator(objeto)
                .codError("0: Error")
                .msjError(MENSAJE_DE_ERROR + mensajeError)
                .build();
    }

    public static Respuesta respuestaErorLista(String entidad, String mensajeError){
        return Respuesta.builder()
                .identificator("No hay objetos en la lista" + entidad)
                .codError("0: Error")
                .msjError(LISTA_VACIA)
                .build();
    }
}
