/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Rodovia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jzmai
 */
public interface RodoviaRepository extends JpaRepository<Rodovia, Integer> {

// Retorna os estados que são cruzados por uma rodovia
    @Query(value = "SELECT rodo.descseg, estado.sigla_uf FROM Rodovia rodo, Estado estado "
            + "WHERE (st_intersects(rodo.geom, estado.geom) = 'TRUE') "
            + "AND rodo.descseg LIKE %:nomeRodovia%")
    public List<String> estadoPercurso(String nomeRodovia);
    
    @Query(value = "SELECT rodo.descseg, estado.sigla_uf FROM Rodovia rodo, Estado estado "
            + "WHERE (st_intersects(rodo.geom, estado.geom) = 'TRUE') "
            + "AND  estado.sigla_uf LIKE %:estadoSigla%")
    public List<String> rodoviasPorEstado(String estadoSigla);
     

}
