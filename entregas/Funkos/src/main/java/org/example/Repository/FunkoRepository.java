package org.example.Repository;

import org.example.Model.Funko;

import java.sql.SQLException;
import java.util.List;

public interface FunkoRepository extends CrudRepository<Funko, Long>{
    List<Funko> findByNombre(String nombre) throws SQLException;
}
