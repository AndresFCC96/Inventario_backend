package com.gestion.inventario.repositorio;

import com.gestion.inventario.dominio.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {

    Optional<Dispositivo> findByNombre(String name);

    Optional<Dispositivo> findByModelo(String name);

    Optional<Dispositivo> findByNumeroDeSerie(String name);

    Optional<Dispositivo> findByNumeroDeInventario(Long numero);
}
