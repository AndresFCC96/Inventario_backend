package com.gestion.inventario.dto;

import com.gestion.inventario.utils.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolDto {
    private Long id;

    private Roles nombre;
}
