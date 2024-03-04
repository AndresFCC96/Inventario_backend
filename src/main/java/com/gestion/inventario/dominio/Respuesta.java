package com.gestion.inventario.dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta {
    private String identificator;
    private String codError;
    private String msjError;
}
