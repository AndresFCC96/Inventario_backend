package com.gestion.inventario.repositorio;

import com.gestion.inventario.dominio.Area;
import com.gestion.inventario.dominio.EstadoDispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoDispositivoRepository extends JpaRepository<EstadoDispositivo, Long> {

    Optional<EstadoDispositivo> findByNombre(String name);
}
