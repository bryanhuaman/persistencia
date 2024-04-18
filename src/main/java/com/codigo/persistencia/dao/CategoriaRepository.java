package com.codigo.persistencia.dao;

import com.codigo.persistencia.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

//ACCESO A DATOS (ACCESO A BD)
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
