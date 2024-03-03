package com.gestion.inventario.repositorio;

import com.gestion.inventario.dominio.EstadoDispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoDispositivoRepository extends JpaRepository<EstadoDispositivo, Long> {
}
