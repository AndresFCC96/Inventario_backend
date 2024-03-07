package com.gestion.inventario.repositorio;

import com.gestion.inventario.dominio.Acciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccionRepository extends JpaRepository<Acciones, Long> {

    Optional<Acciones> findByNombreAccion(String name);
}
