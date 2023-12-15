/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Ferrovia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author joão igor
 */
public interface FerroviaRepository extends JpaRepository<Ferrovia, Integer> {

    // Retorna os estados que são cruzados por uma ferrovia
    @Query(value = "SELECT ferro.ferrovia, estado.sigla_uf FROM Ferrovia ferro, Estado estado "
            + "WHERE (st_intersects(ferro.geom, estado.geom) = 'TRUE') "
            + "AND ferro.ferrovia LIKE %:nomeFerrovia%")
    public List<String> estadoPercurso(String nomeFerrovia);

    @Query(value = "SELECT ferro.ferrovia, estado.sigla_uf FROM Ferrovia ferro, Estado estado "
            + "WHERE (st_intersects(ferro.geom, estado.geom) = 'TRUE') "
            + "AND  estado.sigla_uf LIKE %:estadoSigla%")
    public List<String> ferroviaPorEstado(String estadoSigla);

}
