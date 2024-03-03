package com.gestion.inventario.repositorio;

import com.gestion.inventario.dominio.TipoDispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDispositivoRepository extends JpaRepository<TipoDispositivo, Long> {
}
