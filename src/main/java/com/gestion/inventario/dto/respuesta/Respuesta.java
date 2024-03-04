package com.gestion.inventario.dto.respuesta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {
    private String identificator;
    private String codError;
    private String msjError;
}
