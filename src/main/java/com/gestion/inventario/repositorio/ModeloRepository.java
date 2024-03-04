package com.gestion.inventario.repositorio;

import com.gestion.inventario.dominio.Area;
import com.gestion.inventario.dominio.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    Optional<Modelo> findByNombre(String name);

}
